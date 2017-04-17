package edu.matc.persistence;

import edu.matc.entity.CardItem;
import edu.matc.entity.CardLocal;
import edu.matc.util.CardPrice;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by student on 4/16/17.
 */
public class CardDaoTest {
    @Before
    public void setUp() throws Exception {

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
                .getUniversalCardId(), name, 1,
                1, "test", cardItem.getPrice());

        int id = dao.addCardLocal(cardLocal);
        cardLocal.setUniversalCardId(id);

    }

    public CardItem addCardItem() throws Exception {
        Card card = CardAPI.getCard(1);
        CardItemDao dao = new CardItemDao();
        CardItem cardItem = null;
        int universeId = 0;

        cardItem = new CardItem(card, CardPrice.getPrice(card.getName(), card.getSetName()));
        universeId = dao.addCardItem(cardItem);
        cardItem.setUniversalCardId(universeId);

        return cardItem;

    }
}