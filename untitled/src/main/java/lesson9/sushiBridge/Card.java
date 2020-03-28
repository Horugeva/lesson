package lesson9.sushiBridge;

public class Card implements Payment {
    @Override
    public void sushiPayment() {
        System.out.println("Payment card");
    }
}
