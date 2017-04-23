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

    public static double getPrice(String cardName, String setName) throws
            URISyntaxException, Exception{
        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        Invocation.Builder invocation = null;
        String response = null;
        String set = "";
        String request = null;
        URI uri = null;
        String[] result = setName.split("\\s+");
        String priceString = null;
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

//            response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            response = invocation.get(String.class);
            if (!response.equals("[\"\"]")) {
                priceString = response.substring(3,(response.length()-2))
                        .replace(",","").toString();
                price = Double.valueOf(priceString);
            }
        }
        return price;
    }

    public static Card getCard(int id) throws Exception {

        String https_url = "https://api.magicthegathering.io/v1/cards/" + id;
        URL url;
        String cards = "";
        setUp();

        try {
            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0) Gecko/20100101 Firefox/19.0");
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

    private static void setUp() {

        if (Property.isNull()) {
            new Property();
        }
    }


}
