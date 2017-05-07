package edu.matc.persistence;

import edu.matc.entity.CardItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by student on 4/15/17.
 */
public class CardItemDaoTest {

    CardItemDao dao;
    CardItem cardItem;
    TestData data;


    @Before
    public void setUp() throws Exception {
        dao = new CardItemDao();
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
    public void addCardItem() throws Exception {

        assertNotNull("Insert to CardItem table failed", data.cardItem);

    }

    @Test
    public void testGetCardItemMultiverseId() throws Exception {
        cardItem = dao.getCardItemMultiverseId(data.cardItem.getMultiverseId());

        assertNotNull("Should not be null",cardItem);
    }

    @Test
    public void testGetCardItemUniversalId() throws Exception {
        cardItem = dao.getCardItemUniversalId(data.cardItem.getUniversalCardId());

        assertNotNull("Should not be null",cardItem);
    }

    @Test
    public void testGetCardItemId() throws Exception {
        cardItem = dao.getCardItemId(data.cardItem.getId());

        assertNotNull("Should not be null",cardItem);
    }

    @Test
    public void testGetCardName() throws Exception {
        cardItem = dao.getCardName(data.cardItem.getCardName()).get(0);

        assertNotNull("Should not be null",cardItem);
    }

    @Test
    public void testUpdateCardItem() throws Exception {
        data.cardItem.setCardSet("TestCardSetUpdate");
        dao.updateCardItem(data.cardItem);
        cardItem = dao.getCardItemMultiverseId(data.cardItem.getMultiverseId());

        assertEquals("Should not be equal",data.cardItem.getCardSet(),
                cardItem.getCardSet());
    }

}