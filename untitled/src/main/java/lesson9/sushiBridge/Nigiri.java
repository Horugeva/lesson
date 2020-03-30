package lesson9.sushiBridge;

public class Nigiri extends Sushi {
    public Nigiri(Payment payment) {
        super(payment);
    }

    @Override
    public void payment() {
        System.out.println("Nigiri payment");
        payment.sushiPayment();
    }
}
