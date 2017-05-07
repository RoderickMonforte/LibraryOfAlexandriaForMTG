package edu.matc.persistence;

import edu.matc.entity.CardLocal;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by student on 4/16/17.
 */
public class CardDaoTest {

    private CardDao dao;
    private TestData data;

    @Before
    public void setUp() throws Exception {
        dao = new CardDao();
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
    public void addCardLocal() throws Exception {

       assertNotNull("Insert to Card table failed", data.cardLocal);

    }

    @Test
    public void testGetAll() throws Exception {

        List<CardLocal> cards = dao.getAll(data.cardLocal.getCollectionId());

        assertEquals("Test data and query result should match but did not",
                data.cardLocal.getCardId(), cards.get(0).getCardId());
    }

    @Test
    public void testGetOne() throws Exception {
        CardLocal card = dao.getOne(data.cardLocal.getCardId());

        assertEquals("Test data and query result should match but did not",
                data.cardLocal.getNoteText(), card.getNoteText());

    }

    @Test
    public void testGetCardInCollection() throws Exception {
        CardLocal card = dao.getCardInCollection(data.collection
                .getCollectionId(), data.cardItem.getUniversalCardId());

        assertEquals("Test data and query result should match but did not",
                data.cardLocal.getNoteText(), card.getNoteText());

    }

    @Test
    public void testUpdateCardLocal() throws Exception {
        data.cardLocal.setOwnedQuantity(5);
        dao.updateCardLocal(data.cardLocal);
        CardLocal card = dao.getOne(data.cardLocal.getCardId());

        assertEquals("Test data and query result should match but did not",
                data.cardLocal.getOwnedQuantity(), card.getOwnedQuantity());

    }

    @Test
    public void testGetSumPriceByCollectionId() throws Exception {
        double priceSum = dao.getSumPriceByCollectionId(data.collection.getCollectionId());

        assertEquals("must be equal", data.collection.getPriceAmount(), priceSum);


    }

    @Test
    public void getSumOwnedByCollectionId() throws Exception {
        int priceSum = dao.getSumOwnedByCollectionId(data.collection.getCollectionId());

        assertEquals("must be equal", data.collection.getCardQuantity(), priceSum);


    }

}