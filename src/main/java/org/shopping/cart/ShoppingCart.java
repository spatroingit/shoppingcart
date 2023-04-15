package org.shopping.cart;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class has all the main implementation to calculate the shopping cart for final amount
 * A solution using Java 8 and lambdas and also linear conditions to keep clean , simple and understandable.
 * Method names are clearly defined for self explanatory and private methods to calculate by type of offer applied to calculate price for the item basket
 * <p>
 * We can refer to the only Test class to validate success and fail cases of total 10 tests which are green when ran
 * <p>
 * Optimize- There is always ways to optimize and this can be optimized using more reactive programming of Java
 * <p>
 * Assumtions and considerations - Even though the problem statement given with each items unit price is integers but total price declared as double considering future implemmentation and scalability of such shopping cart
 * The main method in Main class has validated this ShoppingCart calculation to show total bill
 */

public class ShoppingCart {
    private double totalPrice = 0.0;

    public double calculateTotalCartPrice(ArrayList<Item> basketList) {

        Map<String, Long> itemMap = basketList.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.counting()));

        itemMap.keySet().stream().forEach(
                cartItem -> {
                    if (cartItem.equals("Apple")) {
                        totalPrice += totPriceNoOfferItems(itemMap.get(cartItem), Item.Apple);
                    }
                    if (cartItem.equals("Bananna")) {
                        totalPrice += totPriceNoOfferItems(itemMap.get(cartItem), Item.Bananna);
                    }
                    if (cartItem.equals("Melon")) {
                        totalPrice += totPriceOneOnONeOfferItems(itemMap.get(cartItem), Item.Melon);
                    }
                    if (cartItem.equals("Lime")) {
                        totalPrice += totPriceThreeForTwoOffer(itemMap.get(cartItem), Item.Lime);
                    }
                }
        );
        return totalPrice;
    }


    private double totPriceNoOfferItems(long quantity, Item item) {
        double totalPriceForItem = quantity * item.getItemCost();
        return totalPriceForItem;
    }


    private double totPriceOneOnONeOfferItems(long quantity, Item item) {

        double totalPriceForItem;

        if (quantity % 2 == 0) {
            totalPriceForItem = (quantity / 2) * item.getItemCost();
        } else {
            totalPriceForItem = ((quantity - 1) / 2 * item.getItemCost()) + item.getItemCost();
        }
        return totalPriceForItem;
    }

    private double totPriceThreeForTwoOffer(long quantity, Item item) {

        double totalPriceForItem;
        if (quantity > 2) {
            if (quantity % 3 == 0) {
                totalPriceForItem = ((quantity / 3) * item.getItemCost()) * 2;
            } else if ((quantity - 1) % 3 == 0) {
                totalPriceForItem = (((quantity / 3) * item.getItemCost()) * 2) + item.getItemCost();
            } else {
                totalPriceForItem = (((quantity / 3) * item.getItemCost()) * 2) + 2 * item.getItemCost();
            }
        } else {
            totalPriceForItem = quantity * item.getItemCost();
        }
        return totalPriceForItem;
    }


}
