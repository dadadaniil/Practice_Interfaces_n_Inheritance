package entity;

public enum RoundMethod {

    FLOOR {
        double roundFunction(double d) {
            return Math.floor(d);
        }
    },
    ROUND {
        double roundFunction(double d) {
            return Math.round(d);
        }
    },
    CEIL {
        double roundFunction(double d) {
            return Math.ceil(d);
        }
    };

    abstract double roundFunction(double value);

    public int round(double roundedValue, RoundMethod roundMethod, int d) {
        int tenPow = pow10(d);
        return (int) roundMethod.roundFunction(roundedValue / tenPow) * tenPow;
    }

    private static int pow10(int d) {
        return switch (d) {
            case 0 -> 1;
            case 1 -> 10;
            case 2 -> 100;
            case 3 -> 1000;
            case 4 -> 10000;
            case 5 -> 100000;
            case 6 -> 1000000;
            case 7 -> 10000000;
            case 8 -> 100000000;
            default -> 0;
        };
    }
}