import entity.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;


class TestRunner {

    @org.junit.jupiter.api.Test
    void getCents() {
        Euro euro = new Euro(54);
        Assertions.assertEquals(54, euro.getCents());
    }

    @org.junit.jupiter.api.Test
    void setCentsSetValues() {
        Euro euro1 = new Euro(10);
        euro1.setCents(100);
        Assertions.assertEquals(100, euro1.getCents());

        Euro euro2 = new Euro(100);
        euro2.setCents(0);
        Assertions.assertEquals(0, euro2.getCents());

        Euro euro3 = new Euro(100);
        euro3.setCents(-20);
        Assertions.assertEquals(-20, euro3.getCents());
    }
    @org.junit.jupiter.api.Test
    void centsToEurosConversion() {
        Euro euro1 = new Euro(270);
        Assertions.assertEquals("2.70", euro1.centsToEuros());

        Euro euro2 = new Euro(0);
        Assertions.assertEquals("0.00", euro2.centsToEuros());

        Euro euro3 = new Euro(101);
        Assertions.assertEquals("1.01", euro3.centsToEuros());
    }



    @org.junit.jupiter.api.Test
    void testEqualsComparison() {
        Euro euro1 = new Euro(270);
        Euro euroSecond1 = new Euro(100);
        Assertions.assertNotEquals(euro1, euroSecond1);

        Euro euro2 = new Euro(0);
        Euro euroSecond2 = new Euro(100);
        Assertions.assertNotEquals(euro2, euroSecond2);

        Euro euro3 = new Euro(10);
        Euro euroSecond3 = new Euro(0);
        Assertions.assertNotEquals(euro3, euroSecond3);
    }


    @org.junit.jupiter.api.Test
    void testCompareTo() {
        Euro euro1 = new Euro(270);
        Euro euroSecond1 = new Euro(100);
        Assertions.assertEquals(170, euro1.compareTo(euroSecond1));

        Euro euro2 = new Euro(200);
        Euro euroSecond2 = new Euro(200);
        Assertions.assertEquals(0, euro2.compareTo(euroSecond2));

        Euro euro3 = new Euro(270);
        Euro euroSecond3 = new Euro(500);
        Assertions.assertEquals(-230, euro3.compareTo(euroSecond3));

        Euro euro4 = new Euro(500);
        Euro euroSecond4 = new Euro(500);
        Assertions.assertEquals(0, euro4.compareTo(euroSecond4));
    }


    @org.junit.jupiter.api.Test
    void testToString() {
        Euro euro1 = new Euro(0);
        Assertions.assertEquals("0.00", euro1.centsToEuros());

        Euro euro2 = new Euro(270);
        Assertions.assertEquals("2.70", euro2.centsToEuros());

        euro2.setCents(101);
        Assertions.assertEquals("1.01", euro2.centsToEuros());
    }


    @org.junit.jupiter.api.Test
    void testSubtraction() {
        Euro euro1 = new Euro(10);
        Euro euro2 = new Euro(-19);
        euro1.subtraction(euro2);
        Assertions.assertEquals(29, euro1.getCents());

        Euro euro3 = new Euro(10);
        Euro euro4 = new Euro(5);
        euro3.subtraction(euro4);
        Assertions.assertEquals(5, euro3.getCents());
    }


    @org.junit.jupiter.api.Test
    void testAddition() {
        Euro euro1 = new Euro(10);
        Euro euro2 = new Euro(15);
        euro1.addition(euro2);
        Assertions.assertEquals(25, euro1.getCents());

        Euro euro3 = new Euro(10);
        Euro euro4 = new Euro(-15);
        euro3.addition(euro4);
        Assertions.assertEquals(-5, euro3.getCents());
    }


    @org.junit.jupiter.api.Test
    void multiplication() {
        Euro euro = new Euro(10);
        euro.multiplication(5);
        Assertions.assertEquals(50, euro.getCents());
    }

    @org.junit.jupiter.api.Test
    void zeroing() {
        Euro euro = new Euro(270);
        euro.zeroing();
        Assertions.assertEquals(0, euro.getCents());
    }

    @org.junit.jupiter.api.Test
    void testPurchaseConstructor() {
        Purchase purchase1 = new Purchase("Apple", new Euro(25), 12);
        Assertions.assertEquals("Apple", purchase1.getProductName());

        Euro priceInEuro = new Euro(25);
        Purchase purchase2 = new Purchase("Apple", priceInEuro, 12);
        Assertions.assertEquals(priceInEuro, purchase2.getPriceInEuro());

        Purchase purchase3 = new Purchase("Apple", new Euro(25), 12);
        Assertions.assertEquals(12, purchase3.getNumberOfPurchasedUnits());
    }


