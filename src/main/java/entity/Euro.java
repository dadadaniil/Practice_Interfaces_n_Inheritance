package entity;

public class Euro {
    private int cents;

    public Euro(int cents) {
        this.cents = Math.max(cents,0);
    }

    public Euro() {
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = Math.max(cents,0);
    }


    public String centsToEuros() {
        return String.format("%d.%02d", this.cents / 100, this.cents % 100);
    }



    public boolean equals(Euro euros) {
            return this.cents == euros.getCents();
    }

    public int compareTo(Euro euros) {
        return this.cents - euros.getCents();
    }

    @Override
    public String toString() {
        return centsToEuros();
    }
}
