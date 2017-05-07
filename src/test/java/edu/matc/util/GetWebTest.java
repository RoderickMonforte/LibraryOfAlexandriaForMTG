package edu.matc.util;

import io.magicthegathering.api.Card;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by student on 4/19/17.
 */
public class GetWebTest {
    @Test
    public void getPrice() throws Exception {
        double price = GetWeb.getPrice("dakkon","legends");
        assertTrue(price > 0.0);

    }

    @Test
    public void getCard() throws Exception {
        Card card = GetWeb.getCard(409741);

        assertEquals("James Ryman", card.getArtist());

    }

}