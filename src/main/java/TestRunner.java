import entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;


class TestRunner {

    @Test
    void getCents() {
        Euro euro = new Euro(54);
        assertEquals(54, euro.getCents());
    }

    @Test
    void setCentsSetPositiveValue() {
        Euro euro = new Euro(10);
        euro.setCents(100);
        assertEquals(100, euro.getCents());
    }

    @Test
    void setCentsSetZeroValue() {
        Euro euro = new Euro(100);
        euro.setCents(0);
        assertEquals(0, euro.getCents());
    }

    @Test
    void setCentsSetNegativeValue() {
        Euro euro = new Euro(100);
        euro.setCents(-20);
        assertEquals(-20, euro.getCents());
    }

    @Test
    void centsToEurosPositiveValue() {
        Euro euro = new Euro(270);
        assertEquals("2.70", euro.centsToEuros());
    }

    @Test
    void centsToEurosZeroValue() {
        Euro euro = new Euro(0);
        assertEquals("0.00", euro.centsToEuros());
    }

    @Test
    void centsToEurosMiddleZero() {
        Euro euro = new Euro(101);
        assertEquals("1.01", euro.centsToEuros());
    }


    @Test
    void testEqualsComparisonWithSmallerValue() {
        Euro euro = new Euro(270);
        Euro euroSecond = new Euro(100);
        assertNotEquals(euro, euroSecond);
    }

    @Test
    void testEqualsComparisonToZero() {
        Euro euro = new Euro(0);
        Euro euroSecond = new Euro(100);
        assertNotEquals(euro, euroSecond);
    }

    @Test
    void testEqualsComparisonWithZero() {
        Euro euro = new Euro(10);
        Euro euroSecond = new Euro(0);
        assertNotEquals(euro, euroSecond);
    }

    @Test
    void compareToPositiveValue() {
        Euro euro = new Euro(270);
        Euro euroSecond = new Euro(100);
        assertEquals(170, euro.compareTo(euroSecond));
    }

    @Test
    void compareToSameObjects() {
        Euro euro = new Euro(200);
        Euro euroSecond = new Euro(200);
        assertEquals(0, euro.compareTo(euroSecond));
    }

    @Test
    void compareToNegativeResultValue() {
        Euro euro = new Euro(270);
        Euro euroSecond = new Euro(500);
        assertEquals(-230, euro.compareTo(euroSecond));
    }

    @Test
    void compareToZeroResultValue() {
        Euro euro = new Euro(500);
        Euro euroSecond = new Euro(500);
        assertEquals(0, euro.compareTo(euroSecond));
    }

    @Test
    void testToStringZeroValue() {
        Euro euro = new Euro(0);
        assertEquals("0.00", euro.centsToEuros());
    }

    @Test
    void testToStringLastIndexesCheck() {
        Euro euro = new Euro(270);
        assertEquals("2.70", euro.centsToEuros());

        euro.setCents(101);
        assertEquals("1.01", euro.centsToEuros());
    }

    @Test
    void subtractionNegativeArgument() {
        Euro euro = new Euro(10);
        Euro euro1 = new Euro(-19);
        euro.subtraction(euro1);
        assertEquals(29, euro.getCents());
    }

    @Test
    void subtractionPositiveArgument() {
        Euro euro = new Euro(10);
        Euro euro1 = new Euro(5);
        euro.subtraction(euro1);
        assertEquals(5, euro.getCents());
    }

    @Test
    void additionPositiveArgument() {
        Euro euro = new Euro(10);
        Euro euro1 = new Euro(15);
        euro.addition(euro1);
        assertEquals(25, euro.getCents());
    }

    @Test
    void additionNegativeArgument() {
        Euro euro = new Euro(10);
        Euro euro1 = new Euro(-15);
        euro.addition(euro1);
        assertEquals(-5, euro.getCents());
    }

    @Test
    void multiplication() {
        Euro euro = new Euro(10);
        euro.multiplication(5);
        assertEquals(50, euro.getCents());
    }

    @Test
    void zeroing() {
        Euro euro = new Euro(270);
        euro.zeroing();
        assertEquals(0, euro.getCents());
    }

    @Test
    void PurchaseConstructorTestName() {
        Purchase purchase = new Purchase("Apple", new Euro(25), 12);
        assertEquals("Apple", purchase.getProductName());
    }

