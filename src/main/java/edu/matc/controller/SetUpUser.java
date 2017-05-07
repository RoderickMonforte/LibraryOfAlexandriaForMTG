package edu.matc.controller;


import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
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
        urlPatterns = {"/setUpUser"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class SetUpUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    private HttpSession session;
    private User user;

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

        getUser();
        dispatcher = req.getRequestDispatcher("updateUser.jsp");
        dispatcher.forward(req, resp);

    }

    /**
     * This gets the card for detail viewing and editing.
     */
    private void getUser() {
        UserDao dao = new UserDao();
        user = (User) session.getAttribute("user");
        session.setAttribute("rePasswordText", user.getPasswordText());

    }


}
