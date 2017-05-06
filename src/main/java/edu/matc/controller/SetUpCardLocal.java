package edu.matc.controller;

import edu.matc.entity.CardLocal;
import edu.matc.entity.Collection;
import edu.matc.persistence.CardDao;
import edu.matc.persistence.CollectionDao;
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

@WebServlet(
        urlPatterns = {"/setUpCardLocal"}
)
/**
 * This is used to setup Collection page. Gets collections for the users
 * Created by student on 2/22/17.
 */
public class SetUpCardLocal extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = req.getSession(true);
        Collection collection = null;
        List<CardLocal> cardLocals = null;
        String collectionIdString = req.getParameter("collectionId");
        int collectionId = -1;

        if (collectionIdString == null) {
            collection = (Collection) session.getAttribute("collection");
            collectionId = collection.getCollectionId();
        } else {
            collectionId = Integer.valueOf(collectionIdString);
            collection = getCollection(collectionId);
        }

        cardLocals = setUp(collectionId);
        session.removeAttribute("collection");
        session.setAttribute("collection", collection);

        if (cardLocals.size()==0) {

            dispatcher = req.getRequestDispatcher("addCard.jsp");
            dispatcher.forward(req, resp);

        } else {
            session.removeAttribute("cards");
            session.setAttribute("cards", cardLocals);

            dispatcher = req.getRequestDispatcher("cardList.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private Collection getCollection(int collectionId) {
        Collection collection = null;

        try {
            collection = new CollectionDao().getOne(collectionId);
        } catch (Exception e) {
            log.error("Error getting collection " +
                    collectionId + " ", e);
        }

        return collection;

    }

    private List<CardLocal> setUp(int collectionId) {
        List<CardLocal> cardLocals = null;

        try {
            cardLocals = (List<CardLocal>) new CardDao().getAll(collectionId);
        } catch (Exception e) {
            log.error("Error getting all cards for collection " +
                    collectionId + " ", e);
        }

        return cardLocals;

    }
}
