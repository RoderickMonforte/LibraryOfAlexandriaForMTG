package edu.matc.entity;


import io.magicthegathering.api.Card;

import javax.persistence.*;

/**
 * Created by student on 3/4/17.
 */
@Entity
@Table(name = "CardItem")
public class CardItem {
    //This is the unique id of the card in the list
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "universal_card_id")
    int universalCardId;

    //This is the card identifier in the Magic The Gathering card universe
    @Column
    private int multiverseId;

    //This is the name of the card
    @Column
    private String cardName;

    //This is the card's artist name
    @Column
    private String artist;

    //this is the card's type
    @Column
    private String type;

    //this is the card's different types
    @Column
    private String types;

    //This is the card's super types
    @Column
    private String supertypes;

    //this is the card's sub types
    @Column
    private String subtypes;

    //this is the card's colors
    @Column
    private String colors;

    //this is the card's set name
    @Column
    private String setName;

    //this is the card's set code
    @Column
    private String cardSet;

    //this is the card's printing list
    @Column
    private String printings;

    //this is the card's image url
    @Column
    private String imageUrl;

    //this is the card's text
    @Column
    private String cardText;

    //this is the card's flavor text
    @Column
    private String flavor;

    //this is the card's original text
    @Column
    private String originalText;

    //this is the card's power
    @Column
    private String power;

    //this is the card's toughness
    @Column
    private String toughness;

    //this is the card api id
    @Column
    private String id;

    //this is the card's mana cost
    @Column
    private String manaCost;

    //this is the card's colorless mana cost
    @Column
    private double cmc;

    //this is the card's rarity
    @Column
    private String rarity;

    //this is the card's layout
    @Column
    private String layout;

    //this is the card's price
    @Column
    private double price;

    /**
     * Empty Constructor
     */
    public CardItem() {
    }

    /**
     * CardsItem Constructor
     * @param cardsItem
     */
    public CardItem(Card cardsItem, double price) {
        this();
        this.artist = cardsItem.getArtist();
        this.cmc = cardsItem.getCmc();

        this.colors = "colorless";
        if (cardsItem.getColors() != null) {
            this.colors = "";
            for (String color : cardsItem.getColors()) {
                this.colors += (color + " ");
            }
        }

        this.flavor = cardsItem.getFlavor();
        this.id = cardsItem.getId();
        this.imageUrl = cardsItem.getImageUrl();
        this.layout = cardsItem.getLayout();
        this.manaCost = cardsItem.getManaCost();
        this.multiverseId = cardsItem.getMultiverseid();
        this.cardName = cardsItem.getName();
        this.originalText = cardsItem.getOriginalText();
        this.power = cardsItem.getPower();

        this.printings = "no printing";
        if (cardsItem.getPrintings() != null) {
            this.printings = "";
            for (String printing : cardsItem.getPrintings()) {
                this.printings += (printing + " ");
            }
        }

        this.rarity = cardsItem.getRarity();
        this.cardSet = cardsItem.getSet();
        this.setName = cardsItem.getSetName();

        this.supertypes = "no supertype";
        if (cardsItem.getSupertypes() != null ) {
            this.supertypes = "";
            for (String supertype : cardsItem.getSupertypes()) {
                this.supertypes += (supertype + " ");
            }
        }

        this.subtypes = "no subtype";
        if (cardsItem.getSubtypes() != null) {
            this.subtypes = "";
            for (String subtype : cardsItem.getSubtypes()) {
                this.subtypes += (subtype + " ");
            }
        }

        this.cardText = cardsItem.getText();

        this.type = cardsItem.getType();

        this.types = "no type";
        if (cardsItem.getTypes() != null) {
            this.types = "";
            for (String typeType : cardsItem.getTypes()) {
                this.types += (typeType + " ");
            }
        }

        this.toughness = cardsItem.getToughness();
        this.price = price;

    }

    /**
     * CardItem with Id Constructor
     * @param universalCardId;
     * @param cardsItem
     */
    public CardItem(int universalCardId, Card cardsItem, double price) {
        this(cardsItem, price);
        this.universalCardId = universalCardId;
    }


    /**
     * Sets new layout.
     *
     * @param layout New value of layout.
     */
    public void setLayout(String layout) {
        this.layout = layout;
    }

    /**
     * Gets toughness.
     *
     * @return Value of toughness.
     */
    public String getToughness() {
        return toughness;
    }

    /**
     * Sets new rarity.
     *
     * @param rarity New value of rarity.
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * Gets manaCost.
     *
     * @return Value of manaCost.
     */
    public String getManaCost() {
        return manaCost;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets flavor.
     *
     * @return Value of flavor.
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Sets new power.
     *
     * @param power New value of power.
     */
    public void setPower(String power) {
        this.power = power;
    }

    /**
     * Sets new subtypes.
     *
     * @param subtypes New value of subtypes.
     */
    public void setSubtypes(String subtypes) {
        this.subtypes = subtypes;
    }

    /**
     * Sets new supertypes.
     *
     * @param supertypes New value of supertypes.
     */
    public void setSupertypes(String supertypes) {
        this.supertypes = supertypes;
    }

    /**
     * Gets text.
     *
     * @return Value of text.
     */
    public String getCardText() {
        return cardText;
    }

    /**
     * Gets types.
     *
     * @return Value of types.
     */
    public String getTypes() {
        return types;
    }

    /**
     * Gets layout.
     *
     * @return Value of layout.
     */
    public String getLayout() {
        return layout;
    }

    /**
     * Sets new toughness.
     *
     * @param toughness New value of toughness.
     */
    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    /**
     * Sets new type.
     *
     * @param type New value of type.
     */
    public void setType(String type) {
        this.type = type;
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
     * Sets new cmc.
     *
     * @param cmc New value of cmc.
     */
    public void setCmc(double cmc) {
        this.cmc = cmc;
    }

    /**
     * Sets new setName.
     *
     * @param setName New value of setName.
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * Sets new artist.
     *
     * @param artist New value of artist.
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Sets new multiverseId.
     *
     * @param multiverseId New value of multiverseId.
     */
    public void setMultiverseId(int multiverseId) {
        this.multiverseId = multiverseId;
    }

    /**
     * Sets new colors.
     *
     * @param colors New value of colors.
     */
    public void setColors(String colors) {
        this.colors = colors;
    }

    /**
     * Gets power.
     *
     * @return Value of power.
     */
    public String getPower() {
        return power;
    }

    /**
     * Gets colors.
     *
     * @return Value of colors.
     */
    public String getColors() {
        return colors;
    }

    /**
     * Sets new types.
     *
     * @param types New value of types.
     */
    public void setTypes(String types) {
        this.types = types;
    }

    /**
     * Gets artist.
     *
     * @return Value of artist.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets new name.
     *
     * @param name New value of name.
     */
    public void setCardName(String name) {
        this.cardName = name;
    }

    /**
     * Sets new originalText.
     *
     * @param originalText New value of originalText.
     */
    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    /**
     * Gets rarity.
     *
     * @return Value of rarity.
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * Sets new manaCost.
     *
     * @param manaCost New value of manaCost.
     */
    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    /**
     * Sets new set.
     *
     * @param set New value of set.
     */
    public void setCardSet(String set) {
        this.cardSet = set;
    }

    /**
     * Gets imageUrl.
     *
     * @return Value of imageUrl.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Gets subtypes.
     *
     * @return Value of subtypes.
     */
    public String getSubtypes() {
        return subtypes;
    }

    /**
     * Sets new text.
     *
     * @param text New value of text.
     */
    public void setCardText(String text) {
        this.cardText = text;
    }

    /**
     * Gets multiverseId.
     *
     * @return Value of multiverseId.
     */
    public int getMultiverseId() {
        return multiverseId;
    }

    /**
     * Sets new printings.
     *
     * @param printings New value of printings.
     */
    public void setPrintings(String printings) {
        this.printings = printings;
    }

    /**
     * Gets name.
     *
     * @return Value of name.
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Gets originalText.
     *
     * @return Value of originalText.
     */
    public String getOriginalText() {
        return originalText;
    }

    /**
     * Gets setName.
     *
     * @return Value of setName.
     */
    public String getSetName() {
        return setName;
    }

    /**
     * Gets set.
     *
     * @return Value of set.
     */
    public String getCardSet() {
        return cardSet;
    }

    /**
     * Gets cmc.
     *
     * @return Value of cmc.
     */
    public double getCmc() {
        return cmc;
    }

    /**
     * Gets printings.
     *
     * @return Value of printings.
     */
    public String getPrintings() {
        return printings;
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
     * Gets supertypes.
     *
     * @return Value of supertypes.
     */
    public String getSupertypes() {
        return supertypes;
    }

    /**
     * Gets type.
     *
     * @return Value of type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets new imageUrl.
     *
     * @param imageUrl New value of imageUrl.
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Sets new flavor.
     *
     * @param flavor New value of flavor.
     */
    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    /**
     * Gets price.
     *
     * @return Value of price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets new price.
     *
     * @param price New value of price.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
