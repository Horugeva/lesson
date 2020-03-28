package lesson9.orderStrategy;

public class Strategy {
    public void hadle(String name) {
        Order order;
        if (name.equals("shop")) {
            order = new InShopSale();
            order.takeOrders();
            order.prepare();
            order.paymentOrder();
        } else if (name.equals("onLine")) {
            order = new OnLineOrder();
            order.takeOrders();
            order.prepare();
            order.paymentOrder();
        } else if (name.equals("mail")) {
            order = new MailOrder();
            order.takeOrders();
            order.prepare();
            order.paymentOrder();
        } else System.out.println("Неизвестная форма заказа");
    }
}
