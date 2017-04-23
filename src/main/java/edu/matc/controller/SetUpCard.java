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

/**
 * The type Delete collection.
 */
@WebServlet(
        urlPatterns = {"/setUpCard"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class SetUpCard extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private HttpServletRequest request;
    private HttpServletResponse response;
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
        session = req.getSession(true);
        request = req;

        getCardLocal();

        dispatcher = req.getRequestDispatcher("cardDetail.jsp");
        dispatcher.forward(req, resp);

    }

    private void getCardLocal() {
        CardDao dao = new CardDao();
        CollectionDao daoCollect = new CollectionDao();
        CardLocal cardLocal = null;
        Collection collection = null;
        int cardId = Integer.valueOf(request.getParameter("cardId"));

        try {
            cardLocal = dao.getOne(cardId);
            collection = daoCollect.getOne(cardLocal.getCollectionId());
            request.setAttribute("collection", collection);
            request.setAttribute("card", cardLocal);
        } catch (Exception e) {
            String error = "Could not find card# " + cardId + " " + e
                    .getMessage();
            log.error(error);
            alert.error(error);
        }
    }


}