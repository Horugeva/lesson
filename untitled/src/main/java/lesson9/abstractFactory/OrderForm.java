package lesson9.abstractFactory;

public class OrderForm {
    private final TakeOrder takeOrder;
    private final PrepareOrder prepareOrder;
    private final DeliverOrder deliverOrder;

    public OrderForm(AbstractFactory factory) {
        System.out.println("Creating order form");
        takeOrder = factory.creatTakeOrder();
        prepareOrder = factory.creatPrepareOrder();
        deliverOrder = factory.creatDeliverOrder();
    }
}
