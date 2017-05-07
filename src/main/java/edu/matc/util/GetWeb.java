package edu.matc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.magicthegathering.api.Card;
import io.magicthegathering.api.Result;
import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by student on 4/15/17.
 */
public class GetWeb {

    private final Logger log = Logger.getLogger(this.getClass());

    public GetWeb() {
    }

    /**
     * Given card name and set name of the card it goes out and uses web
     * service to get the price of that card.
     * @param cardName
     * @param setName
     * @return
     * @throws URISyntaxException
     */
    public static double getPrice(String cardName, String setName) throws
            URISyntaxException {
        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        Invocation.Builder invocation = null;
        String response = null;
        String set = "";
        String request = null;
        URI uri = null;
        String[] result = setName.split("\\s+");
        String priceString = null;
        int trials = 0;
        double price = 0.0;

        setUp();

        for (int i = result.length; i >= 0; i--) {

            if (i < result.length) {
                set = result[i] + " " + set;
            }

            uri = new URI(Property.get("price.scheme"),Property.get("price.authority"),
                    Property.get("price.path"),"cardname=" + set +
                    cardName, null);
            request = uri.toASCIIString();
            target = client.target(request);
            invocation = target.request(MediaType.APPLICATION_JSON);
            invocation.header(Property.get("header.type"), Property.get
                    ("header.value"));

            try {
                response = invocation.get(String.class);
            } catch (Exception e) {
                trials++;
                if (trials < 5 && price == 0.0) {
                    i++;
                }
            }

            if (!response.equals("[\"\"]")) {
                priceString = response.substring(3,(response.length()-2))
                        .replace(",","").toString();
                price = Double.valueOf(priceString);
            }
        }
        return price;
    }

    /**
     * given the multiverse id it will use web service to get information
     * about that card.
     * @param id
     * @return
     * @throws Exception
     */
    public static Card getCard(int id) throws Exception {

        setUp();
        
        String https_url = Property.get("magicApi.uri") + id;
        URL url;
        String cards = "";

        try {
            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty(Property.get("header.type"),Property.get
                    ("header.value"));
            BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
            String input;
            while ((input = br.readLine()) != null) {
                cards = cards + input;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        Result result = null;

        result = mapper.readValue(cards, Result.class);

        return  result.getCard();
    }

    /**
     * Property is setup with the first call
     */
    private static void setUp() {

        if (Property.isNull()) {
            new Property();
        }
    }


}
