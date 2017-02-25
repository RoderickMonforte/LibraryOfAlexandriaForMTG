package edu.matc.edit;

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

    /**
     * Empty constructor
     */
    public CollectionEdit() {

    }

    public CollectionEdit(String collectionName, String descriptionText, String noteText) {
        this();
        this.collectionName = collectionName;
        this.descriptionText = descriptionText;
        this.noteText = noteText;
    }

    /**
     * Check all collection attributes validity
     *
     * @return true if all collection attributes passed in are valid
     */
    public boolean collectionAttributeValid() {
        if (collectionNameIsValid() && descriptionTextIsValid() &&
                noteTextIsValid()) {
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * check collection name against edits.
     *
     * @return true if collection name value passes edit.
     */
    public boolean collectionNameIsValid() {
        boolean allGood = true;

        if (collectionName.isEmpty()) {
            message = "Collection Name cannot be blank. Please enter valid " +
                    "value.";
            allGood = false;
        } else if (!collectionName.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            message = "Only printable characters are valid for collection " +
                    "name.Please enter valid value.";
            allGood = false;
        }

        return allGood;
    }

    /**
     * determine if the description text is valid
     *
     * @return true if description text is valid
     */
    public boolean descriptionTextIsValid() {
        boolean  allGood = true;

        if (descriptionText.isEmpty()) {
            allGood = true;
        } else if (!descriptionText.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            message = "Description text contains invalid values. Please use " +
                    "visible characters only.";
            allGood = false;
        }

        return allGood;

    }

    /**
     * determines if note text is valid
     *
     * @return true if note text is valid
     */
    public boolean noteTextIsValid() {
        boolean allGood = true;

        if (noteText.isEmpty()) {
            allGood = true;
        } else if (!noteText.matches("^[^\\x00-\\x1F\\x80-\\x9F]+$")) {
            message = "Note text contains invalid values. Please use " +
                    "visible characters only.";
            allGood = false;
        }

        return allGood;

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
