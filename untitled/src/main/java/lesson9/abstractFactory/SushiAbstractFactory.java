package lesson9.abstractFactory;

public class SushiAbstractFactory implements AbstractFactory {
    public SushiAbstractFactory() {
        System.out.println("Creating gui factory for Sushi");
    }

    @Override
    public TakeOrder creatTakeOrder() {
        System.out.println("Creating TakeOrder for Sushi");
        return new SushiTake();
    }

    @Override
    public PrepareOrder creatPrepareOrder() {
        System.out.println("Creating PrepareOrder for Sushi");
        return new SushiPrepate();
    }

    @Override
    public DeliverOrder creatDeliverOrder() {
        System.out.println("Creating DeliverOrder for Sushi");
        return new SushiDelivery();
    }
}
