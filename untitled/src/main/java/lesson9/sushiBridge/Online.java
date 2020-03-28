package lesson9.sushiBridge;

public class Online implements Payment {
    @Override
    public void sushiPayment() {
        System.out.println("Payment Online");
    }
}
