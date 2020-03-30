package lesson9.sushiBridge;

public class Maki extends Sushi {
    public Maki(Payment payment) {
        super(payment);
    }

    @Override
    public void payment() {
        System.out.println("Maki payment");
        payment.sushiPayment();
    }
}
