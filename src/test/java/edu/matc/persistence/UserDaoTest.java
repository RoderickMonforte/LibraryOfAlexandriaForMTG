package edu.matc.persistence;

import edu.matc.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by student on 2/12/17.
 */
public class UserDaoTest {
    UserDao dao;
    User user;

    @Before
    public void setup() {
        dao = new UserDao();
    }


    @Test
    public void getUser() throws Exception {
        user = (User) dao.getUser("erisc");

        assertNull("Not NULL!",user);
//        assertEquals("Not Found!!!","Eric",user.getDisplayName());


    }

}