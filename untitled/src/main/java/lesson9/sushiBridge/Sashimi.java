package lesson9.sushiBridge;

public class Sashimi extends Sushi {
    public Sashimi(Payment payment) {
        super(payment);
    }

    @Override
    public void payment() {
        System.out.println("Sashimi payment");
        payment.sushiPayment();
    }
}
