package entity;

import java.util.Objects;

public class Euro implements Comparable<Euro> {
    private int cents;

    public Euro(int cents) {
        this.cents = cents;
    }

    public Euro() {
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }


    public String centsToEuros() {
        return String.format("%d.%02d", this.cents / 100, this.cents % 100);
    }

    public int compareTo(Euro euros) {
        return this.cents - euros.getCents();
    }

    @Override
    public String toString() {
        return centsToEuros();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Euro euro = (Euro) o;
        return cents == euro.cents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cents);
    }

    public Euro subtraction(Euro sumToSubtract) {
        return new Euro(cents - sumToSubtract.getCents());
    }

    public Euro addition(Euro sumToAdd) {
        return new Euro(cents + sumToAdd.getCents());
    }

    public Euro multiplication(int sumToMultiply) {
        return new Euro(cents * sumToMultiply);
    }

    public Euro division(int sumToDivide) {
        return new Euro(cents / sumToDivide);
    }

    public void zeroing() {
        this.cents = 0;
    }
}