package edu.matc.util;

import io.magicthegathering.api.Card;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by student on 4/19/17.
 */
public class GetWebTest {
    @Test
    public void getPrice() throws Exception {
//        new Property();
        double price = GetWeb.getPrice("dakkon","legends");
        double delta = 0.0;
        assertEquals(14.99, price, delta);

        price = GetWeb.getPrice("dakkon","legends");
        assertEquals(14.99, price, delta);

    }

    @Test
    public void getCard() throws Exception {
//        new Property();
        Card card = GetWeb.getCard(409741);

        assertEquals("James Ryman", card.getArtist());

    }

}