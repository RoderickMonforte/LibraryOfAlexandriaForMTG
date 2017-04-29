package edu.matc.controller;

import edu.matc.entity.CardItem;
import edu.matc.entity.CardLocal;
import edu.matc.entity.Collection;
import edu.matc.persistence.CardDao;
import edu.matc.persistence.CardItemDao;
import edu.matc.persistence.CollectionDao;
import edu.matc.util.Alert;
import edu.matc.util.GetWeb;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by student on 4/28/17.
 */
@WebServlet(
        name = "updatePrice",
        urlPatterns = { "/updatePrice" }
)

public class UpdatePrice extends HttpServlet {

    @Resource
    private ConnectionFactory connectionFactory;

    @Resource(name = "CollectionSuperUpdate")
    private Queue updateQueue;

    private final Logger log = Logger.getLogger(this.getClass());
    private HttpServletRequest request;
    private HttpSession session;
    private int multiverseId;
    private Alert alert = new Alert();
    private CardItemDao itemDao = new CardItemDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        multiverseId = Integer.valueOf(req.getParameter("MultiverseId"));
        session = req.getSession();
        request = req;

        getCard(multiverseId);

        req.setAttribute("alert", alert);
        RequestDispatcher dispatcher = req.getRequestDispatcher("cardDetail" +
                ".jsp");
        dispatcher.forward(req, resp);
    }

    /**
     * this gets the card for price checking
     * @param multiverseId
     */
    private void getCard(int multiverseId) {
        CardItem item = null;

        try {
            item = itemDao.getCardItemMultiverseId(multiverseId);
            checkPrice(item);
        } catch (Exception e) {
            String error = "Unable to get card multiverseId#" + multiverseId +
                    " " + e.getMessage();
            log.error(error);
            alert.error(error);
        }
    }

    /**
     * this checks for the card price on the web
     * @param item
     */
    private void checkPrice(CardItem item) {
        double webPrice = 0.0;
        alert.success("Card price is current. No update needed.");

        try {
            webPrice = GetWeb.getPrice(item.getCardName(), item.getSetName());
            if (item.getPrice() != webPrice) {
                item.setPrice(webPrice);
                updateCardPrice(item);
            }
        } catch (Exception e) {
            String error = "Unable to get card price#" + multiverseId + " " + e
                    .getMessage();
            log.error(error);
            alert.error(error);
        }
    }

    /**
     * Update the reference Card price
     * @param item
     */
    private void updateCardPrice(CardItem item) {
        Collection collection = (Collection) session.getAttribute("collection");

        try {
            itemDao.updateCardItem(item);
            updateCardInCollection(item, collection.getCollectionId());
        } catch (Exception e) {
            String error = "Unable to update card price#" + multiverseId + " "
                    + e.getMessage();
            log.error(error);
            alert.error(error);
        }
    }

    /**
     * Update the local card in a collection with price from reference card
     * @param item
     * @param collectionId
     */
    private void updateCardInCollection(CardItem item, int collectionId) {
        CardDao cardDao = new CardDao();
        CardLocal cardLocal = null;
        List<CardLocal> cards = null;
        double newPrice = item.getPrice();
        int ownedCount = 0;

        try {
            cardLocal = cardDao.getCardInCollection(collectionId, item
                    .getUniversalCardId());
            ownedCount = cardLocal.getOwnedQuantity();
            Double newOwnedPrice = (double) newPrice * ownedCount;
            cardLocal.setPriceAmount(newOwnedPrice);
            cardDao.updateCardLocal(cardLocal);
            cards = cardDao.getAll(collectionId);
            session.setAttribute("cards", cards);
            session.setAttribute("card", cardLocal);
            updateCollectionPrice(cardLocal.getCollectionId(), cardLocal.getCardId(),
                    cardLocal.getUniversalCardId(), newPrice);
            alert.success("Card price and collection updated.");
        } catch (Exception e) {
            String error = "Unable to update card price#" + item.getUniversalCardId() + " "
                    + e.getMessage();
            log.error(error);
            alert.error(error);
        }

    }

    private void updateCollectionPrice(int collectionId, int cardId, int id,
               double newPrice) {
        CollectionDao collectDao = new CollectionDao();
        Collection collection = null;
        String message = "collectionId=" + collectionId
                + ";cardId=" + cardId
                + ";universalId="+id
                + ";newPrice=" + newPrice;

        try {
            collectDao.updateCollection(collectionId);
            collection = collectDao.getOne(collectionId);
            session.setAttribute("collection", collection);
            run(message);
        } catch (Exception e) {
            String error = "Unable to update collection#" + collectionId + " "
                    + e.getMessage();
            log.error(error);
            alert.error(error);
        }
    }

    public void run(String message) {

        Session session = null;
        Connection connection = null;

        try {

            connection = connectionFactory.createConnection();

            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            final MessageProducer questions = session.createProducer
                    (updateQueue);

            questions.send(session.createTextMessage(message));

        } catch (Exception exception) {
            String error = "Unable to send message " + exception.getMessage();
            log.error(error);
            alert.error(error);
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception exception) {
                String error = "Unable to close channels " + exception
                        .getMessage();
                log.error(error);
                alert.error(error);
            }
        }
    }
}