package edu.matc.persistence;

import edu.matc.entity.CardItem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by student on 2/12/17.
 */
public class CardItemDao {

    /** Return an item from the card list
     *
     * @return an item from the cardItem
     */
    private CardItem getCardItem(int id, String option) throws
            Exception{
        CardItem cardItem = null;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        if (option.equals("multiverseId")) {
            cardItem = (CardItem) session.createCriteria(CardItem.class).add
                    (Restrictions.eq("multiverseId",id));
        } else if (option.equals("universalCardId")) {
            cardItem = (CardItem) session.createCriteria(CardItem.class).add
                    (Restrictions.eq("universalCardId",id));
        }

        session.close();
        return cardItem;
    }

    /** Return an item from the card list based on id
     *
     * @return an item from the cardItem based on ID
     */
    public CardItem getCardItemMultiverseId(int id) throws Exception{
        return getCardItem(id,"multiverseId");
    }

    /** Return an item from the card list based on universal id
     *
     * @return an item from the cardItem based on universal ID
     */
    public CardItem getCardItemUniversalId(int id) throws Exception{
        return getCardItem(id,"universalCardId");
    }

    /** Return an item from the card list based on card id
     *
     * @return an item from the cardItem based on card id
     */
    public CardItem getCardItemId(String id) throws Exception{
        CardItem cardItem = null;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        cardItem = (CardItem) session.createCriteria(CardItem.class).add
                    (Restrictions.eq("id",id));

        session.close();
        return cardItem;
    }
    /** Return an item from the card list based on card name
     *
     * @return a list of card item from the cardItem based on card name
     */
    public List<CardItem> getCardName(String name) throws Exception{
        List<CardItem> cardItem = null;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        cardItem = (List<CardItem>) session.createCriteria(CardItem.class).add
                (Restrictions.like("cardName",name)).list();

        session.close();
        return cardItem;
    }

    /**
     * Add cardItem int.
     *
     * @param cardItem the cardItem
     * @return the id of the cardItem
     */
    public int addCardItem(CardItem cardItem) throws Exception {
        int id = 0;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        id = (int) session.save(cardItem);
        transaction.commit();

        session.close();
        return id;

    }

    public void deleteCardItem(int id) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CardItem cardItem = new CardItem();
        cardItem.setUniversalCardId(id);

        session.delete(cardItem);
        transaction.commit();

        session.close();

    }

    public void updateCardItem(CardItem cardItem) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(cardItem);
        transaction.commit();

        session.close();
    }



}
