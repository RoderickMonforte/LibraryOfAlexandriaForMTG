package edu.matc.entity;


import javax.persistence.*;

/**
 * Created by student on 2/12/17.
 * This represent the User entity
 */
@Entity
@Table(name = "User")
public class User {
    //This is the user id given by the user at time of sign up.
    @Id
    @Column(name = "user_id")
    private String userId;

    //This is the named chosen by the user to display on the web application
    @Column(name = "display_nm")
    private String displayName;

    //This is the password given by the user to use to authenticate the user.
    @Column(name = "password_tx")
    private String passwordText;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userId       the user id
     * @param displayName  the display name
     * @param passwordText the password text
     */
    public User(String userId, String displayName, String passwordText) {
        this();
        this.userId = userId;
        this.displayName = displayName;
        this.passwordText = passwordText;
    }

    /**
     * Sets new displayName.
     *
     * @param displayName New value of displayName.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets displayName.
     *
     * @return Value of displayName.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Gets userId.
     *
     * @return Value of userId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets new userId.
     *
     * @param userId New value of userId.
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * Sets new passwordText.
     *
     * @param passwordText New value of passwordText.
     */
    public void setPasswordText(String passwordText) {
        this.passwordText = passwordText;
    }

    /**
     * This is an override of the toString method.
     */
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", passwordText='" + passwordText + '\'' +
                '}';
    }
}

