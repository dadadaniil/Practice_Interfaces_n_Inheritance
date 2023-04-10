package entity;

import java.util.Objects;

public class Euro implements Comparable<Euro> {
    private int cents;

    public Euro(int cents) {
        this.cents = cents;
    }

    public Euro() {
    }
    public Euro(int euros, int cents){
        this(euros * 100 + cents);
    }
    public Euro(Euro euro){
        this(euro.getCents());
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

    public void subtraction(Euro sumToSubtract) {
        setCents(cents - sumToSubtract.getCents());
    }

    public void addition(Euro sumToAdd) {
        setCents(cents + sumToAdd.getCents());
    }

    public void multiplication(int sumToMultiply) {
        setCents(cents * sumToMultiply);
    }

    public void division(int sumToDivide) {
        setCents(cents / sumToDivide);
    }

    public void zeroing() {
        this.cents = 0;
    }
    public int getRubs(){
        return cents / 100;
    }
    public int getCoins(){
        return cents % 100;
    }
    public Euro mul(double k, RoundMethod roundMethod, int d){
        cents = RoundMethod.round(cents * k, roundMethod, d);
        return this;
    }
    public Euro round(RoundMethod roundMethod, int d){
        cents = RoundMethod.round(cents, roundMethod, d);
        return this;
    }
}