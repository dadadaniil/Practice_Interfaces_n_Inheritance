package entity;

public class Euro {
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


    public String centsToEuros(int cents) {
        return String.format("%d.%02d", cents / 100, cents % 100);
    }

    public boolean equals(Euro euros) {
            return this.cents == euros.getCents();
    }

    public int compareTo(Euro euros) {
        return this.cents - euros.getCents();
    }

    @Override
    public String toString() {
        return centsToEuros(cents);
    }
}
