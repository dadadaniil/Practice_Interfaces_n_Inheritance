import entity.Euro;
import org.junit.jupiter.api.Assertions;

class TestRunner {

    @org.junit.jupiter.api.Test
    void getCents() {
        Euro euro = new Euro(54);
        Assertions.assertEquals(54, euro.getCents());
    }

    @org.junit.jupiter.api.Test
    void setCentsSetPositiveValue() {
        Euro euro = new Euro(10);
        euro.setCents(100);
        Assertions.assertEquals(100, euro.getCents());
    }

    @org.junit.jupiter.api.Test
    void setCentsSetZeroValue() {
        Euro euro = new Euro(100);
        euro.setCents(0);
        Assertions.assertEquals(0, euro.getCents());
    }

    @org.junit.jupiter.api.Test
    void setCentsSetNegativeValue() {
        Euro euro = new Euro(100);
        euro.setCents(-20);
        Assertions.assertEquals(0, euro.getCents());
    }

    @org.junit.jupiter.api.Test
    void centsToEurosPositiveValue() {
        Euro euro = new Euro(270);
        Assertions.assertEquals("2.70", euro.centsToEuros());
    }

    @org.junit.jupiter.api.Test
    void centsToEurosZeroValue() {
        Euro euro = new Euro(0);
        Assertions.assertEquals("0.00", euro.centsToEuros());
    }

    @org.junit.jupiter.api.Test
    void centsToEurosMiddleZero() {
        Euro euro = new Euro(101);
        Assertions.assertEquals("1.01", euro.centsToEuros());
    }


    @org.junit.jupiter.api.Test
    void testEqualsComparisonWithSmallerValue() {
        Euro euro = new Euro(270);
        Euro euroSecond = new Euro(100);
        Assertions.assertFalse(euro.equals(euroSecond));
    }

    @org.junit.jupiter.api.Test
    void testEqualsComparisonToZero() {
        Euro euro = new Euro(0);
        Euro euroSecond = new Euro(100);
        Assertions.assertFalse(euro.equals(euroSecond));
    }

    @org.junit.jupiter.api.Test
    void testEqualsComparisonWithZero() {
        Euro euro = new Euro(10);
        Euro euroSecond = new Euro(0);
        Assertions.assertFalse(euro.equals(euroSecond));
    }

    @org.junit.jupiter.api.Test
    void compareToPositiveValue() {
        Euro euro = new Euro(270);
        Euro euroSecond = new Euro(100);
        Assertions.assertEquals(170, euro.compareTo(euroSecond));
    }

    @org.junit.jupiter.api.Test
    void compareToSameObjects() {
        Euro euro = new Euro(200);
        Euro euroSecond = new Euro(200);
        Assertions.assertEquals(0, euro.compareTo(euroSecond));
    }

    @org.junit.jupiter.api.Test
    void compareToNegativeResultValue() {
        Euro euro = new Euro(270);
        Euro euroSecond = new Euro(500);
        Assertions.assertEquals(-230, euro.compareTo(euroSecond));
    }

    @org.junit.jupiter.api.Test
    void compareToZeroResultValue() {
        Euro euro = new Euro(500);
        Euro euroSecond = new Euro(500);
        Assertions.assertEquals(0, euro.compareTo(euroSecond));
    }

    @org.junit.jupiter.api.Test
    void testToStringZeroValue() {
        Euro euro = new Euro(0);
        Assertions.assertEquals("0.00", euro.centsToEuros());
    }

    @org.junit.jupiter.api.Test
    void testToStringLastIndexesCheck() {
        Euro euro = new Euro(270);
        Assertions.assertEquals("2.70", euro.centsToEuros());

        euro.setCents(101);
        Assertions.assertEquals("1.01", euro.centsToEuros());
    }
    @org.junit.jupiter.api.Test
    void PurchaseConstructorTest() {
        Purchase purchase= new Purchase("Apple",new Euro(25),12    );
//        Assertions.assertEquals("Apple",purchase.);
    }

}