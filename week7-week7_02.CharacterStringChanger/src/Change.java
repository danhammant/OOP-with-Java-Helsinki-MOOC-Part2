
public class Change {
    private char fromCharacter;
    private char toCharacter;

    public Change(char fromCharacter,char toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }

    public String change(String characterString) {
       String newWord = characterString.replace(this.fromCharacter, this.toCharacter);

       return newWord;
    }
}
