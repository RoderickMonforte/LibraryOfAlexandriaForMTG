package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.DecimalFormat;

/**
 * This is the collection entity associated with the user entity
 * Created by student on 2/12/17.
 */
@Entity
@Table(name = "Collection")
public class Collection {


    //This is the unique identifier of a collection
    @Id
    //@GeneratedValue(generator="increment")
    //@GenericGenerator(name="increment", strategy = "increment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_id")
    private int collectionId;

    //This is the associated user id to this collection from the User entity
    @Column(name = "User_user_id")
    private String userId;

    //This is the display name of the collection assigned by the user
    @Column(name = "display_nm")
    private String displayName;

    //This is the description of the collection given by the user
    @Column(name="description_tx")
    private String descriptionText;

    //This is the notes of the user regarding the collection
    @Column(name="note_tx")
    private String noteText;

    //This is the price of the collection on last refresh
    @Column(name="price_at")
    private long priceAmount;

    //This is the quantity of the cards in this collection
    @Column(name="card_qy")
    private int cardQuantity;

    /**
     * Instantiates a new Collection.
     */
    public Collection() {
    }

    /**
     * Instantiates a new Collection.
     *
     * @param userId          the user id
     * @param displayName     the display name
     * @param descriptionText the description text
     * @param noteText        the note text
     * @param priceAmount     the price amount
     * @param cardQuantity    the number of cards
     */
    public Collection(String userId, String displayName, String descriptionText,
                      String noteText, long priceAmount, int cardQuantity) {
        this();
        this.userId = userId;
        this.displayName = displayName;
        this.descriptionText = descriptionText;
        this.noteText = noteText;
        this.priceAmount = priceAmount;
        this.cardQuantity = cardQuantity;
    }

    /**
     * Instantiates a new Collection.
     *
     * @param collectionId    the collection id
     * @param userId          the user id
     * @param displayName     the display name
     * @param descriptionText the description text
     * @param noteText        the note text
     * @param priceAmount     the price amount
     * @param cardQuantity    the number of cards
     */
    public Collection(int collectionId, String userId, String displayName,
                      String descriptionText, String noteText,
                      long priceAmount, int cardQuantity) {
        this();
        this.collectionId = collectionId;
        this.userId = userId;
        this.displayName = displayName;

        if (descriptionText.isEmpty()) {
            this.descriptionText = null;
        } else {
            this.descriptionText = descriptionText;
        }

        if (noteText.isEmpty()) {
            this.noteText = null;
        } else {
            this.noteText = noteText;
        }

        this.priceAmount = priceAmount;
        this.cardQuantity = cardQuantity;
    }

    /**
     * Sets new descriptionText.
     *
     * @param descriptionText New value of descriptionText.
     */
    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    /**
     * Gets priceAmount.
     *
     * @return Value of priceAmount.
     */
    public long getPriceAmount() {
        return priceAmount;
    }
    /**
     * Gets priceAmount.
     *
     * @return Value of priceAmount.
     */
    public String getPriceAmountString() {
        DecimalFormat formatter = new DecimalFormat("$#,##0");
        return formatter.format(priceAmount);
    }
    /**
     * Gets userId.
     *
     * @return Value of userId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets new collectionId.
     *
     * @param collectionId New value of collectionId.
     */
    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * Sets new noteText.
     *
     * @param noteText New value of noteText.
     */
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    /**
     * Gets collectionId.
     *
     * @return Value of collectionId.
     */
    public int getCollectionId() {
        return collectionId;
    }

    /**
     * Gets displayName.
     *
     * @return Value of displayName.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets new priceAmount.
     *
     * @param priceAmount New value of priceAmount.
     */
    public void setPriceAmount(long priceAmount) {
        this.priceAmount = priceAmount;
    }

    /**
     * Sets new userId.
     *
     * @param userId New value of userId.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets descriptionText.
     *
     * @return Value of descriptionText.
     */
    public String getDescriptionText() {
        return descriptionText;
    }

    /**
     * Sets new displayName.
     *
     * @param displayName New value of displayName.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Gets noteText.
     *
     * @return Value of noteText.
     */
    public String getNoteText() {
        return noteText;
    }

    /**
     * Gets cardQuantity.
     *
     * @return Value of cardQuantity.
     */
    public int getCardQuantity() {
        return cardQuantity;
    }
    /**
     * Gets cardQuantity.
     *
     * @return Value of cardQuantity.
     */
    public String getCardQuantityString() {
        DecimalFormat formatter = new DecimalFormat("#,##0");
        return formatter.format(cardQuantity);
    }
    /**
     * Sets new cardQuantity.
     *
     * @param cardQuantity New value of cardQuantity.
     */
    public void setCardQuantity(int cardQuantity) {
        this.cardQuantity = cardQuantity;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collectionId=" + collectionId +
                ", userId='" + userId + '\'' +
                ", displayName='" + displayName + '\'' +
                ", descriptionText='" + descriptionText + '\'' +
                ", noteText='" + noteText + '\'' +
                ", priceAmount=" + priceAmount +
                ", cardQuantity=" + cardQuantity +
                '}';
    }
}
