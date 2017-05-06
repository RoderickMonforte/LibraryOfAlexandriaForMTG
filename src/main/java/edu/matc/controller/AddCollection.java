package edu.matc.controller;


import edu.matc.edit.CollectionEdit;
import edu.matc.entity.Collection;
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

@WebServlet(
        urlPatterns = {"/addCollection"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class AddCollection extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private Alert alert = new Alert(3);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        CollectionEdit edit;
        HttpSession session = req.getSession(true);

        String collectionName = req.getParameter("CollectionName");
        String descriptionText = req.getParameter("DescriptionText");
        String noteText = req.getParameter("NoteText");
        String userID = req.getRemoteUser();

        edit = new CollectionEdit(collectionName, descriptionText, noteText,
                alert);

        /*
         If new user passed all edits
            logged the user
            set session variables
            and forward to the collection webpage
         else forward to New User form again
         */

        if (edit.collectionAttributeValid()) {
            session.removeAttribute("collections");
            session.setAttribute("collections", addCollection(userID,
                    collectionName, descriptionText, noteText));

            alert.normalize();
        }

        req.setAttribute("alert", alert);

        dispatcher = req.getRequestDispatcher("collection.jsp");
        dispatcher.forward(req, resp);

    }


    /**
     * This method adds the user
     */
    private List<Collection> addCollection(String userID, String collectionName,
                                     String
            descriptionText, String noteText) {
        List<Collection> collections = null;

        Collection collection = new Collection(userID, collectionName,
                descriptionText, noteText, (long) 0, 0);
        CollectionDao dao = new CollectionDao();

        try {
            dao.addCollection(collection);
            collections = (List<Collection>) dao.getAll(userID);
        } catch (Exception exception) {
            log.error("Unable to add collection ", exception);
        }

        log.info("After Adding");

        return collections;
    }
}
