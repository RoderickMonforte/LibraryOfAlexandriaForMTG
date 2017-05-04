package edu.matc.edit;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
import edu.matc.util.Alert;
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
    private Alert alert;
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
     * @param alert            this handles formatting
     */
    public NewUserEdit(String passwordText, String rePasswordText, String
            userIDName, String displayNameValue, Alert alert) {
        this();
        this.passwordText = passwordText;
        this.rePasswordText = rePasswordText;
        this.userIDName = userIDName;
        this.displayNameValue = displayNameValue;
        this.alert = alert;
    }

    /**
     * Check all user attributes validity
     *
     * @return true if all user attributes passed in are valid
     */
    public boolean userAttributeValid() {

        alert.initialize();

        userIDIsValid();
        displayNameValueIsValid();
        passwordIsValid();

        if (alert.goOn()) {
            alert.success("New user added.");
        }

        return alert.goOn();

    }

    /**
     * check display name against edits.
     *
     * @return true if display name value passes edit on display name.
     */
    public boolean displayNameValueIsValid() {

        alert.initField(1, "DisplayNameName", displayNameValue);
        if (displayNameValue.isEmpty()) {
            alert.error(1, "Display Name cannot be blank. Please enter valid " +
                    "value.");
        } else if (!displayNameValue.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            alert.error(1, "Only printable characters are valid for display " +
                    "name" +
                    ". Please enter valid value.");
        } else if (displayNameValue.length() < 5) {
            alert.error(1, "Display Name must be five characters or longer.");
        } else {
            alert.fieldPassed("DisplayNameName");
        }

        return alert.goOn();
    }

    /**
     * determine if the password meets valid criteria.
     *
     * @return true if password is valid against the password edits.
     */
    public boolean passwordIsValid() {

        alert.initField(2, "PasswordText", passwordText);
        alert.initField(3, "RePasswordText", rePasswordText);

        if (passwordText.isEmpty()) {
            alert.error(2,"Password is empty. Please enter a valid password.");
        } else if (!passwordText.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            alert.error(2,"Password contains invalid values. Please " +
                    "use visible characters only.");
        } else if (passwordText.length() < 5 && passwordText.length() > 12) {
            alert.error(2,"Password must be five to twelve characters long");
        } else if (!passwordText.equals(rePasswordText)) {
            alert.error(3,"Password does not match re-typed password. Please " +
                    "enter a valid password.");
        } else {
            alert.fieldPassed("PasswordText");
            alert.fieldPassed("RePasswordText");
        }

        return alert.goOn();

    }

    /**
     * determines if user id is valid
     *
     * @return true if user id is valid against the edits.
     */
    public boolean userIDIsValid() {
        UserDao userDao = new UserDao();
        User checkUser = null;

        alert.initField(0, "UserIdName", userIDName);

        try {
            checkUser = userDao.getUser(userIDName);
        } catch (Exception exception) {
            log.error("getUserID error",exception );
            alert.error(0,"System data is unavailable.");
        }

        if (checkUser != null) {
            alert.error(0,"Entered user ID is taken. Please enter a different" +
                    " " +
                    "user ID.");
        } else if (userIDName.isEmpty()) {
            alert.error(0,"User ID is empty. Please enter a valid user ID.");
        } else if (!userIDName.matches("^[a-zA-Z0-9]*$")) {
            alert.error(0,"User ID contains invalid values. Please use " +
                    "letters and numbers only.");
        } else if (userIDName.length() < 5) {
            alert.error(0, "User ID must be five characters or longer.");
        } else {
            alert.fieldPassed("UserIdName");
        }

        return alert.goOn();

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

}
