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
        urlPatterns = {"/deleteCard"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class DeleteCard extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    Alert alert;
    HttpServletRequest request;
    HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        alert = new Alert();
        request = req;
        session = req.getSession(true);

        deleteCard();

        if (alert.goOn()) {
            alert.success("Card deleted from collection");
        }

        dispatcher = req.getRequestDispatcher("cardList.jsp");
        dispatcher.forward(req, resp);

    }

    /**
     * This deletes the card from the collection and updates the card list
     */
    private void deleteCard() {
        CardDao dao = new CardDao();
        Collection collection = (Collection) session.getAttribute("collection");
        int cardId = Integer.valueOf(request.getParameter("cardId"));
        List<CardLocal> cards = null;

        try {
            dao.deleteCardLocal(cardId);
            cards = dao.getAll(collection.getCollectionId());
            session.removeAttribute("cards");
            session.setAttribute("cards", cards);
            updateCollection(collection.getCollectionId());
        } catch (Exception e) {
            String message ="Error deleting card " + e.getMessage();
            log.error(message);
            alert.error(message);
        }
    }

    /**
     * This updates the collection after card is deleted and updates the
     * collection in session
     * @param collectionId
     */
    private void updateCollection(int collectionId) {
        CollectionDao daoSet = new CollectionDao();
        Collection collection = null;

        try {
            daoSet.updateCollection(collectionId);
            collection = daoSet.getOne(collectionId);
            session.removeAttribute("collection");
            session.setAttribute("collection", collection);
        } catch (Exception e) {
            String message ="Error updating collection because of deleted card "
                    + e.getMessage();
            log.error(message);
            alert.error(message);
        }
    }

}
