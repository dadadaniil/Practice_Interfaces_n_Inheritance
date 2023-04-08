package entity;

import java.util.Scanner;

public class ProportionalDiscountPurchase extends Purchase {
    private int controlNumberOfUnits;
    private double discount;

    public ProportionalDiscountPurchase() {
    }

    public ProportionalDiscountPurchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits, int controlNumberOfUnits, double discount) {
        super(productName, priceInEuro, numberOfPurchasedUnits);
        this.controlNumberOfUnits = controlNumberOfUnits;
        this.discount = discount;
    }

    public ProportionalDiscountPurchase(Scanner sc) {
        super(sc);
        controlNumberOfUnits = sc.nextInt();
        discount = sc.nextDouble();
    }

    @Override
    public Euro getCost() {
        if (getNumberOfPurchasedUnits() > controlNumberOfUnits) {
            return new Euro((int) (getPriceInEuro().getCents() * getNumberOfPurchasedUnits() * (100 - discount) / 100));
        }
        return super.getCost();
    }

    @Override
    public String toString() {
        return getClass().getName() + ";" + this.getProductName() + ";" + this.getPriceInEuro() + ";" + this.getNumberOfPurchasedUnits() + ';' + controlNumberOfUnits + ";" + discount + ";" + this.getCost();
    }
}