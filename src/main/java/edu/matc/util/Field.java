package edu.matc.util;

/**
 * Created by student on 4/30/17.
 */
public class Field {
    private String fieldName;
    private String fieldValue;
    private String fieldClass;
    private String spanString;

    public Field () {
        fieldName = "";
        fieldValue = "";
        fieldClass = "";
        spanString = "";
    }

    /**
     * This sets the field in error display mode
     */
    public void setError() {
        fieldClass = " has-error has-feedback";
        spanString = "<span class=\"glyphicon glyphicon-remove form-control-feedback\"></span>";
    }

    /**
     * This sets the field in warning display mode
     */
    public void setWarning() {
        fieldClass = " has-warning has-feedback";
        spanString = " <span class=\"glyphicon glyphicon-warning-sign form-control-feedback\"></span>";
    }

    /**
     * This sets the field in success display mode
     */
    public void setSuccess() {
        fieldClass = " has-success has-feedback";
        spanString = "<span class=\"glyphicon glyphicon-ok form-control-feedback\"></span>";
    }

    /**
     * This sets the field in pristine display mode
     */
    public void setNormal() {
        fieldClass = "";
        spanString = "";
    }

    /**
     * Sets new fieldClass.
     *
     * @param fieldClass New value of fieldClass.
     */
    public void setFieldClass(String fieldClass) {
        this.fieldClass = fieldClass;
    }

    /**
     * Gets spanString.
     *
     * @return Value of spanString.
     */
    public String getSpanString() {
        return spanString;
    }

    /**
     * Sets new spanString.
     *
     * @param spanString New value of spanString.
     */
    public void setSpanString(String spanString) {
        this.spanString = spanString;
    }

    /**
     * Gets fieldClass.
     *
     * @return Value of fieldClass.
     */
    public String getFieldClass() {
        return fieldClass;
    }

    /**
     * Sets new fieldName.
     *
     * @param fieldName New value of fieldName.
     */
    public void setName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Gets fieldName.
     *
     * @return Value of fieldName.
     */
    public String getName() {
        return fieldName;
    }

    /**
     * Gets fieldName.
     *
     * @return Value of fieldName.
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets new fieldName.
     *
     * @param fieldName New value of fieldName.
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Gets fieldValue.
     *
     * @return Value of fieldValue.
     */
    public String getValue() {
        return fieldValue;
    }

    /**
     * Sets new fieldValue.
     *
     * @param fieldValue New value of fieldValue.
     */
    public void setValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}