    @org.junit.jupiter.api.Test
    void PurchaseGetCostWithEnoughForDiscountPurchasesAndZeroDiscount() {
        Euro priceInEuro = new Euro(20);
        var proportionalDiscountPurchase = new ProportionalDiscountPurchase("Apple", priceInEuro, 10, 0d);
        Assertions.assertEquals(new Euro(200), proportionalDiscountPurchase.getCost());
        Assertions.assertEquals(20, priceInEuro.getCents());
    }

    @org.junit.jupiter.api.Test
    void PurchaseGetCostWithControlNumberOfPurchases() {
        Euro priceInEuro = new Euro(10);
        var proportionalDiscountPurchase = new ProportionalDiscountPurchase("Apple", priceInEuro, 10, 10d);
        Assertions.assertEquals(new Euro(100), proportionalDiscountPurchase.getCost());
        Assertions.assertEquals(10, priceInEuro.getCents());
    }

    @org.junit.jupiter.api.Test
    void testProportionalDiscountPurchaseGetCost() {
        // Test with not enough for discount purchases
        Euro priceInEuro1 = new Euro(5);
        var proportionalDiscountPurchase1 = new ProportionalDiscountPurchase("Apple", priceInEuro1, 2, 10d);
        Assertions.assertEquals(new Euro(10), proportionalDiscountPurchase1.getCost());
        Assertions.assertEquals(5, priceInEuro1.getCents());

        // Test with enough for discount purchases
        Euro priceInEuro2 = new Euro(5);
        var proportionalDiscountPurchase2 = new ProportionalDiscountPurchase("Apple", priceInEuro2, 12, 10d);
        Assertions.assertEquals(new Euro(54), proportionalDiscountPurchase2.getCost());
        Assertions.assertEquals(5, priceInEuro2.getCents());
    }


    @org.junit.jupiter.api.Test
    void testPurchaseMethods() {
        Euro priceInEuro = new Euro(25);
        Purchase purchase1 = new Purchase("Apple", priceInEuro, 12);
        Assertions.assertEquals(purchase1, purchase1);

        Purchase purchase2 = new Purchase("Apple", priceInEuro, 12);
        Object object = new Object();
        Assertions.assertNotEquals(purchase2, object);
    }


    @org.junit.jupiter.api.Test
    void testPurchasesFactoryMethods() throws FileNotFoundException {
        Scanner scanner1 = new Scanner(new FileReader("src/in2.txt"));
        scanner1.useLocale(Locale.ENGLISH);
        Assertions.assertEquals("Purchase;Milk;1.80;3;5.40", PurchasesFactory.getPurchaseFromFactory(scanner1).toString());

        Exception isNoSuchElementException = null;

        Scanner scanner2 = new Scanner(new FileReader("src/in2.txt"));
        scanner2.useLocale(Locale.ENGLISH);
        int counter = 0;
        while (counter < 6) {
            counter++;
            PurchasesFactory.getPurchaseFromFactory(scanner2);
        }
        try {
            PurchasesFactory.getPurchaseFromFactory(scanner2);
        } catch (NoSuchElementException noSuchElementException) {
            isNoSuchElementException = noSuchElementException;
        }
        NoSuchElementException exception = new NoSuchElementException();
        assert isNoSuchElementException != null;
        Assertions.assertEquals(exception.getMessage(), isNoSuchElementException.getMessage());
    }



    @org.junit.jupiter.api.Test
    void factory() {
        var scanner = new Scanner("GENERAL_PURCHASE Apple 1000 1");
        var purchase = PurchasesFactory.getPurchaseFromFactory(scanner);
        assertNotNull(purchase);
        assertEquals(new Euro(1000), purchase.getPriceInEuro());

        scanner = new Scanner("PURCHASE_WITH_DISCOUNT Apple 2000 2 1");
        purchase = PurchasesFactory.getPurchaseFromFactory(scanner);
        assertTrue(purchase instanceof DiscountPerUnitPurchase);
        assertEquals(new Euro(2000), purchase.getPriceInEuro());

        scanner = new Scanner("PURCHASE_WITH_PROPORTIONAL_DISCOUNT Apple 3000 3 5 0.2");
        purchase = PurchasesFactory.getPurchaseFromFactory(scanner);
        assertTrue(purchase instanceof ProportionalDiscountPurchase);
        assertEquals(new Euro(3000), purchase.getPriceInEuro());
    }

    @Test
    void rounding() {
        assertEquals(new Euro(2250), (new Euro(1020)).mul(2.2, RoundMethod.CEIL, 1));
        assertEquals(new Euro(2240), (new Euro(1020)).mul(2.2, RoundMethod.ROUND, 1));

        assertEquals(new Euro(2040), (new Euro(2044)).round(RoundMethod.ROUND, 1));
        assertEquals(new Euro(2040), (new Euro(2044)).round(RoundMethod.FLOOR, 1));
        assertEquals(new Euro(2050), (new Euro(2044)).round(RoundMethod.CEIL, 1));
    }

}