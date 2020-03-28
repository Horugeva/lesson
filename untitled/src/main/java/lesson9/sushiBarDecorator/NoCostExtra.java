package lesson9.sushiBarDecorator;

public class NoCostExtra extends Extra {
    public NoCostExtra(String label, double price, Order order) {
        super(label, price, order);
    }

    @Override
    public double getPrice() {
        return order.getPrice();
    }
}
