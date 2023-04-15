package org.shopping.cart;

public class Item {

    private String name;
    private int itemCost;
    private InOfferEnum inOffer;

    public static Item Apple = new Item ("Apple" ,  InOfferEnum.NO_OFFER, 35 );
    public static Item Bananna = new Item ("Bananna" ,  InOfferEnum.NO_OFFER, 20 );
    public static Item Melon = new Item ("Melon" ,  InOfferEnum.ONE_ON_ONE_OFFER, 50 );
    public static Item Lime = new Item ("Lime" ,  InOfferEnum.THREE_FOR_TWO_OFFER   , 15 );

    public Item(String name, InOfferEnum inOffer, int itemCost){
        this.name = name;
        this.inOffer =inOffer;
        this.itemCost =itemCost;
    }

    public String getName() {
        return name;
    }

    public int getItemCost() {
        return itemCost;
    }
    

}
