package lesson9.sushiBridge;

public abstract class Sushi {
    protected Payment payment;

    public Sushi(Payment payment) {
        this.payment = payment;
    }

    public abstract void payment();
}
