package dictionary;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    private Map<String, Set<String>> dictionaryWords;

    public PersonalMultipleEntryDictionary() {
        this.dictionaryWords = new HashMap<>();
    }

    @Override
    public void add(String word, String entry) {
        if (!this.dictionaryWords.containsKey(word)) {
            this.dictionaryWords.put(word, new HashSet<>());
        }

        this.dictionaryWords.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        if (!this.dictionaryWords.containsKey(word)) {
            return null;
        }

        return this.dictionaryWords.get(word);
    }

    @Override
    public void remove(String word) {
        this.dictionaryWords.remove(word);
    }
}
