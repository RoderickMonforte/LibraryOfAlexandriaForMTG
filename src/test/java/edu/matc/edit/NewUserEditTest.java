package edu.matc.edit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test NewUserEdit class
 * Created by student on 2/19/17.
 */
public class NewUserEditTest {
    NewUserEdit edit;

    @Before
    public void setUp() throws Exception {
        edit = new NewUserEdit("test1","test1","test1","test1");
    }

    @Test
    public void userAttributeValidTrue() throws Exception {

        assertTrue("Valid User entered but returned invalid",edit.userAttributeValid());
    }
    @Test
    public void userAttributeValidFalse() throws Exception {
        edit = new NewUserEdit("test1","test2","test1","test1");
        assertFalse("Invalid User entered but returned valid",edit
                .userAttributeValid());
    }

    @Test
    public void displayNameValueIsValidShort() throws Exception {
        edit.setDisplayNameValue("tst1");
        assertFalse("Display name is shorter than five but returned true",edit
                .displayNameValueIsValid());
    }
    @Test
    public void displayNameValueIsValidEmpty() throws Exception {
        edit.setDisplayNameValue("");
        assertFalse("Display name is empty but returned true",edit.displayNameValueIsValid());
    }
    @Test
    public void displayNameValueIsValidBadCharacters() throws Exception {
        edit.setDisplayNameValue("\t");
        assertFalse("Display name has bad characters but returned true",edit
                .displayNameValueIsValid());
    }
    @Test
    public void displayNameValueIsValid() throws Exception {
        edit.setDisplayNameValue("&*()+_");
        assertTrue("Display name is valid but returned false",edit
                .displayNameValueIsValid());
    }
    @Test
    public void passwordIsValidEmpty() throws Exception {
        edit.setPasswordText("");
        edit.setRePasswordText("");
        assertFalse("Password is empty but returned true",edit
                .passwordIsValid());
    }
    @Test
    public void passwordIsValidShort() throws Exception {
        edit.setPasswordText("tst1");
        edit.setRePasswordText("tst1");
        assertFalse("Password is shorter than five but returned true",edit
                .passwordIsValid());
    }
    @Test
    public void passwordIsValidBadCharacters() throws Exception {
        edit.setPasswordText("\t");
        edit.setRePasswordText("\t");
        assertFalse("Password contains bad characters but returned true",edit
                .passwordIsValid());
    }
    @Test
    public void passwordIsValidEqual() throws Exception {
        edit.setPasswordText("test1");
        edit.setRePasswordText("test1");
        assertTrue("Password equal to re-typed password but returned false",
                edit.passwordIsValid());
    }
    @Test
    public void passwordIsValidNotEqual() throws Exception {
        edit.setPasswordText("test1");
        edit.setRePasswordText("test2");
        assertFalse("Password not equal to re-typed password but returned " +
                        "true", edit.passwordIsValid());
    }
    @Test
    public void userIDIsValidExists() throws Exception {
        edit.setUserIDName("eric");
        assertFalse("User ID entered already exists but returned True",edit
                .userIDIsValid());
    }
    @Test
    public void userIDIsValid() throws Exception {
        edit.setUserIDName("test1");
        assertTrue("User ID entered does not exists but returned False",edit
                .userIDIsValid());
    }
    @Test
    public void userIDIsValidEmpty() throws Exception {
        edit.setUserIDName("");
        assertFalse("User ID is empty but returned True",edit
                .userIDIsValid());
    }
    @Test
    public void userIDIsValidShort() throws Exception {
        edit.setUserIDName("tst1");
        assertFalse("User ID is shorter than five but returned True",edit
                .userIDIsValid());
    }
    @Test
    public void userIDIsValidBadCharacter() throws Exception {
        edit.setUserIDName("?");
        assertFalse("User ID contains invalid characters but returned valid",
                edit.userIDIsValid());
    }

}