package lesson9.orderStrategy;

public class Card implements Payment {

    @Override
    public void payment() {
        System.out.println("Оплата картой");
    }
}
