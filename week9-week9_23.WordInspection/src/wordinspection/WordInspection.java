package wordinspection;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class WordInspection {
    private File file;
    private List<String> allWords;

    public WordInspection(File file) throws Exception{
        this.file = file;
        this.allWords = new ArrayList<>();

        readFile();
    }

    public int wordCount() {
        return this.allWords.size();
    }

    public List<String> wordsContainingZ() {
        List<String> wordsContainingZ = new ArrayList<>();

        for (String word : this.allWords) {
            if (word.contains("z")) {
                wordsContainingZ.add(word);
            }
        }

        return wordsContainingZ;
    }

    public List<String> wordsEndingInL() {
        List<String> wordsEndingInL = new ArrayList<>();

        for (String word : this.allWords) {
            if(word.endsWith("l")){
                wordsEndingInL.add(word);
            }
        }

        return wordsEndingInL;
    }

    public List<String> palindromes() {
        List<String> palindromes = new ArrayList<>();

        for (String word : this.allWords) {
            if (isPalindrome(word)) {
                palindromes.add(word);
            }
        }

        return palindromes;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsWhichContainAllVowels = new ArrayList<>();

        for (String word : this.allWords) {
            if (containsAllVowels(word)) {
                wordsWhichContainAllVowels.add(word);
            }
        }

        return wordsWhichContainAllVowels;
    }

    private void readFile() throws Exception{
        Scanner reader = new Scanner(this.file);

        while(reader.hasNextLine()) {
            String word = reader.nextLine();
            this.allWords.add(word);
        }
    }

    private boolean isPalindrome(String word) {
        String reverse = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }

        if (!word.equals(reverse)) {
            return false;
        }

        return true;
    }

    private boolean containsAllVowels(String word) {
        String vowels = "aeiouyäö";

        for(int i = 0; i < vowels.length(); i++) {
            if (!word.contains(Character.toString(vowels.charAt(i)))) {
                return false;
            }
        }

        return true;
    }
}
