package lesson9.sushiBridge;

public class Main {
    public static void main(String[] args) {
        Sushi sashimi = new Sashimi(new Card());
        sashimi.payment();
        System.out.println();
        Sushi maki = new Maki(new Cash());
        maki.payment();
        System.out.println();
        Sushi nigiri = new Nigiri(new Online());
        nigiri.payment();
    }
}
