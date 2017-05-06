package edu.matc.controller;


import edu.matc.edit.NewUserEdit;
import edu.matc.entity.User;
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

@WebServlet(
        urlPatterns = {"/addUser"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class AddUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    Alert alert = new Alert(4);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        NewUserEdit edit;
        HttpSession session = req.getSession(true);


        String passwordText = req.getParameter("PasswordText");
        String rePasswordText = req.getParameter("RePasswordText");
        String userIDName = req.getParameter("UserIDName");
        String displayNameValue = req.getParameter("DisplayNameName");

        edit = new NewUserEdit(passwordText, rePasswordText, userIDName,
                displayNameValue, alert);

        /*
         If new user passed all edits
            logged the user
            set session variables
            and forward to the collection webpage
         else forward to New User form again
         */
        req.setAttribute("alert", alert);

        if (edit.userAttributeValid()) {
            User user = addUser(userIDName, displayNameValue, passwordText);
            loginUser(req, userIDName, passwordText);
            session.setAttribute("user", user);
            session.setAttribute("isLoggedIn",true);
            dispatcher = req.getRequestDispatcher("collection.jsp");
            dispatcher.forward(req, resp);
        } else { //redo entering new user info forms
            dispatcher = req.getRequestDispatcher("newUser.jsp");
            dispatcher.forward(req, resp);
        }

    }

    /**
     * This logs the user after creating a new user
     * @param request
     * @param userID
     * @param passwordText
     */
    private void loginUser(HttpServletRequest request, String userID, String
            passwordText) {

        try {
            request.login(userID, passwordText);
        } catch (ServletException e) {
            log.error("Failed to Login after Add User", e);
            alert.error("Unable to log new user. Try again.");
        }

    }

    /**
     * This method adds the user
     */
    private User addUser(String userIDName, String displayNameValue, String
            passwordText) {
        User user = new User(userIDName,displayNameValue,passwordText);
        UserDao userDao = new UserDao();

        try {
            userDao.addUser(user);
        } catch (Exception exception) {
            log.error("Unable to add user ", exception);
        }

        return user;
    }

}
