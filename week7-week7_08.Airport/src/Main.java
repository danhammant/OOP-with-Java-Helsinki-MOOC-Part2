import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        Airplane planes = new Airplane();
        Flight flights = new Flight();
        Scanner reader = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(reader, planes, flights);

        ui.start();
    }
}
