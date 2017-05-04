package edu.matc.edit;

import edu.matc.util.Alert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by student on 2/24/17.
 */
public class CollectionEditTest {
    CollectionEdit edit;
    Alert alert;

    @Before
    public void setUp(){
        alert = new Alert(3);
        edit = new CollectionEdit("", "" , "", alert);
    }


    @Test
    public void userAttributeValidGood() throws Exception {
        edit = new CollectionEdit("collectionName",
                "descriptionText","noteText", alert);
        assertTrue("Valid value supplied but failed validation", edit
                .collectionAttributeValid());
    }

    @Test
    public void userAttributeValidBad() throws Exception {
        edit = new CollectionEdit("",
                "","noteText", alert);
        assertFalse("Invalid value supplied but passed validation", edit
                .collectionAttributeValid());
    }

    @Test
    public void collectionNameIsValidEmpty() throws Exception {
        edit.setCollectionName("");
        edit.collectionNameIsValid();

        assertFalse("Collection name is empty but passed validation", alert
                .goOn());

    }
    @Test
    public void collectionNameIsValidBadCharacter() throws Exception {
        edit.setCollectionName("\t");
        edit.collectionNameIsValid();

        assertFalse("Collection name is invalid but passed validation",alert
                .goOn());

    }
    @Test
    public void collectionNameIsValid() throws Exception {
        edit.setCollectionName("345353gdfgdgdg");
        edit.collectionNameIsValid();

        assertTrue("Collection name is valid but failed validation", alert.goOn());

    }

    @Test
    public void descriptionTextIsValid() throws Exception {
        edit.setDescriptionText(" ");
        edit.descriptionTextIsValid();
        assertTrue("Description text is valid but failed validation", alert
                .goOn());

    }
    @Test
    public void descriptionTextIsValidEmpty() throws Exception {
        edit.setDescriptionText("");
        edit.descriptionTextIsValid();

        assertTrue("Description text is empty and valid but failed validation",
                alert.goOn());

    }

    @Test
    public void descriptionTextIsValidBadCharacter() throws Exception {
        edit.setDescriptionText("\t");
        edit.descriptionTextIsValid();

        assertFalse("Description text is invalid but failed validation",
                alert.goOn());

    }
    @Test
    public void noteTextIsValid() throws Exception {
        edit.setNoteText(" ");
        edit.noteTextIsValid();

        assertTrue("note text is valid but failed validation", alert.goOn());

    }
    @Test
    public void noteTextIsValidEmpty() throws Exception {
        edit.setNoteText("");
        edit.noteTextIsValid();

        assertTrue("note text is empty and valid but failed validation",
                alert.goOn());

    }

    @Test
    public void noteTextIsValidBadCharacter() throws Exception {
        edit.setNoteText("\t");
        edit.noteTextIsValid();

        assertFalse("note text is invalid but failed validation",alert.goOn());

    }
}