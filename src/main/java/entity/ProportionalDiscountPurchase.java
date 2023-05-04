package entity;

import java.util.Scanner;

public class ProportionalDiscountPurchase extends Purchase {
    private final static int CONTROL_NUMBER_OF_UNITS = 10;
    private double discount;

    public ProportionalDiscountPurchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits, double discount) {
        super(productName, priceInEuro, numberOfPurchasedUnits);
        this.discount = discount;
    }

    public ProportionalDiscountPurchase() {
    }

    public ProportionalDiscountPurchase(Scanner sc) {
        super(sc);
        discount = sc.nextDouble();
    }

    @Override
    public Euro getCost() {

        Euro euro = new Euro();
        if (getNumberOfPurchasedUnits() > CONTROL_NUMBER_OF_UNITS) {
            euro.setCents((int) Math.ceil(((100 - discount) / 100 * getPriceInEuro().getCents() * getNumberOfPurchasedUnits())));
        } else {
            euro = super.getCost();
        }
        return euro;

    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}