package test;

import org.junit.Test;
import org.shopping.cart.Item;
import org.shopping.cart.ShoppingCart;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ShoppingCartTest {
    private static final double DELTA = 1e-15;

    @Test
    public void testPriceForBasketOf2Apples() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Apple);
        testBasket.add(Item.Apple);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertEquals(70, totalPrice, DELTA);
    }

    @Test
    public void testPriceForBasketOf2AppleAnd3Bananna() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Apple);
        testBasket.add(Item.Apple);
        testBasket.add(Item.Bananna);
        testBasket.add(Item.Bananna);
        testBasket.add(Item.Bananna);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertEquals(130, totalPrice, DELTA);
    }

    @Test
    public void testPriceForBasketOf2Melons() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Melon);
        testBasket.add(Item.Melon);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertEquals(50, totalPrice, DELTA);
    }

    @Test
    public void testPriceForBasketOf3Melons() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Melon);
        testBasket.add(Item.Melon);
        testBasket.add(Item.Melon);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertEquals(100, totalPrice, DELTA);
    }

    @Test
    public void testPriceForBasketOf3Lime() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertEquals(30, totalPrice, DELTA);
    }
    @Test
    public void testPriceForBasketOf4Lime() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertEquals(45, totalPrice, DELTA);
    }

    @Test
    public void testPriceForBasketOf5Lime() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertEquals(60, totalPrice, DELTA);
    }

    @Test
    public void testPriceForBasketOf3LimeWhenOfferNotApplied() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertFalse("Lime is offer of 3 for 2 at 15 each", totalPrice ==45);
    }


    @Test
    public void testPriceForBasket1Apple2Bananna3MelonAnd5Lime() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Apple);
        testBasket.add(Item.Bananna);
        testBasket.add(Item.Bananna);
        testBasket.add(Item.Bananna);
        testBasket.add(Item.Melon);
        testBasket.add(Item.Melon);
        testBasket.add(Item.Melon);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);

        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertEquals(255, totalPrice, DELTA);
    }

    @Test
    public void testCaseWhenOfferNotApplicableInPriceForBasketOf1Apple1Bananna2MelonAnd3Lime() {
        ArrayList<Item> testBasket = new ArrayList<Item>();
        testBasket.add(Item.Apple);
        testBasket.add(Item.Bananna);
        testBasket.add(Item.Melon);
        testBasket.add(Item.Melon);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        testBasket.add(Item.Lime);
        ShoppingCart cart = new ShoppingCart();
        double totalPrice = cart.calculateTotalCartPrice(testBasket);

        assertFalse("When all offer applied it should be 155",  totalPrice == 200);
    }

}
