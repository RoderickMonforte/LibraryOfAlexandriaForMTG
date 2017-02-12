package edu.matc.persistence;

import edu.matc.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * Created by student on 2/12/17.
 * This represent the User Data Access Object
 */
public class UserDao {

    /**
     * retrieve a user given their id
     *
     * @param id the user's id
     * @return user
     */
    public User getUser(String id) throws Exception {
        User user;
        Session session = SessionFactoryProvider.getSessionFactory()
                .openSession();
        user = (User) session.get(User.class, id);
        session.close();

        return user;
    }

    /**
     * add a user
     *
     * @param user
     */
    public void addUser(User user) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);
        transaction.commit();

        session.close();
    }

    /**
     * delete a user by id
     * @param id the user's id
     */
    public void deleteUser(String id) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        User user = new User();
        user.setUserId(id);

        session.delete(user);

        transaction.commit();
        session.close();
    }

    /**
     * Update the user
     * @param user
     */

    public void updateUser(User user) throws Exception {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.update(user);

        transaction.commit();
        session.close();

    }
}
