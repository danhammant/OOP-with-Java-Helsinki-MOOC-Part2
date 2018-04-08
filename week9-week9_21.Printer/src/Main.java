
public class Main {

    public static void main(String[] args) throws Exception {
        Printer printer = new Printer("src/koe.txt");

        printer.printLinesWhichContain("word");
        printer.printLinesWhichContain("koe");
        System.out.println("-----");
        printer.printLinesWhichContain("");
        System.out.println("-----");
    }
}
