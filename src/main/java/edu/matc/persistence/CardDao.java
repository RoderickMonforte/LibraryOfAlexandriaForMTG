package edu.matc.persistence;

import edu.matc.entity.CardLocal;
import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/12/17.
 */
public class CardDao {

    /** Return a list of all users' cardLocal
     *
     * @return All cardLocals
     */
    public List getAll(int collectionId) throws Exception{
        List cardLocals = new ArrayList<CardLocal>();

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        cardLocals = session.createCriteria(CardLocal.class).add
                (Restrictions.eq("collectionId",collectionId)).list();

        session.close();
        return cardLocals;
    }
    /** Return a one cardLocal
     *
     * @return one cardLocals
     */
    public CardLocal getOne(int cardId) throws Exception{

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CardLocal cardLocal = (CardLocal) session.get(CardLocal.class, cardId);

        session.close();
        return cardLocal;
    }
    /** Return a one cardLocal
     *
     * @return one cardLocals
     */
    public CardLocal getCardInCollection(int collectionId, int universalCardId)
            throws Exception{

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(CardLocal.class);
        criteria.add(Restrictions.eq("collectionId", collectionId));
        criteria.add(Restrictions.eq("universalCardId", universalCardId));
        CardLocal cardLocal = (CardLocal) criteria.list().get(0);

        session.close();
        return cardLocal;
    }
    /**
     * Add cardLocal int.
     *
     * @param cardLocal the cardLocal
     * @return the id of the cardLocal
     */
    public int addCardLocal(CardLocal cardLocal) throws Exception {
        int id = 0;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        id = (int) session.save(cardLocal);
        transaction.commit();

        session.close();
        return id;

    }

    public void deleteCardLocal(int id) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        CardLocal cardLocal = new CardLocal();
        cardLocal.setCardId(id);

        session.delete(cardLocal);
        transaction.commit();

        session.close();

    }

    public void updateCardLocal(CardLocal cardLocal) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(cardLocal);
        transaction.commit();

        session.close();
    }

    /**
     * Sum all the cards for a specific collection and return it
     * @param id
     * @return
     * @throws Exception
     */
    public double getSumPriceByCollectionId(int id) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Double> answer = new ArrayList<Double>();
        Double newPrice = 0.0;

        Criteria criteria = session.createCriteria(CardLocal.class);
        criteria.add(Restrictions.eq("collectionId", id));
        criteria.setProjection(Projections.sum("priceAmount"));

        try {
            answer = criteria.list();
            if (answer.size() > 0) {
                if (answer.get(0) != null) {
                    newPrice = answer.get(0);
                }
            }
        } catch (Exception e) {
            //return 0.0 because there are no cards in the collection.
        }

        return newPrice;

    }

    /**
     * Sum all the cards for a specific collection and return it
     * @param id
     * @return
     * @throws Exception
     */
    public int getSumOwnedByCollectionId(int id) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int count = 0;

        Criteria criteria = session.createCriteria(CardLocal.class);
        criteria.add(Restrictions.eq("collectionId", id));
        criteria.setProjection(Projections.sum("ownedQuantity"));

        try {
            String answer = criteria.list().get(0).toString();
            count = Integer.valueOf(answer);
        } catch (Exception e) {
            //This just means the collection has no cards so default is 0.
        }

        return count;

    }

    /**
     * @param skipCollectionId
     * @param universalCardId
     * @param newPrice
     * @throws Exception
     */
    public void updateCardPrices(int skipCollectionId, int universalCardId,
                                 double newPrice) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        CollectionDao collectDao = new CollectionDao();
        Transaction transaction = null;
        CardLocal cardLocal = null;
        double newOwnedPrice = 0.0;

        transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(CardLocal.class);
        criteria.add(Restrictions.eq("universalCardId", universalCardId));
        criteria.add(Restrictions.ne("collectionId", skipCollectionId));

        ScrollableResults items = criteria.scroll();
        int count=0;
        while ( items.next() ) {

            cardLocal = (CardLocal) items.get(0);
            newOwnedPrice = (double) cardLocal.getOwnedQuantity() * newPrice;

            cardLocal.setPriceAmount(newOwnedPrice);

            session.update(cardLocal);
            if ( ++count % 100 == 0 ) {
                session.flush();
                session.clear();
            }

            collectDao.updateCollection(cardLocal.getCollectionId());

        }

        transaction.commit();
        session.close();
    }
}
