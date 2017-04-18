package edu.matc.controller;


import edu.matc.entity.CardItem;
import edu.matc.entity.CardLocal;
import edu.matc.entity.Collection;
import edu.matc.persistence.CardDao;
import edu.matc.persistence.CardItemDao;
import edu.matc.persistence.CollectionDao;
import edu.matc.util.CardPrice;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
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
import java.util.ArrayList;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
       // CardLocalEdit edit;
        HttpSession session = req.getSession(true);

        String stringId = req.getParameter("TheChoice");
        int ownedQuantity = Integer.valueOf(req.getParameter("OwnedCount"));
        int wishList = Integer.valueOf(req.getParameter("WishCount"));
        String noteText = req.getParameter("NoteText").trim();
        Collection collection = (Collection) session.getAttribute("collection");
        CardItem cardItem = getCardItem(Integer.valueOf(stringId));
        List<CardLocal> cardLocals = new ArrayList<CardLocal>();

        cardLocals.add(addCardToCollection(cardItem, collection
                .getCollectionId(), ownedQuantity, wishList, noteText));


        session.setAttribute("collection", collection);
        session.setAttribute("cards", cardLocals);

        req.setAttribute("goodMessage", "New card added.");

            dispatcher = req.getRequestDispatcher("cardList.jsp");
            dispatcher.forward(req, resp);

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
        CollectionDao daoSet = new CollectionDao();
        Double totalPrice = (double) ownedQuantity * cardItem.getPrice();
        CardLocal cardLocal = new CardLocal(collectionId, cardItem
                .getUniversalCardId(), ownedQuantity,
                wishList, noteText, totalPrice, cardItem);

        try {
            int id = dao.addCardLocal(cardLocal);
            cardLocal.setUniversalCardId(id);
            daoSet.updateCollection(collectionId, ownedQuantity, totalPrice);
        } catch (SQLException err) {
            log.info("Card already in the collection");
        } catch (Exception e) {
            log.error("Error adding card to collection " + e.getMessage());
        }

        return cardLocal;
    }


    /**
     * This method adds the chosen card for reference.
     * @param multiverseId
     * @return
     */
    private CardItem addCardItem(int multiverseId) {
        Card card = CardAPI.getCard(multiverseId);
        CardItemDao dao = new CardItemDao();
        CardItem cardItem = null;
        int universeId = 0;

        try {
            cardItem = new CardItem(card, CardPrice.getPrice(card.getName
                    (), card.getSetName()));
            universeId = dao.addCardItem(cardItem);
            cardItem.setUniversalCardId(universeId);
        } catch (HibernateException h) {
            log.error("Error adding card to cardItem" + h.getMessage());
        } catch (Exception e) {
            log.error("Error getting price of card " + card.getName() + " " +
                    e.getMessage());
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
            log.error("Error adding card to cardItem" + err.getMessage());
        } catch (Exception e) {
            log.error("Error getting price of card " + cardItem.getCardName() +
                    " " + e.getMessage());
        }

        if (cardItem == null) {
            cardItem = addCardItem(multiverseId);
        }

        return cardItem;
    }



}
