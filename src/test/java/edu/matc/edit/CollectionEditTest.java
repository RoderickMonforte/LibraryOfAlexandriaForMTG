package edu.matc.edit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 2/24/17.
 */
public class CollectionEditTest {
    CollectionEdit edit;

    @Before
    public void setUp(){
        edit = new CollectionEdit();
    }

    @Test
    public void userAttributeValidGood() throws Exception {
        edit = new CollectionEdit("collectionName",
                "descriptionText","noteText");
        assertTrue("Valid value supplied but failed validation", edit
                .collectionAttributeValid());
    }

    @Test
    public void userAttributeValidBad() throws Exception {
        edit = new CollectionEdit("",
                "","noteText");
        assertFalse("Invalid value supplied but passed validation", edit
                .collectionAttributeValid());
    }

    @Test
    public void collectionNameIsValidEmpty() throws Exception {
        edit.setCollectionName("");

        assertFalse("Collection name is empty but passed validation",edit
                .collectionNameIsValid());

    }
    @Test
    public void collectionNameIsValidBadCharacter() throws Exception {
        edit.setCollectionName("\t");

        assertFalse("Collection name is invalid but passed validation",edit
                .collectionNameIsValid());

    }
    @Test
    public void collectionNameIsValid() throws Exception {
        edit.setCollectionName("345353gdfgdgdg");

        assertTrue("Collection name is valid but failed validation",edit
                .collectionNameIsValid());

    }

    @Test
    public void descriptionTextIsValid() throws Exception {
        edit.setDescriptionText(" ");

        assertTrue("Description text is valid but failed validation",edit
                .descriptionTextIsValid());

    }
    @Test
    public void descriptionTextIsValidEmpty() throws Exception {
        edit.setDescriptionText("");

        assertTrue("Description text is empty and valid but failed validation",
                edit.descriptionTextIsValid());

    }

    @Test
    public void descriptionTextIsValidBadCharacter() throws Exception {
        edit.setDescriptionText("\t");

        assertFalse("Description text is invalid but failed validation",edit
                .descriptionTextIsValid());

    }
    @Test
    public void noteTextIsValid() throws Exception {
        edit.setNoteText(" ");

        assertTrue("note text is valid but failed validation",edit
                .noteTextIsValid());

    }
    @Test
    public void noteTextIsValidEmpty() throws Exception {
        edit.setNoteText("");

        assertTrue("note text is empty and valid but failed validation",
                edit.noteTextIsValid());

    }

    @Test
    public void noteTextIsValidBadCharacter() throws Exception {
        edit.setNoteText("\t");

        assertFalse("note text is invalid but failed validation",edit
                .noteTextIsValid());

    }
}