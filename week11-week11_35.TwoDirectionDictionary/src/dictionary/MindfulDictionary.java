package dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MindfulDictionary {
    private Map<String, String> wordTranslation;
    private Map<String, String> translationWord;
    private String fileName;
    private File file;

    public MindfulDictionary() {
        this(null);
    }

    public MindfulDictionary(String file) {
        this.wordTranslation = new HashMap<>();
        this.translationWord = new HashMap<>();
        this.fileName = file;
    }

    public void add(String word, String translation) {
        if (!this.wordTranslation.containsKey(word)) {
            this.wordTranslation.put(word, translation);
            this.translationWord.put(translation, word);
        }
    }

    public String translate(String word) {
        if (this.wordTranslation.containsKey(word)) {
            return this.wordTranslation.get(word);
        } else if (this.wordTranslation.containsValue(word)) {
            return this.translationWord.get(word);
        }

        return null;
    }

    public void remove(String word) throws Exception{
        if (!this.wordTranslation.containsKey(word) && !this.translationWord.containsKey(word)) {
            throw new IllegalArgumentException("Word not found");
        }

        if (this.wordTranslation.containsKey(word)) {
            String toBeRemoved = this.wordTranslation.get(word);

            this.wordTranslation.remove(word);
            this.translationWord.remove(toBeRemoved);
        } else {
            String toBeRemoved = this.translationWord.get(word);

            this.translationWord.remove(word);
            this.wordTranslation.remove(toBeRemoved);
        }

    }

    public boolean load() {
        this.file = new File(this.fileName);
        Scanner reader;

        try {
            reader = new Scanner(this.file);

            while (reader.hasNextLine() ) {
                String line = reader.nextLine();
                String[] parts = line.split(":");

                add(parts[0], parts[1]);
            }

            return true;
        } catch (Exception e) {
            System.out.println("File could not be read. Error: " + e.getMessage());
            return false;
        }
    }

    public boolean save(){
        if (this.file == null) {
            this.file = new File(this.fileName);
        }

        FileWriter writer;

        try {
            writer = new FileWriter(this.file);

            for (String key : this.wordTranslation.keySet()) {
                writer.write(key + ":" + this.wordTranslation.get(key) + "\n");
            }

            writer.close();
            return true;

        } catch (IOException io) {
            return false;
        }




    }

}
