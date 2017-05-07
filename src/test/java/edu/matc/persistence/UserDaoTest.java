package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.*;

/**
 * UserDao Test
 * Created by student on 2/12/17.
 */
public class UserDaoTest {

    private UserDao dao;
    private User user;
    private TestData data;

    @Before
    public void setUp() throws Exception {
        dao = new UserDao();
        data = new TestData();
    }

    @After
    public void tearDown() {
        try {
            data.deleteTest();
        } catch (Exception e) {
            assertNull("Delete Test failed", e.getMessage());
        }
    }

    @Test
    public void addUser() throws Exception {

        assertNotNull("Insert to Card table failed", data.user);

    }

    @Test
    public void testUpdateUser() throws Exception {
        data.user.setDisplayName("TestDisplayNameUpdate");
        dao.updateUser(data.user);
        user = dao.getUser(data.user.getUserId());

        assertEquals("These are equal", data.user.getDisplayName(), user.getDisplayName());

    }

}