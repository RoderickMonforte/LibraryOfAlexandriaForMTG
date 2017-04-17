package edu.matc.entity;

import javax.persistence.*;
import java.text.DecimalFormat;

/**
 * Created by student on 3/4/17.
 */
@Entity
@Table(name = "Card")
public class CardLocal {
    //This is the unique identifier of a card
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private int cardId;

    //This is the associated collection id for this card
    @Column(name = "Collection_collection_id")
    private int collectionId;

    //This is the card identifier in the Magict The Gathering card universe
    @Column(name = "universal_card_id")
    private int universalCardId;

    //This is the name of the card
    @Column
    private String name;
    
    //This is the number of instance of this card owned by the user for this
    // collection.
    @Column(name = "owned_qy")
    private int ownedQuantity;

    //This is the number of instance of this card wished the user has in this
    // collection.
    @Column(name = "wishlist_qy")
    private int wishList;

    //This is the notes the user has on this card.
    @Column(name = "note_tx")
    private String noteText;

    //This is the price of the card in the last price check
    @Column(name = "price_at")
    private double priceAmount;


    /**
     * Empty Constructor
     */
    public CardLocal() {
    }

    /**
     * Constructor without the primary key
     * @param collectionId
     * @param universalCardId
     * @param name
     * @param ownedQuantity
     * @param wishList
     * @param noteText
     * @param priceAmount
     */
    public CardLocal(int collectionId, int universalCardId, String name, int 
            ownedQuantity, int wishList, String noteText, double priceAmount) {
        this();
        this.collectionId = collectionId;
        this.universalCardId = universalCardId;
        this.name = name;
        this.ownedQuantity = ownedQuantity;
        this.wishList = wishList;
        this.noteText = noteText;
        this.priceAmount = priceAmount;
    }

    /**
     * Constructor without the primary key
     * @param cardId
     * @param collectionId
     * @param universalCardId
     * @param name
     * @param ownedQuantity
     * @param wishList
     * @param noteText
     * @param priceAmount
     */
    public CardLocal(int cardId, int collectionId, int universalCardId, 
            String name, int ownedQuantity, int wishList, String noteText, double priceAmount) {

        this(collectionId, universalCardId, name, ownedQuantity, wishList,
                noteText, priceAmount);

        this.cardId = cardId;
    }


    /**
     * Gets wishList.
     *
     * @return Value of wishList.
     */
    public int getWishList() {
        return wishList;
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
     * Sets new wishList.
     *
     * @param wishList New value of wishList.
     */
    public void setWishList(int wishList) {
        this.wishList = wishList;
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
     * Sets new universalCardId.
     *
     * @param universalCardId New value of universalCardId.
     */
    public void setUniversalCardId(int universalCardId) {
        this.universalCardId = universalCardId;
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
     * Sets new collectionId.
     *
     * @param collectionId New value of collectionId.
     */
    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * Sets new cardId.
     *
     * @param cardId New value of cardId.
     */
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    /**
     * Gets ownedQuantity.
     *
     * @return Value of ownedQuantity.
     */
    public int getOwnedQuantity() {
        return ownedQuantity;
    }

    /**
     * Gets cardId.
     *
     * @return Value of cardId.
     */
    public int getCardId() {
        return cardId;
    }

    /**
     * Sets new priceAmount.
     *
     * @param priceAmount New value of priceAmount.
     */
    public void setPriceAmount(double priceAmount) {
        this.priceAmount = priceAmount;
    }

    /**
     * Sets new ownedQuantity.
     *
     * @param ownedQuantity New value of ownedQuantity.
     */
    public void setOwnedQuantity(int ownedQuantity) {
        this.ownedQuantity = ownedQuantity;
    }

    /**
     * Gets universalCardId.
     *
     * @return Value of universalCardId.
     */
    public int getUniversalCardId() {
        return universalCardId;
    }

    /**
     * Gets priceAmount.
     *
     * @return Value of priceAmount.
     */
    public double getPriceAmount() {
        return priceAmount;
    }
    public String getPriceAmountString() {
        DecimalFormat formatter = new DecimalFormat("$#,##0.00");
        return formatter.format(priceAmount);
    }
    /**
     * Gets ownedQuantity formatted.
     *
     * @return Value of ownedQuantity.
     */
    public String getOwnedQuantityString() {
        DecimalFormat formatter = new DecimalFormat("#,##0");
        return formatter.format(ownedQuantity);
    }
    /**
     * Gets wishList.
     *
     * @return Value of wishList.
     */
    public String getWishListString() {
        DecimalFormat formatter = new DecimalFormat("#,##0");
        return formatter.format(wishList);
    }
    /**
     * @return card string representation of the attributes
     */
    @Override
    public String toString() {
        return "CardLocal{" +
                "cardId=" + cardId +
                ", collectionId=" + collectionId +
                ", universalCardId=" + universalCardId +
                ", ownedQuantity=" + ownedQuantity +
                ", wishList=" + wishList +
                ", noteText='" + noteText + '\'' +
                ", priceAmount=" + priceAmount +
                '}';
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setName(String name) {
        this.name = name;
    }

}
