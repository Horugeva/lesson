package lesson9.abstractFactory;

public interface AbstractFactory {
    TakeOrder creatTakeOrder();

    PrepareOrder creatPrepareOrder();

    DeliverOrder creatDeliverOrder();
}
