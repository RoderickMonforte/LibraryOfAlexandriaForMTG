package edu.matc.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 4/20/17.
 */
public class Alert {
    private String message;
    private String type;
    private String hidden;
    private List<Field> fields;
    private boolean goOn;

    /**
     * Instantiates a new Alert
     */
    public Alert() {
        hidden = "\"hidden\"";
        type = " ";
        message = " ";
        goOn = true;
    }

    /**
     * Instantiates a new Alert with field formatting
     */
    public Alert(int fieldCount) {
        this();

        fields = new ArrayList<Field>();

        for (int i = 0; i < fieldCount; i++) {
            fields.add(new Field());
            initField(i, "", "");
        }
    }

    /**
     * Sets the alert to its starting value.
     */
    public void initialize() {
        hidden = "\"hidden\"";
        type = " ";
        message = " ";
        goOn = true;
    }

    /**
     * field format with passed
     * @param name
     */
    public void fieldPassed(String name) {
        Field field = getField(name);

        field.setSuccess();
    }

    /**
     * Make all fields normal so it does not show span
     */
    public void normalize() {
        for (Field field : fields) {
            field.setNormal();
            field.setValue("");
        }
    }

    /**
     * initialize field with name and format.
     * @param index
     * @param name
     */
    public void initField(int index, String name, String value) {
        fields.get(index).setName(name);
        fields.get(index).setValue(value);
        fields.get(index).setNormal();
    }

    /**
     * Error.
     *
     * @param message the message
     */
    public void error(String message) {
        this.hidden = " ";
        this.type = "alert alert-danger";
        goOn = false;
        if (this.message.length() > 0) {
            this.message = this.message + "<br><strong>Error: </strong>" +
                    message;
        } else {
            this.message = "<strong>Error: </strong>" + message;
        }

    }

    /**
     * set message and field in error format
     * @param index
     * @param message
     */
    public void error(int index, String message) {
        error(message);
        fields.get(index).setError();
    }

    /**
     * Warning.
     *
     * @param message the message
     */
    public void warning(String message) {
        this.hidden = " ";
        this.type = "alert alert-warning";
        this.message = "<strong>Warning: </strong>" + message;
        goOn = true;
    }


    /**
     * warning and set field values
     * @param index
     * @param message
     */
    public void warning(int index, String message) {
        warning(message);
        fields.get(index).setWarning();
    }

    /**
     * Info.
     *
     * @param message the message
     */
    public void info(String message) {
        this.hidden = " ";
        this.type = "alert alert-info";
        this.message = "<strong>Information: </strong>" + message;
        goOn = true;
    }


    /**
     * info format message and field set to warning
     * @param index
     * @param message
     */
    public void info(int index, String message) {
        info(message);
        fields.get(index).setWarning();
    }

    /**
     * Success.
     *
     * @param message the message
     */
    public void success(String message) {
        this.hidden = " ";
        this.type = "alert alert-success";
        this.message = "<strong>Success: </strong>" + message;
        goOn = true;
    }

    /**
     * format message as success and field too
     * @param index
     * @param message
     */
    public void success(int index, String message) {
        success(message);
        fields.get(index).setSuccess();
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


    /**
     * given field name get the field
     * @param name
     * @return
     */
    public Field getField(String name) {
        Field found = null;

        for (Field field : fields) {
            if (field.getName().equals(name)) {
                found = field;
                break;
            }
        }

        return found;
    }

    /**
     * given index number return the field
     * @param index
     * @return
     */
    public Field getField(int index) {
        return fields.get(index);
    }
    
    /**
     * Gets fields.
     *
     * @return Value of fields.
     */
    public List<Field> getFields() {
        return fields;
    }

    /**
     * Sets new fields.
     *
     * @param fields New value of fields.
     */
    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
