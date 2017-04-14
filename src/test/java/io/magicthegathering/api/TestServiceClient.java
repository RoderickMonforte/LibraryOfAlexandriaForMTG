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
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        String response = null;
        ObjectMapper mapper = new ObjectMapper();
        Result result = null;
        List<CardsItem> lists = null;

                 target = client.target("https://api.magicthegathering" +
                    ".io/v1/cards?name=dakkon");
            response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            result = mapper.readValue(response, Result.class);
            lists = result.getCards();
/*
            for (CardsItem item : lists) {
                new CardListDao().addCardList(new CardList(item.getMultiverseid()
                        , item.getName()));
            }*/

        assertEquals("Richard Kane Ferguson", lists.get(0).getArtist());
        // CardList cardList = new CardList(item.getMultiverseid(), item.getName());
        // int id = new CardListDao().addCardList(cardList);
        //assertEquals(9, item.getMultiverseid());

    }
    @Test
    public void testTest() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        String response = null;
        String set = "";
        String request = null;
        String priceString = null;
        URI uri = null;
        String cardName = "Magic Avacyn's Pilgrim"; //"avacyn"; //
        double price =  0.0;

            try {
                uri = new URI("http","magictcgprices.appspot.com",
                        "/api/cfb/price.json","cardname=" + cardName, null);
            } catch (URISyntaxException e) {
            }
/*
            target = client.target("http://magictcgprices.appspot" +
                    ".com/api/cfb/price.json?cardname="+ set + " " + cardName);
*/
            request = uri.toASCIIString();
            target = client.target(request);
            try {

                response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            } catch (Exception e) {
                set = e.getMessage();
            }
            if (!response.equals("[\"\"]")) {
                priceString = response.substring(3,(response.length()-2));
                price = Double.valueOf(priceString);
            }
    }

}