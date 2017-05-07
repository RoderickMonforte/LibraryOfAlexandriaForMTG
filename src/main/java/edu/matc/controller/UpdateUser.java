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
        urlPatterns = {"/updateUser"}
)
/**
 * This is the controller for adding new user
 * Created by student on 2/18/17.
 */
public class UpdateUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());
    User user;
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

        if (edit.userAttributeValidForUpdate()) {
            User user = updateUser(userIDName, displayNameValue, passwordText);
            session.setAttribute("user", user);
            session.setAttribute("isLoggedIn",true);
            dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        } else { //redo entering new user info forms
            user = new User(userIDName, displayNameValue, passwordText);
            session.removeAttribute("user");
            session.removeAttribute("rePasswordtext");
            session.setAttribute("user", user);
            session.setAttribute("rePasswordText", rePasswordText);
            dispatcher = req.getRequestDispatcher("updateUser.jsp");
            dispatcher.forward(req, resp);
        }

    }

    /**
     * This method adds the user
     */
    private User updateUser(String userIDName, String displayNameValue, String
            passwordText) {
        user = new User(userIDName,displayNameValue,passwordText);
        UserDao userDao = new UserDao();

        try {
            userDao.updateUser(user);
        } catch (Exception exception) {
            log.error("Unable to update user ", exception);
            alert.error("Unable to update user. Try again.");
        }

        return user;
    }

}
