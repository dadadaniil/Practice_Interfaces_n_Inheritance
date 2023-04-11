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
        return new Euro((getPriceInEuro().getCents() - discount.getCents()) * getNumberOfPurchasedUnits());
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}