package entity;

import java.util.Scanner;

public class ProportionalDiscountPurchase extends Purchase {
    private final static int CONTROL_NUMBER_OF_UNITS = 10;
    private double discount;

    public ProportionalDiscountPurchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits, int controlNumberOfUnits, double discount) {
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
//        if (getNumberOfPurchasedUnits() > CONTROL_NUMBER_OF_UNITS) {
//            getPriceInEuro().multiplication(getNumberOfPurchasedUnits());
//            getPriceInEuro().multiplication((int) Math.ceil((100 - discount) / 100));
//            return getPriceInEuro();
//        }
//        return super.getCost();
//        Awesome code Алёны



//        My code говна:
//        I will explain the meaning of this code in Russian to make it easier for everyone:
//        Смысл в том, что от начальной суммы отнимается сумма скидки, умноженная на ноль или единицу в зависимости от того,
//        больше ли нуля число покупок или нет

//        Of course it is possible to eliminate all this variables and fit all code in fore lines, but it will lead to
//        decreased readability and it's irrational to punish us for amount of variables.
        double otherPartOfDiscount = 1 - Math.ceil(((100 - discount)) / 100);
        int doNeedToApplyDiscount;
        int startPrice = getPriceInEuro().getCents() * getNumberOfPurchasedUnits();
        int amountOfProductsRemainingAfterSubstracting = 10 - getNumberOfPurchasedUnits();
        try {
            doNeedToApplyDiscount = amountOfProductsRemainingAfterSubstracting / amountOfProductsRemainingAfterSubstracting;
        } catch (ArithmeticException arithmeticException) {
            doNeedToApplyDiscount = 0;
        }
        double discountInValue = Math.max(1, doNeedToApplyDiscount) * startPrice * otherPartOfDiscount;
        double resultPrice = startPrice - discountInValue;

        return new Euro((int) resultPrice);

    }

    @Override
    public String toString() {
        return fieldsToString() + ";" + discount + ";" + this.getCost();
    }
}