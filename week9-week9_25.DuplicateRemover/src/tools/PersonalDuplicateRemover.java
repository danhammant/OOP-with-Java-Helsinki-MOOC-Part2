package tools;

import java.util.HashSet;
import java.util.Set;


public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> characterStrings;
    private int numberOfDetectedDuplicates;

    public PersonalDuplicateRemover() {
        this.characterStrings = new HashSet<>();
        this.numberOfDetectedDuplicates = 0;
    }

    @Override
    public void add(String characterString) {
        if (!this.characterStrings.contains(characterString)) {
            this.characterStrings.add(characterString);
        } else {
            this.numberOfDetectedDuplicates++;
        }

    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.numberOfDetectedDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.characterStrings;
    }

    @Override
    public void empty() {
        this.characterStrings.clear();
        this.numberOfDetectedDuplicates = 0;
    }
}
