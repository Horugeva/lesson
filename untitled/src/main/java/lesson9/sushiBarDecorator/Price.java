package lesson9.sushiBarDecorator;

public class Price {
    public static void main(String[] args) {
        Order sashimi = new Sushi("California", 10);
        sashimi = new RegularExtra("Ric", 4, sashimi);
        sashimi = new NoCostExtra("Fish", 0, sashimi);
        sashimi = new DoubleExtra("Sous", 5, sashimi);
        System.out.println(sashimi.getLabel());
        System.out.println(sashimi.getPrice());
    }
}