package edu.matc.persistence;

import edu.matc.entity.CardLocal;
import org.hibernate.Criteria;
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

        Criteria criteria = session.createCriteria(CardLocal.class);
        criteria.add(Restrictions.eq("collectionId", id));
        criteria.setProjection(Projections.sum("priceAmount"));

        answer = criteria.list();

        return answer.get(0);

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

        Criteria criteria = session.createCriteria(CardLocal.class);
        criteria.add(Restrictions.eq("collectionId", id));
        criteria.setProjection(Projections.sum("ownedQuantity"));

        String answer = criteria.list().get(0).toString();

        return Integer.valueOf(answer);

    }
}
