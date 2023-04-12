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

        double otherPartOfDiscount = discount/100;
        int doNeedToApplyDiscount;
        int startPrice = getPriceInEuro().getCents() * getNumberOfPurchasedUnits();
        int amountOfProductsRemainingAfterSubtracting = Math.min(CONTROL_NUMBER_OF_UNITS-1 - getNumberOfPurchasedUnits(),0);
        try {
            doNeedToApplyDiscount = amountOfProductsRemainingAfterSubtracting / amountOfProductsRemainingAfterSubtracting;
        } catch (ArithmeticException arithmeticException) {
            doNeedToApplyDiscount = 0;
        }
        double discountInValue = doNeedToApplyDiscount * startPrice * otherPartOfDiscount;
        double resultPrice = startPrice - discountInValue;

        return new Euro((int) resultPrice);

    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }
}