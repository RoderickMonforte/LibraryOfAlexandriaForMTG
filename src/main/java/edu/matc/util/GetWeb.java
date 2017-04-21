package edu.matc.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.magicthegathering.api.Card;
import io.magicthegathering.api.Result;
import org.apache.log4j.Logger;
import org.glassfish.jersey.SslConfigurator;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

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
        SslConfigurator sslConfig = SslConfigurator.newInstance()
                .trustStoreFile("/home/student/.keystore")
                .trustStorePassword("changeit")
                .keyStoreFile("/home/student/.keystore")
                .keyPassword("changeit");
        SSLContext sslContext = sslConfig.createSSLContext();
        Client client = ClientBuilder.newBuilder().sslContext(sslContext).build();
        WebTarget target = null;
        Invocation.Builder invocation = null;
        String response = null;
        ObjectMapper mapper = new ObjectMapper();
        Result result = null;

        setUp();

        target = client.target("https://api.magicthegathering" +
                ".io/v1/cards/" + id);
        invocation = target.request(MediaType.APPLICATION_JSON);
/*
        invocation.header(Property.get("header.type"), Property.get
                ("header.value"));
*/
        invocation.header("User-Agent","Mozilla/5.0 (Windows NT 5.1; rv:19.0)" +
                " Gecko/20100101 Firefox/19.0");
        response = invocation.get(String.class);

        result = mapper.readValue(response, Result.class);

        return  result.getCard();
    }

    private static void setUp() {

        if (Property.isNull()) {
            new Property();
        }
    }


}
