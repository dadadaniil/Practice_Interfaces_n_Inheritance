package entity;

import java.util.Scanner;

public class ProportionalDiscountPurchase extends Purchase {
    private final int CONTROL_NUMBER_OF_UNITS;
    private double discount;

    public ProportionalDiscountPurchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits, int controlNumberOfUnits, double discount) {
        super(productName, priceInEuro, numberOfPurchasedUnits);
        this.CONTROL_NUMBER_OF_UNITS = controlNumberOfUnits;
        this.discount = discount;
    }
    public ProportionalDiscountPurchase() {
        CONTROL_NUMBER_OF_UNITS = 0;
    }

    public ProportionalDiscountPurchase(Scanner sc) {
        super(sc);
        CONTROL_NUMBER_OF_UNITS = sc.nextInt();
        discount = sc.nextDouble();
    }

    @Override
    public Euro getCost() {
        if (getNumberOfPurchasedUnits() > CONTROL_NUMBER_OF_UNITS) {
            return getPriceInEuro().multiplication(getNumberOfPurchasedUnits()).multiplication((int) Math.ceil((100 - discount) / 100));
        }
        return super.getCost();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ";" + this.getProductName() + ";" + this.getPriceInEuro() + ";" + this.getNumberOfPurchasedUnits() + ';' + CONTROL_NUMBER_OF_UNITS + ";" + discount + ";" + this.getCost();
    }
}