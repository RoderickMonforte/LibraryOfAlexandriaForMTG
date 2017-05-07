package edu.matc.persistence;

import edu.matc.entity.Collection;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2/12/17.
 */
public class CollectionDao {

    /** Return a list of all users' collection
     *
     * @return All collections
     */
    public List<Collection> getAll(String userID) throws Exception{
        List<Collection> collections = new ArrayList<Collection>();

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        collections = session.createCriteria(Collection.class).add
                (Restrictions.eq("userId",userID)).list();

        session.close();
        return collections;
    }

    /** Return a one collection
     *
     * @return one collections
     */
    public Collection getOne(int collectionId) throws Exception{

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Collection collection = (Collection) session.get(Collection.class, collectionId);

        session.close();
        return collection;
    }

    /**
     * Add collection int.
     *
     * @param collection the collection
     * @return the id of the collection
     */
    public int addCollection(Collection collection) throws Exception {
        int id = 0;

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        id = (int) session.save(collection);
        transaction.commit();

        session.close();
        return id;

    }

    public void deleteCollection(int id) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Collection collection = new Collection();
        collection.setCollectionId(id);

        session.delete(collection);
        transaction.commit();

        session.close();

    }

    public void updateCollection(Collection collection) throws Exception {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(collection);
        transaction.commit();

        session.close();
    }

    public void updateCollection(int collectionId) throws Exception {
        CardDao dao = new CardDao();
        Collection collection = getOne(collectionId);

        int newCardQuantity = dao.getSumOwnedByCollectionId(collectionId);
        double newPrice = dao.getSumPriceByCollectionId(collectionId);

        collection.setCardQuantity(newCardQuantity);
        collection.setPriceAmount(newPrice);

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.update(collection);
        transaction.commit();

        session.close();
    }

}
