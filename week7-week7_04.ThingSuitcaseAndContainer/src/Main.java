
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Suitcase suitcase = new Suitcase(100);
        Thing book = new Thing("Balls", 10);
        suitcase.addThing(book);
        System.out.println(suitcase);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i = 1; i <= 100; i++) {
            Thing brick = new Thing("brick", i);
            Suitcase suitcase = new Suitcase(100);
            suitcase.addThing(brick);
            container.addSuitcase(suitcase);
        }
    }

}
