import java.util.HashMap;
import java.util.ArrayList;

public class Dictionary {
    private HashMap<String, String> words;

    public Dictionary() {
        this.words = new HashMap<String, String>();
    }

    public void add(String word, String translation) {
        this.words.put(word, translation);
    }

    public String translate(String word) {
        if (this.words.containsKey(word)) {
            return this.words.get(word);
        }

        return null;
    }

    public int amountOfWords() {
        return this.words.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translationList = new ArrayList<>();

        for (String key : this.words.keySet()) {
            String translationPair = key + " = " + this.words.get(key);
            translationList.add(translationPair);
        }

        return translationList;
    }


}
