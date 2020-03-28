package lesson9.sushiBarDecorator;

public abstract class Extra implements Order {

    protected String label;
    protected double price;
    protected Order order;

    public Extra(String label, double price, Order order) {
        this.label = label;
        this.price = price;
        this.order = order;
    }

    public abstract double getPrice();

    public String getLabel() {
        return order.getLabel() + "," + this.label;
    }
}
