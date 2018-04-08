package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {
    private File file;

    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws Exception {
        Scanner reader = new Scanner(this.file);

        int numberOfLines = 0;
        while(reader.hasNextLine()) {
            numberOfLines++;
            reader.nextLine();
        }

        return numberOfLines;
    }

    public int characters() throws Exception{
        Scanner reader = new Scanner(this.file);

        int numberOfCharacters = 0;
        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            numberOfCharacters += line.length() + 1;
        }

        return numberOfCharacters;
    }
}
