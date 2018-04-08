
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
       printWithSmileys("Interface");

    }

    private static void printWithSmileys(String characterString) {
        String middle = null;

        if (characterString.length() % 2 == 0) {
            middle = ":) " + characterString + " :)";
        } else {
            middle = ":) " + characterString + "  :)";
        }

        smileyRow(middle.length());
        System.out.println(middle);
        smileyRow(middle.length());
    }

    private static void smileyRow(int wordLength) {
        for (int i = 0; i < wordLength / 2; i++) {
            System.out.print(":)");
        }

        System.out.println();
    }

}
