import java.util.Scanner;
public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statements: ");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user interface");
        System.out.println();

        while (true) {
            String statement = statement();
            if (statement.equals("quit")) {
                System.out.println("Cheers!");
                break;
            } else if (statement.equals("add")) {
                add();
            } else if (statement.equals("translate")) {
                translation();
            } else {
                System.out.println("Unknown statement");
                System.out.println();
            }
        }
    }

    private String statement() {
        System.out.print("Statement: ");
        return reader.nextLine();
    }

    private void add() {
        System.out.print("In Finnish: ");
        String finnish = this.reader.nextLine();
        System.out.print("Translation: ");
        String translation = this.reader.nextLine();
        this.dictionary.add(finnish, translation);
        System.out.println();
    }

    private void translation() {
        System.out.print("Give a word: ");
        String word = this.reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(word));
        System.out.println();
    }
}
