package edu.matc.controller;

import edu.matc.entity.CardItem;
import edu.matc.persistence.CardItemDao;
import io.magicthegathering.javasdk.api.CardAPI;
import io.magicthegathering.javasdk.resource.Card;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/createCardList"}
)
/**
 * This is used to setup Collection page. Gets collections for the users
 * Created by student on 2/22/17.
 */
public class CreateCardList extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        HttpSession session = req.getSession(true);

        String cardName = req.getParameter("CardName");

        session.setAttribute("cards" ,getCardFromWeb(cardName));

        dispatcher = req.getRequestDispatcher("cardList.jsp");
        dispatcher.forward(req, resp);
    }

    private List<CardItem> getCardFromWeb(String cardName) {
/*        Client client = ClientBuilder.newClient();
        WebTarget target = null;
        String response = null;
        ObjectMapper mapper = new ObjectMapper();
        Result result = null;
        List<CardsItem> lists = null;
        List<CardItem> cards = null;
        String webService = "https://api.magicthegathering.io/v1/cards?name="
                + cardName;

        target = client.target(webService);
        response = target.request(MediaType.APPLICATION_JSON).get(String.class);

        try {
            result = mapper.readValue(response, Result.class);
        } catch (IOException e) {
            log.error("Error reading response from web service " + e);
        }*/
        ArrayList<String> filter = new ArrayList<>();
        List<CardItem> cards = null;
        filter.add("name="+cardName);

        List<Card> lists = CardAPI.getAllCards(filter);

        for (Card item : lists) {
            cards.add(addNewCardItem(item));
        }
        return cards;
    }

    private CardItem addNewCardItem(Card item) {
        CardItem cardItem = new CardItem(item, getPrice(item.getName(), item
                .getSetName()));

        try {
            new CardItemDao().addCardItem(cardItem);
        } catch (Exception e) {
            log.error("Error adding item to database " + item.getName() + " "
                    + e.getMessage());
        }

        return cardItem;
    }

    private double getPrice(String cardName, String setName) {
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

            try {
                uri = new URI("http","magictcgprices.appspot.com",
                        "/api/cfb/price.json","cardname=" + set +
                        cardName, null);
                request = uri.toASCIIString();
                target = client.target(request);
                response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            } catch (URISyntaxException e) {
                log.error("Error building URI " + e.getMessage());
            } catch (Exception e) {
                continue;
            }
/*
            target = client.target("http://magictcgprices.appspot" +
                    ".com/api/cfb/price.json?cardname="+ set + " " + cardName);
*/

            if (!response.equals("[\"\"]")) {
                price = Double.valueOf(response.substring(3,(response.length()
                        - 2)));
            }
        }
        return price;
    }


}
