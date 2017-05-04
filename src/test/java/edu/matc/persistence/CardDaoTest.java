package edu.matc.persistence;

import edu.matc.entity.CardItem;
import edu.matc.entity.CardLocal;
import edu.matc.util.GetWeb;
import io.magicthegathering.api.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by student on 4/16/17.
 */
public class CardDaoTest {


    private CardDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new CardDao();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addCardLocal() throws Exception {
        CardItem cardItem = addCardItem();
        CardDao dao = new CardDao();
        String name = cardItem.getCardName();

        CardLocal cardLocal = new CardLocal(1, cardItem
                .getUniversalCardId(), 1,
                1, "test", cardItem.getPrice(), cardItem);

        int id = dao.addCardLocal(cardLocal);
        cardLocal.setUniversalCardId(id);

    }

    public CardItem addCardItem() throws Exception {
        Card card = GetWeb.getCard(1);
        CardItemDao dao = new CardItemDao();
        CardItem cardItem = null;
        int universeId = 0;

        cardItem = new CardItem(card, GetWeb.getPrice(card.getName(), card.getSetName()));
        universeId = dao.addCardItem(cardItem);
        cardItem.setUniversalCardId(universeId);

        return cardItem;

    }

    @Test
    public void getSumPriceByCollectionId() throws Exception {
        double priceSum = dao.getSumPriceByCollectionId(7);

        assertEquals("must be equal", 30.78, priceSum);


    }
    @Test
    public void getSumOwnedByCollectionId() throws Exception {
        int priceSum = dao.getSumOwnedByCollectionId(375);

        assertEquals("must be equal", 2, priceSum);


    }

}