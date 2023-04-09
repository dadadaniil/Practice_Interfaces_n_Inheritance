package entity;

import java.util.Scanner;

public class DiscountPerUnitPurchase extends Purchase {
    private Euro discount;

    public DiscountPerUnitPurchase() {
    }

    public DiscountPerUnitPurchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits, int discount) {
        super(productName, priceInEuro, numberOfPurchasedUnits);
        this.discount = new Euro(discount);
    }

    public DiscountPerUnitPurchase(Scanner sc) {
        super(sc);
        discount = new Euro(sc.nextInt());
    }

    @Override
    public Euro getCost() {
        return getPriceInEuro().subtraction(discount).multiplication(getNumberOfPurchasedUnits());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ";" + this.getProductName() + ";" + this.getPriceInEuro() + ";" + this.getNumberOfPurchasedUnits() + ';' + discount + ";" + this.getCost();
    }
}