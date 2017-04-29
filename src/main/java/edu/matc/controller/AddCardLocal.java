package edu.matc.controller;


import edu.matc.entity.CardItem;
import edu.matc.entity.CardLocal;
import edu.matc.entity.Collection;
import edu.matc.persistence.CardDao;
import edu.matc.persistence.CardItemDao;
import edu.matc.persistence.CollectionDao;
import edu.matc.util.Alert;
import edu.matc.util.GetWeb;
import io.magicthegathering.api.Card;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/addCardLocal"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class AddCardLocal extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private Alert alert = new Alert();
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        alert.success("New card added");
        session = req.getSession(true);

        String stringId = req.getParameter("TheChoice");
        int ownedQuantity = Integer.valueOf(req.getParameter("OwnedCount"));
        int wishList = Integer.valueOf(req.getParameter("WishCount"));
        String noteText = req.getParameter("NoteText").trim();
        Collection collection = (Collection) session.getAttribute("collection");
        CardItem cardItem = getCardItem(Integer.valueOf(stringId));
        List<CardLocal> cardLocals = getAllCardsInCollection(collection.getCollectionId());

        if (alert.goOn()) {
            cardLocals.add(addCardToCollection(cardItem, collection
                    .getCollectionId(), ownedQuantity, wishList, noteText));
        }

        session.setAttribute("cards", cardLocals);

        req.setAttribute("alert", alert);

        dispatcher = req.getRequestDispatcher("cardList.jsp");
        dispatcher.forward(req, resp);

    }

    /**
     * Gets all cards in a collection
     * @param collectionId
     * @return
     */
    private List<CardLocal> getAllCardsInCollection(int collectionId) {
        CardDao dao = new CardDao();
        List<CardLocal> lists = null;

        try {
            lists = dao.getAll(collectionId);
        } catch (Exception e) {
            String errorMessage = "Error getting cards in this collection "+ collectionId
                    + " " + e.getMessage();
            log.error(errorMessage);
            alert.error(errorMessage);
        }

        return lists;
    }

    /**
     * this method add the card chosen into the collection
     * @param cardItem
     * @param collectionId
     * @param ownedQuantity
     * @param wishList
     * @param noteText
     * @return
     */
    private CardLocal addCardToCollection(CardItem cardItem, int
            collectionId, int ownedQuantity, int wishList, String noteText) {

        CardDao dao = new CardDao();
        Double totalPrice = (double) ownedQuantity * cardItem.getPrice();
        CardLocal cardLocal = new CardLocal(collectionId, cardItem
                .getUniversalCardId(), ownedQuantity,
                wishList, noteText, totalPrice, cardItem);

        try {
            int id = dao.addCardLocal(cardLocal);
            cardLocal.setUniversalCardId(id);
            updateCollection(collectionId);

        } catch (SQLException err) {
            String message = "Card already in the collection";
            log.info(message);
            alert.info(message);
        } catch (Exception e) {
            String message ="Error adding card to collection " + e.getMessage();
            log.error(message);
            alert.error(message);
        }

        return cardLocal;
    }

    private void updateCollection(int collectionId) {
        CollectionDao daoSet = new CollectionDao();
        Collection collection = null;

        try {

            daoSet.updateCollection(collectionId);
            collection = daoSet.getOne(collectionId);
            session.setAttribute("collection", collection);

        } catch (Exception e) {
            String message ="Error updating card to collection " + e
                    .getMessage();
            log.error(message);
            alert.error(message);
        }

    }


    /**
     * This method adds the chosen card for reference.
     * @param multiverseId
     * @return
     */
    private CardItem addCardItem(int multiverseId) {
        CardItemDao dao = new CardItemDao();
        CardItem cardItem = null;
        Card card = null;
        int universeId = 0;

        try {
            card = GetWeb.getCard(multiverseId);
            cardItem = new CardItem(card, GetWeb.getPrice(card.getName
                    (), card.getSetName()));
            universeId = dao.addCardItem(cardItem);
            cardItem.setUniversalCardId(universeId);
        } catch (HibernateException h) {
            String message = "Error adding card to cardItem" + h.getMessage();
            log.error(message);
            alert.error(message);
        } catch (Exception e) {
            String message = "Error getting price of card " + card.getName() + " " +
                    e.getMessage();
            log.error(message);
            alert.error(message);
        }

        return cardItem;
    }

    /**
     * This method gets the chosen card from reference.
     * @param multiverseId
     * @return card
     */
    private CardItem getCardItem(int multiverseId) {
        CardItemDao dao = new CardItemDao();
        CardItem cardItem = null;


        try {
            cardItem = dao.getCardItemMultiverseId(multiverseId);
        } catch (SQLException err) {
            String message = "Error adding card to cardItem" + err.getMessage
                    ();
            log.error(message);
            alert.error(message);

        } catch (Exception e) {
            String message = "Error getting price of card " + cardItem.getCardName() +
                    " " + e.getMessage();
            log.error(message);
            alert.error(message);
        }

        if (cardItem == null) {
            cardItem = addCardItem(multiverseId);
        }

        return cardItem;
    }



}
