
import java.io.File;
import java.util.Scanner;

public class Printer {
    private File file;

    public Printer(String fileName) throws Exception {
        this.file = new File(fileName);
    }

    public void printLinesWhichContain(String word) throws Exception{
        Scanner reader = new Scanner(this.file);

        if (word.isEmpty()) {
            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }

        } else {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (line.contains(word)) {
                    System.out.println(line);
                }
            }

        }

    }

}
