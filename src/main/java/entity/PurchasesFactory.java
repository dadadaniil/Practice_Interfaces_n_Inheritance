package entity;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE {
            @Override
            Purchase getPurchase(Scanner sc) {
                return new Purchase(sc);
            }
        },
        PURCHASE_WITH_DISCOUNT{
            @Override
            Purchase getPurchase(Scanner sc) {
                return new DiscountPerUnitPurchase(sc);
            }
        },
        PURCHASE_WITH_PROPORTIONAL_DISCOUNT{
            @Override
            Purchase getPurchase(Scanner sc) {
                return new ProportionalDiscountPurchase(sc);
            }
        };
        abstract Purchase getPurchase(Scanner sc);
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        return kind.getPurchase(sc);
    }
}