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
}
