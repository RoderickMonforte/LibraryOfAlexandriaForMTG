package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * UserDao Test
 * Created by student on 2/12/17.
 */
public class UserDaoTest {

    UserDao dao;
    User user;
    String id;

    @Before
    public void setup() throws Exception{
        dao = new UserDao();
        user = new User("test1","test1","test1");
        dao.addUser(user);
        id = "test1";
    }

    @After
    public void cleanup() throws Exception {
        dao.deleteUser(id);
    }

    @Test
    public void getUserTest() throws Exception {
        user =  dao.getUser("test1");

        assertNotNull("User is expected to be found but returned NULL!",user);

        User user2 =  dao.getUser("test2");
        assertNotNull("User is expected to be NOT found but was found!",
                user);
    }

    @Test
    public void updateUserTest() throws Exception {
        user.setDisplayName("TestChange");
        dao.updateUser(user);

        User user2 = dao.getUser(id);

        assertEquals("Expecting name change but did not",
                user2.getDisplayName(), user.getDisplayName());

    }

    @Test
    public void deleteUserTest() throws Exception {
        User user2 = new User("test2","test2","test2");
        dao.addUser(user2);

        assertNotNull("User should be found but NULL",dao.getUser
                (user2.getUserId()));

        dao.deleteUser(user2.getUserId());
        assertNull("User should NOT be found but found",dao.getUser
                (user2.getUserId()));

    }

}