package lesson9.orderStrategy;

public class Order {
    Payment payment;

    public void paymentOrder() {
        payment.payment();
    }

    public void takeOrders() {
        System.out.println("Принимаем заказ");
    }

    public void prepare() {
        System.out.println("Собираем");
    }
}
