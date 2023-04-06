package entity;

import org.junit.jupiter.api.Assertions;

class TestRunner {

    @org.junit.jupiter.api.Test
    void getCents() {
        Euro euro = new Euro(54);
        Assertions.assertEquals(54, euro.getCents());

        euro.setCents(0);
        Assertions.assertEquals(0, euro.getCents());

        euro.setCents(-54);
        Assertions.assertEquals(-54, euro.getCents());
    }

    @org.junit.jupiter.api.Test
    void setCents() {
        Euro euro = new Euro(0);
        euro.setCents(-20);
        Assertions.assertEquals(-20, euro.getCents());

        euro.setCents(0);
        Assertions.assertEquals(0, euro.getCents());

        euro.setCents(100);
        Assertions.assertEquals(100, euro.getCents());

    }

    @org.junit.jupiter.api.Test
    void centsToEuros() {
        Euro euro = new Euro(270);
        Assertions.assertEquals("2.70", euro.centsToEuros());

        euro.setCents(0);
        Assertions.assertEquals("0.00", euro.centsToEuros());

        euro.setCents(101);
        Assertions.assertEquals("1.01", euro.centsToEuros());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Euro euro = new Euro(270);
        Euro euroSecond = new Euro(100);
        Assertions.assertFalse(euro.equals(euroSecond));

        euro.setCents(0);
        Assertions.assertFalse(euro.equals(euroSecond));

        euroSecond.setCents(0);
        Assertions.assertTrue(euro.equals(euroSecond));

        euroSecond.setCents(300);
        euro.setCents(300);
        Assertions.assertTrue(euro.equals(euroSecond));

    }

    @org.junit.jupiter.api.Test
    void compareTo() {
        Euro euro = new Euro(270);
        Euro euroSecond = new Euro(100);
        Assertions.assertEquals(170, euro.compareTo(euroSecond));

        euroSecond.setCents(500);
        Assertions.assertEquals(-230, euro.compareTo(euroSecond));

        euro.setCents(500);
        Assertions.assertEquals(0, euro.compareTo(euroSecond));
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Euro euro = new Euro(270);
        Assertions.assertEquals("2.70", euro.centsToEuros());

        euro.setCents(0);
        Assertions.assertEquals("0.00", euro.centsToEuros());

        euro.setCents(101);
        Assertions.assertEquals("1.01", euro.centsToEuros());
    }
}