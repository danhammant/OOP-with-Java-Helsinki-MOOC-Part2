import java.util.ArrayList;

public class Suitcase {
    private int weightLimit;
    private ArrayList<Thing> things;
    private int totalWeight;

    public Suitcase(int weightLimit) {
        this.weightLimit = weightLimit;
        this.things = new ArrayList<Thing>();
        this.totalWeight = 0;
    }

    public void addThing(Thing thing) {
        if ((this.totalWeight + thing.getWeight()) <= this.weightLimit) {
            this.things.add(thing);
            this.totalWeight += thing.getWeight();
        }
    }

    public String toString() {
        if (this.things.isEmpty()) {
            return "empty (0 kg)";
        }

        if (this.things.size() == 1) {
            return this.things.size() + " thing (" + this.totalWeight + " kg)";
        }

        return this.things.size() + " things (" + this.totalWeight + " kg)";
    }

    public void printThings() {
        for (Thing thing : this.things) {
            System.out.println(thing);
        }
    }

    public int totalWeight() {
        return this.totalWeight;
    }

    public Thing heaviestThing() {
        if (this.things.isEmpty()) {
            return null;
        }

        Thing heaviestThing = this.things.get(0);
        for (Thing thing : this.things) {
            if (thing.getWeight() > heaviestThing.getWeight()) {
                heaviestThing = thing;
            }
        }

        return heaviestThing;
    }
}
