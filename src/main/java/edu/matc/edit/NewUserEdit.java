package edu.matc.edit;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import org.apache.log4j.Logger;

/**
 * This is to validate new user
 * Created by student on 2/19/17.
 */
public class NewUserEdit {
    private String passwordText;
    private String rePasswordText;
    private String userIDName;
    private String displayNameValue;
    private String message;
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * Empty constructor
     */
    public NewUserEdit() {

    }

    /**
     * Initializing constructor
     *
     * @param passwordText     the password text
     * @param rePasswordText   the re password text
     * @param userIDName       the user id name
     * @param displayNameValue the display name value
     */
    public NewUserEdit(String passwordText, String rePasswordText, String userIDName, String displayNameValue) {
        this();
        this.passwordText = passwordText;
        this.rePasswordText = rePasswordText;
        this.userIDName = userIDName;
        this.displayNameValue = displayNameValue;
    }

    /**
     * Check all user attributes validity
     *
     * @return true if all user attributes passed in are valid
     */
    public boolean userAttributeValid() {
        if (userIDIsValid() && displayNameValueIsValid() && passwordIsValid()) {
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * check display name against edits.
     *
     * @return true if display name value passes edit on display name.
     */
    public boolean displayNameValueIsValid() {
        boolean allGood = true;

        if (displayNameValue.isEmpty()) {
            message = "Display Name cannot be blank. Please enter valid value.";
            allGood = false;
        } else if (!displayNameValue.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            message = "Only printable characters are valid for display name." +
                    "Please enter valid value.";
            allGood = false;
        } else if (displayNameValue.length() < 5) {
            message = "Display Name must be five characters or longer.";
            allGood = false;
        }

        return allGood;
    }

    /**
     * determine if the password meets valid criteria.
     *
     * @return true if password is valid against the password edits.
     */
    public boolean passwordIsValid() {
        boolean  allGood = true;

        if (passwordText.isEmpty()) {
            message = "Password is empty. Please enter a valid password.";
            allGood = false;
        } else if (!passwordText.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            message = "Password contains invalid values. Please use visible " +
                    "characters only.";
            allGood = false;
        } else if (passwordText.length() < 5) {
            message = "Password must be five characters or longer";
            allGood = false;
        } else if (!passwordText.equals(rePasswordText)) {
            message = "Password does not match re-typed password. Please " +
                    "enter a valid password.";
            allGood = false;
        }

        return allGood;

    }

    /**
     * determines if user id is valid
     *
     * @return true if user id is valid against the edits.
     */
    public boolean userIDIsValid() {
        boolean allGood = true;
        UserDao userDao = new UserDao();
        User checkUser = null;

        try {
            checkUser = userDao.getUser(userIDName);
        } catch (Exception exception) {
            log.error("getUserID error",exception );
        }

        if (checkUser != null) {
            allGood = false;
            message = "Entered user ID is taken. Please enter a different " +
                    "user ID.";
        } else if (userIDName.isEmpty()) {
            allGood = false;
            message = "User ID is empty. Please enter a valid user ID.";
        } else if (!userIDName.matches("^[a-zA-Z0-9]*$")) {
            allGood = false;
            message = "User ID contains invalid values. Please use letters " +
                    "and numbers only.";
        } else if (userIDName.length() < 5) {
            allGood = false;
            message = "User ID must be five characters or longer.";
        }

        return allGood;

    }

    /**
     * Sets new userIDName.
     *
     * @param userIDName New value of userIDName.
     */
    public void setUserIDName(String userIDName) {
        this.userIDName = userIDName;
    }

    /**
     * Gets userIDName.
     *
     * @return Value of userIDName.
     */
    public String getUserIDName() {
        return userIDName;
    }

    /**
     * Sets new displayNameValue.
     *
     * @param displayNameValue New value of displayNameValue.
     */
    public void setDisplayNameValue(String displayNameValue) {
        this.displayNameValue = displayNameValue;
    }

    /**
     * Sets new passwordText.
     *
     * @param passwordText New value of passwordText.
     */
    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
    }

    /**
     * Gets displayNameValue.
     *
     * @return Value of displayNameValue.
     */
    public String getDisplayNameValue() {
        return displayNameValue;
    }

    /**
     * Gets passwordText.
     *
     * @return Value of passwordText.
     */
    public String getPasswordText() {
        return passwordText;
    }

    /**
     * Gets rePasswordText.
     *
     * @return Value of rePasswordText.
     */
    public String getRePasswordText() {
        return rePasswordText;
    }

    /**
     * Sets new rePasswordText.
     *
     * @param rePasswordText New value of rePasswordText.
     */
    public void setRePasswordText(String rePasswordText) {
        this.rePasswordText = rePasswordText;
    }

    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }
}
