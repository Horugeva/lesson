package lesson9.sushiBarDecorator;

public class DoubleExtra extends Extra {
    public DoubleExtra(String label, double price, Order order) {
        super(label, price, order);
    }

    @Override
    public double getPrice() {
        return (this.price * 2) + order.getPrice();
    }

    public String getLabei() {
        return order.getLabel() + ", Double " + this.label;
    }
}
