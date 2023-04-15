package org.shopping.cart;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Main {


    public static void main(String[] args) {

        double cartTotalPrice;
        ArrayList<Item> basketItems = new ArrayList<>();
        basketItems.add(Item.Apple);
        basketItems.add(Item.Bananna);
        basketItems.add(Item.Melon);
        basketItems.add(Item.Lime);
        basketItems.add(Item.Lime);
        basketItems.add(Item.Melon);

        ShoppingCart cart = new ShoppingCart();

        cartTotalPrice = cart.calculateTotalCartPrice(basketItems);

        System.out.println("Your total basket cost is " + cartTotalPrice);
    }
}