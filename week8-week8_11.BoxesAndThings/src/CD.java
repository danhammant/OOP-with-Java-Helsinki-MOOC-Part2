/**
 * Created by Dan on 08/05/2017.
 */
public class CD implements ToBeStored{
    private String artist;
    private String title;
    private int publishingYear;
    private final double weight = 0.1;

    public CD(String artist, String title, int publishingYear) {
        this.artist = artist;
        this.title = title;
        this.publishingYear = publishingYear;
    }

    public double weight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.artist + ": " + this.title + " (" + this.publishingYear + ")";
    }
}
