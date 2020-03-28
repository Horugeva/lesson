package lesson9.sushiBarDecorator;

public class Sushi implements Order {
    private String label;
    private double price;

    public Sushi(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return this.label;
    }

    public double getPrice() {
        return this.price;
    }
}
