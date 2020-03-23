package lesson7;

class StackOverflow {
    public static void infiniteRecursion() {
        infiniteRecursion();
    }

    public static void main(String[] args) {
        infiniteRecursion();
    }
}