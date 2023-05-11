import entity.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        //1.
        final int PURCHASES_NUMBER = 6;
        Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
        Purchase purchaseWithMaxCost = new Purchase();
        boolean allPurchasesAreEquals = true;
        Scanner scanner;
        String path = "src/in.txt";
        try {
            scanner = new Scanner(new FileReader(path));
            scanner.useLocale(Locale.ENGLISH);

            for (int i = 0; i < purchases.length; i++) {
                //2.
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(scanner);
                //3.
                System.out.println(purchases[i]);
                //4.
                if (purchases[i].getCost().getCents() > purchaseWithMaxCost.getCost().getCents()) {
                    purchaseWithMaxCost = purchases[i];
                }
                //5.
                if (allPurchasesAreEquals) {
                    allPurchasesAreEquals = purchases[i].equals(purchases[0]);
                }

            }
            System.out.println();
            System.out.println("The purchase with the most cost is " + purchaseWithMaxCost);
            System.out.println();

            if (allPurchasesAreEquals) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("Purchases aren't equal");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        }
    }
}