    @Test
    void PurchaseConstructorTestEuro() {
        Euro priceInEuro = new Euro(25);
        Purchase purchase = new Purchase("Apple", priceInEuro, 12);
        assertEquals(priceInEuro, purchase.getPriceInEuro());
    }

    @Test
    void PurchaseConstructorTestNumber() {
        Purchase purchase = new Purchase("Apple", new Euro(25), 12);
        assertEquals(12, purchase.getNumberOfPurchasedUnits());
    }

    @Test
    void PurchaseGetCostWithEnoughForDiscountPurchasesAndZeroDiscount() {
        Euro priceInEuro = new Euro(20);
        var proportionalDiscountPurchase = new ProportionalDiscountPurchase("Apple", priceInEuro, 10, 0d);
        assertEquals(new Euro(200), proportionalDiscountPurchase.getCost());
        assertEquals(20, priceInEuro.getCents());
    }

    @Test
    void PurchaseGetCostWithControlNumberOfPurchases() {
        Euro priceInEuro = new Euro(10);
        var proportionalDiscountPurchase = new ProportionalDiscountPurchase("Apple", priceInEuro, 10, 10d);
        assertEquals(new Euro(90), proportionalDiscountPurchase.getCost());
        assertEquals(10, priceInEuro.getCents());
    }

    @Test
    void PurchaseGetCostWithNotEnoughForDiscountPurchases() {
        Euro priceInEuro = new Euro(5);
        var proportionalDiscountPurchase = new ProportionalDiscountPurchase("Apple", priceInEuro, 2, 10d);
        assertEquals(new Euro(10), proportionalDiscountPurchase.getCost());
        assertEquals(5, priceInEuro.getCents());
    }

    @Test
    void PurchaseGetCostWithEnoughForDiscountPurchases() {
        Euro priceInEuro = new Euro(5);
        var proportionalDiscountPurchase = new ProportionalDiscountPurchase("Apple", priceInEuro, 12, 10d);
        assertEquals(new Euro(54), proportionalDiscountPurchase.getCost());
        assertEquals(5, priceInEuro.getCents());
    }

    @Test
    void PurchaseIsEquals() {
        Euro priceInEuro = new Euro(25);
        Purchase purchase = new Purchase("Apple", priceInEuro, 12);
        assertEquals(purchase, purchase);
    }

    @Test
    void PurchaseIsEqualsToObject() {
        Euro priceInEuro = new Euro(25);
        Purchase purchase = new Purchase("Apple", priceInEuro, 12);
        Object object = new Object();
        assertFalse(purchase.equals(object));
    }

    @Test
    void getPurchaseFromFactory() throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("src/in2.txt"));
        scanner.useLocale(Locale.ENGLISH);
        assertEquals("Purchase;Milk;1.80;3;5.40", PurchasesFactory.getPurchaseFromFactory(scanner).toString());
    }

    @Test
    void getPurchaseFromFactoryNonExistingObject() throws NoSuchElementException, FileNotFoundException {
        Exception isNoSuchElementException = null;

        Scanner scanner = new Scanner(new FileReader("src/in2.txt"));
        scanner.useLocale(Locale.ENGLISH);
        int counter = 0;
        while (counter < 6) {
            counter++;
            PurchasesFactory.getPurchaseFromFactory(scanner);
        }
        try {
            PurchasesFactory.getPurchaseFromFactory(scanner);
        } catch (NoSuchElementException noSuchElementException) {
            isNoSuchElementException = noSuchElementException;
        }
        NoSuchElementException exception = new NoSuchElementException();
        assertEquals(exception.getMessage(), isNoSuchElementException.getMessage());

    }

    @Test
    void factory() {
        var scanner = new Scanner("GENERAL_PURCHASE Apple 1000 1");
        var purchase = PurchasesFactory.getPurchaseFromFactory(scanner);
        assertTrue(purchase instanceof Purchase);
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
        assertEquals(new Euro(2250), (new Euro(1020)).mul(2.2, RoundMethod.CEIL, 0));
        assertEquals(new Euro(2240), (new Euro(1020)).mul(2.2, RoundMethod.ROUND, 0));

        assertEquals(new Euro(2040), (new Euro(2044)).round(RoundMethod.ROUND, 0));
        assertEquals(new Euro(2040), (new Euro(2044)).round(RoundMethod.FLOOR, 0));
        assertEquals(new Euro(2050), (new Euro(2044)).round(RoundMethod.CEIL, 0));
    }

}