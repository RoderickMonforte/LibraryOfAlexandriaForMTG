package io.magicthegathering.api;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;


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

}