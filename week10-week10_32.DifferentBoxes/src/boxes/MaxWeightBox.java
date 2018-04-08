package boxes;

import java.util.ArrayList;
import java.util.List;

public class MaxWeightBox extends Box {
    private int maxWeight;
    private List<Thing> things;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();
    }

    @Override
    public void add(Thing thing) {
        int currentWeight = 0;
        for (Thing thingWeight : this.things) {
            currentWeight += thingWeight.getWeight();
        }

        if (currentWeight + thing.getWeight() <= this.maxWeight) {
            this.things.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.things.contains(thing);
    }

    public void printAll() {
        for (Thing thing : this.things) {
            System.out.println(thing.getName());
        }
    }
}
