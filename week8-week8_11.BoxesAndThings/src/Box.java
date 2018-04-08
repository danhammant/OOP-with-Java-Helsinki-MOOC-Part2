import java.util.ArrayList;

public class Box implements ToBeStored {
    private double maxWeight;
    private ArrayList<ToBeStored> things;

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();
    }

    public void add(ToBeStored toBeStored) {
        if ((weight() + toBeStored.weight()) <= this.maxWeight) {
            this.things.add(toBeStored);
        }
    }

    public double weight() {
        double weight = 0;

        for (ToBeStored thing : this.things) {
            weight += thing.weight();
        }

        return weight;
    }

    @Override
    public String toString() {
       return "Box: " + this.things.size() + " things, total weight " + weight() + " kg";
    }




}
