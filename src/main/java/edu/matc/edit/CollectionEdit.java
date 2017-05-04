package edu.matc.edit;

import edu.matc.util.Alert;
import org.apache.log4j.Logger;

/**
 * This is to validate new collection
 * Created by student on 2/19/17.
 */
public class CollectionEdit {
    private String collectionName;
    private String descriptionText;
    private String noteText;
    private String message;
    private final Logger log = Logger.getLogger(this.getClass());
    private Alert alert;

    /**
     * Empty constructor
     */
    public CollectionEdit() {

    }

    public CollectionEdit(String collectionName, String descriptionText,
                          String noteText, Alert alert) {
        this();
        this.collectionName = collectionName;
        this.descriptionText = descriptionText;
        this.noteText = noteText;
        this.alert = alert;
    }

    /**
     * Check all collection attributes validity
     *
     * @return true if all collection attributes passed in are valid
     */
    public boolean collectionAttributeValid() {

        alert.initialize();
        collectionNameIsValid();
        descriptionTextIsValid();
        noteTextIsValid();

        if (alert.goOn()) {
            alert.success(collectionName + " is added successfully.");
        }

        return alert.goOn();
    }

    /**
     * check collection name against edits.
     */
    public void collectionNameIsValid() {

        alert.initField(0, "CollectionName", collectionName);

        if (collectionName.isEmpty()) {
            alert.error(0,"Collection Name cannot be blank. Please enter " +
                    "valid value.");
        } else if (!collectionName.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            alert.error(0,"Only printable characters are valid for collection" +
                    " name.Please enter valid value.");
        } else {
            alert.fieldPassed("CollectionName");
        }

    }

    /**
     * determine if the description text is valid
     *
     */
    public void descriptionTextIsValid() {

        alert.initField(1, "DescriptionText", descriptionText);

        if (descriptionText.isEmpty()) {
            alert.fieldPassed("DescriptionText");
        } else if (!descriptionText.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            alert.error(1, "Description text contains invalid values. Please " +
                    "use visible characters only.");
        } else {
            alert.fieldPassed("DescriptionText");
        }

    }

    /**
     * determines if note text is valid
     */
    public void noteTextIsValid() {

        alert.initField(2, "NoteText", noteText);

        if (noteText.isEmpty()) {
            alert.fieldPassed("NoteText");
        } else if (!noteText.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            alert.error(2, "Note text contains invalid values. Please " +
                    "use visible characters only.");
        } else {
            alert.fieldPassed("NoteText");
        }

    }

    /**
     * Sets new collectionName.
     *
     * @param collectionName New value of collectionName.
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * Sets new descriptionText.
     *
     * @param descriptionText New value of descriptionText.
     */
    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    /**
     * Gets descriptionText.
     *
     * @return Value of descriptionText.
     */
    public String getDescriptionText() {
        return descriptionText;
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
     * Gets collectionName.
     *
     * @return Value of collectionName.
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * Sets new noteText.
     *
     * @param noteText New value of noteText.
     */
    public void setNoteText(String noteText) {
        this.noteText = noteText;
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
     * Gets noteText.
     *
     * @return Value of noteText.
     */
    public String getNoteText() {
        return noteText;
    }
}
