package lesson9.abstractFactory;

public class BurgerAbstractFactory implements AbstractFactory {
    public BurgerAbstractFactory() {
        System.out.println("Creating gui factory for Burger");
    }

    @Override
    public TakeOrder creatTakeOrder() {
        System.out.println("Creating TakeOrder for Burger");
        return new BurgerTake();
    }

    @Override
    public PrepareOrder creatPrepareOrder() {
        System.out.println("Creating PrepareOrder for Burger");
        return new BurgerPrepare();
    }

    @Override
    public DeliverOrder creatDeliverOrder() {
        System.out.println("Creating DeliverOrder for Burger");
        return new BurgerDelivery();
    }
}
