package entity;

import java.util.Scanner;

public class DiscountPerUnitPurchase extends Purchase {
    private int discount;

    public DiscountPerUnitPurchase() {
    }

    public DiscountPerUnitPurchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits, int discount) {
        super(productName, priceInEuro, numberOfPurchasedUnits);
        this.discount = discount;
    }

    public DiscountPerUnitPurchase(Scanner sc) {
        setProductName(sc.next());
        setPriceInEuro(new Euro(sc.nextInt()));
        setNumberOfPurchasedUnits(sc.nextInt());
        discount = sc.nextInt();
    }

    @Override
    public Euro getCost() {
        return new Euro((getPriceInEuro().getCents() - discount) * getNumberOfPurchasedUnits());
    }

    @Override
    public String toString() {
        return getClass().getName() + ";" + this.getProductName() + ";" + this.getPriceInEuro() + ";" + this.getNumberOfPurchasedUnits() + ';' + discount + ";" + this.getCost();
    }
}