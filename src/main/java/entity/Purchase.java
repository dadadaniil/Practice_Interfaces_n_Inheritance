package entity;

import java.util.Objects;
import java.util.Scanner;

public class Purchase {
    private String productName;
    private Euro priceInEuro;
    private int numberOfPurchasedUnits;

    public Purchase() {
        this.priceInEuro = new Euro();
    }

    public Purchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits) {
        this.productName = productName;
        this.priceInEuro = priceInEuro;
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public Purchase(Scanner scanner) {
        this.productName = scanner.next();
        this.priceInEuro = new Euro(scanner.nextInt());
        this.numberOfPurchasedUnits = scanner.nextInt();
    }

    public String getProductName() {
        return productName;
    }

    public Euro getPriceInEuro() {
        return priceInEuro;
    }


    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }

    public void setNumberOfPurchasedUnits(int numberOfPurchasedUnits) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public void setPriceInEuro(Euro priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Euro getCost() {
        priceInEuro.multiplication(numberOfPurchasedUnits);
        return new Euro(priceInEuro);
    }
    protected String fieldsToString() {
        return  getClass().getSimpleName() + ";" + productName + ";" + priceInEuro + ";" + numberOfPurchasedUnits;
    }

    @Override
    public String toString() {
        return fieldsToString() + ';' + this.getCost();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!(this instanceof Object))return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(productName, purchase.productName) && Objects.equals(priceInEuro, purchase.priceInEuro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, priceInEuro);
    }
}