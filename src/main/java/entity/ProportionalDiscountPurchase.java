package entity;

import java.util.Scanner;

public class ProportionalDiscountPurchase extends Purchase {
    private final static int CONTROL_NUMBER_OF_UNITS = 10;
    private double discount;

    public ProportionalDiscountPurchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits, int controlNumberOfUnits, double discount) {
        super(productName, priceInEuro, numberOfPurchasedUnits);
        this.discount = discount;
    }
    public ProportionalDiscountPurchase() {}

    public ProportionalDiscountPurchase(Scanner sc) {
        super(sc);
        discount = sc.nextDouble();
    }

    @Override
    public Euro getCost() {
        if (getNumberOfPurchasedUnits() > CONTROL_NUMBER_OF_UNITS) {
            getPriceInEuro().multiplication(getNumberOfPurchasedUnits());
            getPriceInEuro().multiplication((int) Math.ceil((100 - discount) / 100));
            return getPriceInEuro();
        }
        return super.getCost();
    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + discount + ";" + this.getCost();
    }
}