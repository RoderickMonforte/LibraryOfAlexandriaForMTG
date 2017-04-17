package edu.matc.controller;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

//        session.setAttribute("cards" ,getCardFromWeb(cardName));

        dispatcher = req.getRequestDispatcher("cardList.jsp");
        dispatcher.forward(req, resp);
    }
/*
    private List<CardItem> getCardFromWeb(String cardName) {
        Client client = ClientBuilder.newClient();
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
/*
        ArrayList<String> filter = new ArrayList<>();
        List<CardItem> cards = null;
        filter.add("name="+cardName);

        List<Card> lists = CardAPI.getAllCards(filter);

        for (Card item : lists) {
            cards.add(addNewCardItem(item));
        }
        return cards;
    }
*/

/*
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
*/



}
