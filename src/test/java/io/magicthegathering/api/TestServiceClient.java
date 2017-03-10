package io.magicthegathering.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.List;


public class TestServiceClient {

    @Test
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        String response = null;
        ObjectMapper mapper = new ObjectMapper();
        Result result = null;
        List<CardsItem> lists = null;

   /*     for (int i=4; i <  10; i++) {
            target = client.target("https://api.magicthegathering" +
                    ".io/v1/cards?page=" + i + "&pageSize=100");
            response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            result = mapper.readValue(response, Result.class);
            lists = result.getCards();

            for (CardsItem item : lists) {
                new CardListDao().addCardList(new CardList(item.getMultiverseid()
                        , item.getName()));
            }
        }*/
        //assertEquals("Richard Kane Ferguson", item.getArtist());
        // CardList cardList = new CardList(item.getMultiverseid(), item.getName());
        // int id = new CardListDao().addCardList(cardList);
        //assertEquals(9, item.getMultiverseid());

    }
}