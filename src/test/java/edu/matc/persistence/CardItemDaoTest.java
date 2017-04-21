package edu.matc.persistence;

import edu.matc.entity.CardItem;
import edu.matc.util.GetWeb;
import io.magicthegathering.api.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by student on 4/15/17.
 */
public class CardItemDaoTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {


    }


    @Test
    public void addCardItem() throws Exception {
        Card card = GetWeb.getCard(1);
        CardItemDao dao = new CardItemDao();
        CardItem cardItem = null;
        int universeId = 0;

        cardItem = new CardItem(card, GetWeb.getPrice(card.getName(), card.getSetName()));

        universeId = dao.addCardItem(cardItem);
        cardItem.setUniversalCardId(universeId);

    }
    @Test
    public void getCardItem() throws Exception {
        CardItemDao dao = new CardItemDao();
        CardItem cardItem = null;

        cardItem = dao.getCardItemMultiverseId(1);

        assertNotNull("Should not be null",cardItem);
    }

}