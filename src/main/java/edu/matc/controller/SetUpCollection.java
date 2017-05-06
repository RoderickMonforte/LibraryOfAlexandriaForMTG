package edu.matc.controller;

import edu.matc.entity.Collection;
import edu.matc.entity.User;
import edu.matc.persistence.CollectionDao;
import edu.matc.persistence.UserDao;
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
        urlPatterns = {"/setUpCollection"}
)
/**
 * This is used to setup Collection page. Gets collections for the users
 * Created by student on 2/22/17.
 */
public class SetUpCollection extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private Alert alert = new Alert(3);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = req.getSession(true);
        User user = getUser(req, session);
        List<Collection> collections = setUp(user.getUserId());

        session.removeAttribute("collections");
        session.setAttribute("collections", collections);
        req.setAttribute("alert", alert);

        dispatcher = req.getRequestDispatcher("collection.jsp");
        dispatcher.forward(req, resp);
    }

    private List<Collection> setUp(String userId) {
        List<Collection> collections = null;

        try {
            collections = (List<Collection>) new CollectionDao().getAll(userId);
        } catch (Exception e) {
            String error = "Error getting all collections for user " + userId;
            log.error( error + " ", e);
            alert.error(error);
        }

        return collections;

    }

    private User getUser(HttpServletRequest request, HttpSession session) {
        String userId = null;
        User user = (User) session.getAttribute("user");
        UserDao userDao = new UserDao();

        if (user == null) {
            userId = request.getRemoteUser();

            try {
                user = userDao.getUser(userId);
            } catch (Exception e) {
                String error = "Error getting User " + userId;
                log.error(error + " ", e);
                alert.error(error);
            }

            session.setAttribute("user", user);
            session.setAttribute("isLoggedIn",true);
        }

        return user;
    }
}
