package edu.matc.controller;


import edu.matc.entity.CardLocal;
import edu.matc.entity.Collection;
import edu.matc.persistence.CardDao;
import edu.matc.persistence.CollectionDao;
import edu.matc.util.Alert;
import org.apache.log4j.Logger;

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
 * The type Delete collection.
 */
@WebServlet(
        urlPatterns = {"/updateCard"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class UpdateCard extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private HttpServletRequest request;
    private HttpSession session;
    private Alert alert;

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        alert = new Alert();
        session = req.getSession(true);
        request = req;

        updateCardLocal();
        request.setAttribute("alert", alert);
        if (alert.goOn()) {
            dispatcher = req.getRequestDispatcher("cardDetail.jsp");
            dispatcher.forward(req, resp);
        } else {
            request.setAttribute("alert", alert);
        }
    }

    /**
     * This updates the card of counts and notes
     */
    private void updateCardLocal() {
        CardDao dao = new CardDao();
        String cardIdString = request.getParameter("CardId");
        int cardId = Integer.valueOf(cardIdString);
        double oldPrice = 0.0;
        double newPrice = 0.0;
        CardLocal oldCard = null;
        List<CardLocal> cards = null;

        String noteText = request.getParameter("NoteText");
        int ownedCount = Integer.valueOf(request.getParameter("OwnedCount"));
        int wishCount = Integer.valueOf(request.getParameter("WishCount"));

        try {
            oldCard = dao.getOne(cardId);
            oldCard.setNoteText(noteText);
            oldCard.setOwnedQuantity(ownedCount);
            oldCard.setWishList(wishCount);

            newPrice = (double) ownedCount * oldCard.getCardItemById()
                    .getPrice();
            oldCard.setPriceAmount(newPrice);

            dao.updateCardLocal(oldCard);
            cards = dao.getAll(oldCard.getCollectionId());
            updateCollection(oldCard.getCollectionId());

            session.setAttribute("card", oldCard);
            session.setAttribute("cards", cards);
            alert.success("Update successful!");

        } catch (Exception e) {
            String error = "Could not process card# " + cardId + " " + e
                    .getMessage();
            log.error(error);
            alert.error(error);
        }
    }

    private void updateCollection(int collectionId) {
        CollectionDao dao = new CollectionDao();
        Collection collection;

        try {
            dao.updateCollection(collectionId);
            collection = dao.getOne(collectionId);
            session.setAttribute("collection", collection);

        } catch (Exception e) {
            String error = "Could not process collection # " + collectionId +
                    " " + e.getMessage();
            log.error(error);
            alert.error(error);
        }

    }

}
