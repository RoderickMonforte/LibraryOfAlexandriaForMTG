package edu.matc.controller;

import edu.matc.persistence.CardDao;
import org.apache.log4j.Logger;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by student on 4/28/17.
 */
@MessageDriven
public class CollectionSuperUpdate implements MessageListener {

    private final Logger log = Logger.getLogger(this.getClass());
    private int skipCollectionId;
    private int skipCardId;
    private int changeUniversalCardId;
    private double newCardPrice;

    public CollectionSuperUpdate() {
    }

    /**
     * Gets executed upon sending the message.
     * @param message
     */
    public void onMessage(Message message) {
        TextMessage updateMessage = (TextMessage) message;
        String messageText = null;

        try {
            messageText = updateMessage.getText();
            log.info("The message is " + messageText);
            parseMessage(messageText);
            superUpdate();
        } catch (JMSException e) {
            log.error("Error reading from queue " + e.getMessage());
        }

    }

    /**
     * From the message the values are used to update all the collections
     * with the card that has a price change.
     */
    private void superUpdate() {
        CardDao cardDao = new CardDao();

        try {
            cardDao.updateCardPrices(skipCollectionId, changeUniversalCardId, newCardPrice);
        } catch (Exception e) {
            log.error("Error updating all collection and cards with new price. "
                    + e.getMessage());
        }

    }

    /**
     * Parse incomming message containing the parameters for the super update
     * @param messageText
     */
    private void parseMessage(String messageText) {
        String[] parameters = messageText.split(";");
        String[] nameValue = null;

        for (String mapping : parameters) {
            nameValue = mapping.split("=");
            if (nameValue[0].contains("collectionId")) {
                skipCollectionId = Integer.valueOf(nameValue[1]);
            } else if (nameValue[0].contains("cardId")) {
                skipCardId = Integer.valueOf(nameValue[1]);
            } else if (nameValue[0].contains("universalId")) {
                changeUniversalCardId = Integer.valueOf(nameValue[1]);
            } else if (nameValue[0].contains("newPrice")) {
                newCardPrice = Double.valueOf(nameValue[1]);
            }
        }
    }


}
