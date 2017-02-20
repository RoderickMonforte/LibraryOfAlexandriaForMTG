package edu.matc.controller;


import edu.matc.edit.NewUserEdit;
import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        NewUserEdit edit;

        String passwordText = req.getParameter("PasswordText");
        String rePasswordText = req.getParameter("RePasswordText");
        String userIDName = req.getParameter("UserIDName");
        String displayNameValue = req.getParameter("DisplayNameName");

        edit = new NewUserEdit(passwordText, rePasswordText, userIDName,
                displayNameValue);

        if (edit.userAttributeValid()) {
            addUser(userIDName, displayNameValue, passwordText);
            dispatcher = req.getRequestDispatcher("collection.jsp");
            dispatcher.forward(req, resp);
        } else { //redo entering new user info forms
            req.setAttribute("errorMessage",edit.getMessage());
            dispatcher = req.getRequestDispatcher("newUser.jsp");
            dispatcher.forward(req, resp);
        }

    }

    /**
     * This method adds the user
     */
    private void addUser(String userIDName, String displayNameValue, String
            passwordText) {
        User user = new User(userIDName,displayNameValue,passwordText);
        UserDao userDao = new UserDao();

        try {
            userDao.addUser(user);
        } catch (Exception exception) {
            log.error("Unable to add user ", exception);
        }
    }

}
