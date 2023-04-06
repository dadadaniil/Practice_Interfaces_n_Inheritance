package entity;

import java.util.Locale;
import java.util.Scanner;

public class Purchase {
    private String productName;
    private Euro priceInEuro;
    private int numberOfPurchasedUnits;

    public Purchase() {
    }

    public Purchase(String productName, Euro priceInEuro, int numberOfPurchasedUnits) {
        this.productName = productName;
        this.priceInEuro = priceInEuro;
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public Purchase(Scanner scanner) {
        scanner.useLocale(Locale.ENGLISH);

        var line = scanner.nextLine();

        var values = line.split("\\s+");

//        this.productName = Integer.parseString(values[0]);
        var discountPercent = Integer.parseInt(values[1]);
        var weekDay = Integer.parseInt(values[2]);
    }
}
