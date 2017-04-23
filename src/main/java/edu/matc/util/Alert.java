package edu.matc.util;

/**
 * Created by student on 4/20/17.
 */
public class Alert {
    private String message;
    private String type;
    private String hidden;
    private boolean goOn;

    /**
     * Instantiates a new Alert.
     */
    public Alert() {
        hidden = "\"hidden\"";
        type = " ";
        message = " ";
        goOn = true;
    }

    /**
     * Error.
     *
     * @param message the message
     */
    public void error(String message) {
        this.hidden = " ";
        this.type = "alert alert-danger";
        this.message = message;
        goOn = false;
    }

    /**
     * Warning.
     *
     * @param message the message
     */
    public void warning(String message) {
        this.hidden = " ";
        this.type = "alert alert-warning";
        this.message = message;
        goOn = true;
    }

    /**
     * Info.
     *
     * @param message the message
     */
    public void info(String message) {
        this.hidden = " ";
        this.type = "alert alert-info";
        this.message = message;
        goOn = true;
    }

    /**
     * Success.
     *
     * @param message the message
     */
    public void success(String message) {
        this.hidden = " ";
        this.type = "alert alert-success";
        this.message = message;
        goOn = true;
    }

    /**
     * Gets hidden.
     *
     * @return Value of hidden.
     */
    public String getHidden() {
        return hidden;
    }

    /**
     * Sets new type.
     *
     * @param type New value of type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets new message.
     *
     * @param message New value of message.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sets new hidden.
     *
     * @param hidden New value of hidden.
     */
    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    /**
     * Gets message.
     *
     * @return Value of message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets type.
     *
     * @return Value of type.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets goOn.
     *
     * @return Value of goOn.
     */
    public boolean goOn() {
        return goOn;
    }

    /**
     * Sets new goOn.
     *
     * @param goOn New value of goOn.
     */
    public void setGoOn(boolean goOn) {
        this.goOn = goOn;
    }
}
