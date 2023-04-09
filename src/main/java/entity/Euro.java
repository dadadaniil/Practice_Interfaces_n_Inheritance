package entity;

import java.util.Objects;

public class Euro implements Comparable<Euro> {
    private int cents;

    public Euro(int cents) {
        this.cents = Math.max(cents, 0);
    }

    public Euro() {
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = Math.max(cents, 0);
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

    public void substraction(int sumToSubstract) {
        this.cents = Math.max(0, this.cents - Math.max(0, sumToSubstract));
    }

    public void addition(int sumToAdd) {
        this.cents = this.cents + Math.max(0, sumToAdd);
    }

    public void zeroing() {
        this.cents = 0;
    }
}