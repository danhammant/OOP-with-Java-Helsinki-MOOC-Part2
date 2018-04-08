import java.util.ArrayList;

public class Container {
    private int weightLimit;
    private int totalWeight;
    private ArrayList<Suitcase> suitcases;

    public Container(int weightLimit) {
        this.weightLimit = weightLimit;
        this.totalWeight = 0;
        this.suitcases = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase) {
        if ((this.totalWeight + suitcase.totalWeight()) <= this.weightLimit) {
            this.suitcases.add(suitcase);
            this.totalWeight += suitcase.totalWeight();
        }
    }

    public String toString() {
        return this.suitcases.size() + " suitcases (" + this.totalWeight + " kg)";
    }

    public void printThings() {
        for (Suitcase suitcase : this.suitcases) {
            suitcase.printThings();
        }
    }
}
