package entity;

import java.util.Scanner;

public class PurchasesFactory {
    private enum PurchaseKind {
        GENERAL_PURCHASE, PURCHASE_WITH_DISCOUNT, PURCHASE_WITH_PROPORTIONAL_DISCOUNT
    }

    public static Purchase getPurchaseFromFactory(Scanner sc) {
        String id = sc.next();
        PurchaseKind kind = PurchaseKind.valueOf(id);
        return switch (kind) {
            case GENERAL_PURCHASE -> new Purchase(sc);
            case PURCHASE_WITH_DISCOUNT -> new DiscountPerUnitPurchase(sc);
            case PURCHASE_WITH_PROPORTIONAL_DISCOUNT -> new ProportionalDiscountPurchase(sc);
        };
    }
}