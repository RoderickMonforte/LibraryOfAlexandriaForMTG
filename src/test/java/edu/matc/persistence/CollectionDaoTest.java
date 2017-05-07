package edu.matc.persistence;

import edu.matc.entity.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by student on 2/23/17.
 */
public class CollectionDaoTest {
    Collection collection;
    CollectionDao dao;
    private TestData data;

    @Before
    public void setUp() throws Exception {
        dao = new CollectionDao();
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
    public void addCollection() throws Exception {

        assertNotNull("Insert to Collection table failed", data.collection);

    }

    @Test
    public void testGetAll() throws Exception {
        collection = dao.getAll(data.user.getUserId()).get(0);

        assertNotNull("Insert to Collection table failed", collection);

    }

    @Test
    public void testGetOne() throws Exception {
        collection = dao.getOne(data.collection.getCollectionId());

        assertNotNull("Insert to Collection table failed", collection);

    }

    @Test
    public void testUpdateCollection() throws Exception {
        data.collection.setDisplayName("TestDisplayNameUpdate");
        dao.updateCollection(data.collection);
        collection = dao.getOne(data.collection.getCollectionId());

        assertEquals("This should be equal", data.collection.getDisplayName
                (), collection.getDisplayName());

    }

    @Test
    public void testUpdateCollectionWithID() throws Exception {
        data.cardLocal.setOwnedQuantity(5);
        new CardDao().updateCardLocal(data.cardLocal);
        dao.updateCollection(data.collection.getCollectionId());
        collection = dao.getOne(data.collection.getCollectionId());

        assertEquals("This should be equal", 5, collection.getCardQuantity());

    }
}