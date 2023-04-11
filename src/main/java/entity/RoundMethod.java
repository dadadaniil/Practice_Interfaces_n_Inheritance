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
        return 10 ^ d;
    }
}