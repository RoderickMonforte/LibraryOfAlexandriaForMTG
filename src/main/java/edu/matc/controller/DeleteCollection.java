package edu.matc.controller;


import edu.matc.edit.CollectionEdit;
import edu.matc.entity.Collection;
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

/**
 * The type Delete collection.
 */
@WebServlet(
        urlPatterns = {"/deleteCollection"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class DeleteCollection extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = req.getSession(true);
        String userID = req.getRemoteUser();

        int collectionId = Integer.valueOf(req.getParameter
                ("collectionId"));

        deleteCollection(userID, collectionId, session);

        req.setAttribute("goodMessage","Collection deleted.");
        dispatcher = req.getRequestDispatcher("collection.jsp");
        dispatcher.forward(req, resp);

    }

    private void deleteCollection(String userID, int collectionId, HttpSession
            session) {
        CollectionDao dao = new CollectionDao();
        List<Collection> list = null;

        try {
            dao.deleteCollection(collectionId);
            list = dao.getAll(userID);
        } catch (Exception e) {
            log.error("Delete collection failed collection id =" +
                    collectionId, e);
        }

        session.setAttribute("collections", list);
    }
}
