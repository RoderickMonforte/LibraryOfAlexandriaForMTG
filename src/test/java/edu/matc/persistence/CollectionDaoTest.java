package edu.matc.persistence;

import edu.matc.entity.Collection;
import edu.matc.entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by student on 2/23/17.
 */
public class CollectionDaoTest {
    Collection collection;
    CollectionDao collectionDao;
    UserDao dao;
    int collectionId;
    String userID;

    @Before
    public void setUp() throws Exception {
        dao = new UserDao();
        collectionDao = new CollectionDao();
        User user = new User("test1","test1","test1");
        dao.addUser(user);
        userID = "test1";

        collection = new Collection(userID, "TestCollection",
                "Test Description", "Test Note", Long.valueOf(10), 100);
        collectionId = collectionDao.addCollection(collection);
    }

    @After
    public void tearDown() throws Exception {

        dao.deleteUser(userID);

    }
    @Test
    public void getOne() throws Exception {
        Collection collection= collectionDao.getOne(collectionId);

        assertEquals("Collection ID and passed ID are same but are not",
                collectionId, collection.getCollectionId());

    }

    @Test
    public void getAll() throws Exception {
        collectionDao = new CollectionDao();
        List list = collectionDao.getAll(collection.getUserId());
        assertTrue("Size of collection is > 0 but it is 0", list.size() > 0);
    }

    @Test
    public void addCollection() throws Exception {

        assertTrue("Should be > 0 but not", collectionId > 0);
        assertEquals("Should be equal", 100, collection.getCardQuantity());

    }

    @Test
    public void deleteCollection() throws Exception {
        collection = new Collection(userID, "Test2Collection",
                "Test2 Description", "Test2 Note", Long.valueOf(102), 1002);
        collectionId = collectionDao.addCollection(collection);

        collectionDao.deleteCollection(collectionId);
        assertFalse("deleted row should not be found but found", collectionDao
                .getAll(collection.getUserId()).contains(collection));
    }

    @Test
    public void updateCollection() throws Exception {
        collection.setCardQuantity(200);
        collectionDao.updateCollection(collection);
        int result = collectionDao.getOne(collectionId).getCardQuantity();
        assertEquals("Should be equal but not ",collection.getCardQuantity(),
                result);

    }
    @Test
    public void updateCollectionwithId() throws Exception {
        collection.setCardQuantity(200);
        collectionDao.updateCollection(375);
        int result = collectionDao.getOne(collectionId).getCardQuantity();
        assertEquals("Should be equal but not ",collection.getCardQuantity(),
                result);

    }
}