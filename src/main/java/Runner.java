import entity.Purchase;
import entity.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        //1.
        Purchase[] purchases = new Purchase[6];
        Purchase purchaseWithMaxCost = new Purchase();
        boolean allPurchasesAreEquals = true;
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader("src/in.txt"));

            for (int i = 0; i < purchases.length - 1; i++) {
                //2.
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(scanner);
                //3.
                System.out.println(purchases[i]);
                //4.
                if (purchases[i].getCost().getCents() > purchaseWithMaxCost.getCost().getCents()) {
                    purchaseWithMaxCost = purchases[i];
                }
                //5.
                if (!purchases[i].equals(purchases[0])) {
                    allPurchasesAreEquals = false;
                }

            }
            System.out.println();
            System.out.println("The purchase with the most cost is " + purchaseWithMaxCost.toString());
            System.out.println();

            if (allPurchasesAreEquals) {
                System.out.println("All purchases are equal");
            } else {
                System.out.println("Purchases aren't equal");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
