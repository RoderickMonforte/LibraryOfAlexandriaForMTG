package edu.matc.persistence;

import edu.matc.entity.CardItem;
import edu.matc.entity.CardLocal;
import edu.matc.entity.Collection;
import edu.matc.entity.User;
import io.magicthegathering.api.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * This is just to create test data for testing purposes only. The instance
 * variables are specifically public for easy access.
 *
 * Created by student on 5/6/17.
 */
public class TestData {

    public User user;
    public Collection collection;
    public CardLocal cardLocal;
    public CardItem cardItem;

    public TestData() {
        createUser();
        createCollection();
        createCardItem();
        createCardLocal();
    }

    public void deleteTest() throws Exception {
        new CardDao().deleteCardLocal(cardLocal.getCardId());
        new CardItemDao().deleteCardItem(cardItem.getUniversalCardId());
        new CollectionDao().deleteCollection(collection.getCollectionId());
        new UserDao().deleteUser(user.getUserId());
    }

    /**
     * This creates test CardLocal
     */
    private void createCardLocal() {

        if (collection != null && cardItem != null) {
            cardLocal = new CardLocal(collection.getCollectionId(), cardItem
                    .getUniversalCardId(), 1, 1, "TestNoteText", 0.0,
                    cardItem);
            try {
                cardLocal.setCardId(new CardDao().addCardLocal(cardLocal));
            } catch (Exception e) {
                cardLocal = null;
            }
        }
    }

    /**
     * Create test Card Item
     */
    private void createCardItem() {
        List<String> testString = new ArrayList<>();
        Card card = new Card();

        testString.add("TestString");
        card.setArtist("TestArtist");
        card.setName("TestName");
        card.setId("TestId");
        card.setMultiverseid(99999999);

        cardItem = new CardItem(card, 0.0);

        try {
            cardItem.setUniversalCardId(new CardItemDao().addCardItem
                    (cardItem));
        } catch (Exception e) {
            cardItem = null;
        }
    }


    /**
     * Create Test Collection
     */
    private void createCollection() {

        if (user != null) {
            collection = new Collection(user.getUserId(),
                    "TestCollectionDisplayName", "TestDescriptionText",
                    "TestNoteText", (long) 0.0, 1);
            try {
                collection.setCollectionId(new CollectionDao().addCollection(collection));
            } catch (Exception e) {
                collection = null;
            }
        }
    }

    /**
     * Creates Test User
     */
    private void createUser() {
        user = new User();

        user.setDisplayName("TestDisplayName");
        user.setPasswordText("TestPassword");
        user.setUserId("TestUserId");

        try {
            new UserDao().addUser(user);
        } catch (Exception e) {
            user = null;
        }
    }
}
