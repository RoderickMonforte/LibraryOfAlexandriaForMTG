package io.magicthegathering.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class TestServiceClient {


    @Test
    public void testTest() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        String response = null;
        String set = "";
        String request = null;
        String priceString = null;
        URI uri = null;
        String cardName = "Black Lotus"; //"avacyn"; //
        double price =  0.0;

            try {
                uri = new URI("http","magictcgprices.appspot.com",
                        "/api/cfb/price.json","cardname=" + cardName, null);
            } catch (URISyntaxException e) {
            }

            request = uri.toASCIIString();
            target = client.target(request);
            try {

                response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            } catch (Exception e) {
                set = e.getMessage();
            }
            if (!response.equals("[\"\"]")) {
                priceString = response.substring(3,(response.length()-2))
                        .replace(",","").toString();
                price = Double.valueOf(priceString);
            }
    }
    @Test
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        String response = null;
        ObjectMapper mapper = new ObjectMapper();
        Result result = null;
        List<Card> lists = null;

        target = client.target("https://api.magicthegathering" +
                ".io/v1/cards/409741");
        response = target.request(MediaType.APPLICATION_JSON).get(String.class);

//        assertEquals("=", " ", response);
        result = mapper.readValue(response, Result.class);
        Card card= result.getCard();
/*
            for (CardsItem item : lists) {
                new CardListDao().addCardList(new CardList(item.getMultiverseid()
                        , item.getName()));
            }*/

        assertEquals("James Ryman", card.getArtist());
        // CardList cardList = new CardList(item.getMultiverseid(), item.getName());
        // int id = new CardListDao().addCardList(cardList);
        //assertEquals(9, item.getMultiverseid());

    }
}