package edu.matc.controller;


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
        urlPatterns = {"/updateCollection"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class UpdateCollection extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

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
        HttpSession session = req.getSession(true);
        String userID = req.getRemoteUser();
        String test = req.getParameter("collectionId");
        String[] parameters = req.getParameter("mode").split(";");
        String mode = parameters[0];
        int collectionId = Integer.valueOf(parameters[1]);

        String target = process(req, session, mode, userID, collectionId);

        dispatcher = req.getRequestDispatcher(target);
        dispatcher.forward(req, resp);

    }


    /**
     * @param req
     * @param session
     * @param mode
     * @param id
     * @return
     */
    private String process(HttpServletRequest req, HttpSession session,
            String mode, String userID, int id) {
        String target = null;

        if (mode.equals("preUpdate")) {
            session.setAttribute("updateId",id);
            target = "updateCollection.jsp";

        } else if (mode.equals("updateReady")) {
            updateCollection(req, session,userID, id);
            target = "collection.jsp";
        } else {
            target = "collection.jsp";
        }

        return target;
    }

    /**
     * @param req
     * @param id
     */
    private void updateCollection(HttpServletRequest req, HttpSession session,
            String userID, int id) {
        CollectionDao dao = new CollectionDao();
        Collection collection = new Collection();
        collection.setCollectionId(id);
        collection.setUserId(userID);
        collection.setDisplayName(req.getParameter("UpdateName"));
        collection.setDescriptionText(req.getParameter("UpdateDescription"));
        collection.setNoteText(req.getParameter("UpdateNote"));
        collection.setCardQuantity(Integer.valueOf(req.getParameter("UpdateQuantity")));
        collection.setPriceAmount(Double.valueOf(req.getParameter
                ("UpdateAmount")));

        try {
            dao.updateCollection(collection);
            session.setAttribute("collections", (List<Collection>) dao.getAll
                    (userID));
        } catch (Exception e) {
            log.error("Update failed for collection id = " + id, e);
        }

        req.setAttribute("goodMessage","Collection updated.");

    }

}
