package lesson9.sushiBridge;

public class Cash implements Payment {
    @Override
    public void sushiPayment() {
        System.out.println("Payment cash");
    }
}
