package edu.matc.util;

import org.apache.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by student on 4/15/17.
 */
public class CardPrice {

    private final Logger log = Logger.getLogger(this.getClass());

    public CardPrice() {
    }

    public static double getPrice(String cardName, String setName) throws
            URISyntaxException, Exception{
        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        String response = null;
        String set = "";
        String request = null;
        URI uri = null;
        String[] result = setName.split("\\s+");
        double price = 0.0;

        for (int i = result.length; i >= 0; i--) {

            if (i < result.length) {
                set = result[i] + " " + set;
            }

            uri = new URI("http","magictcgprices.appspot.com",
                    "/api/cfb/price.json","cardname=" + set +
                    cardName, null);
            request = uri.toASCIIString();
            target = client.target(request);
            response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            if (!response.equals("[\"\"]")) {
                price = Double.valueOf(response.substring(3,(response.length()- 2)));
            }
        }
        return price;
    }

}
