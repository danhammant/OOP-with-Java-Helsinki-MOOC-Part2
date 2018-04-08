package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing{
    private int maximumCapacity;
    private List<Thing> box;

    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.box = new ArrayList<>();
    }

    public boolean addThing(Thing thing) {
        if (this.getVolume() + thing.getVolume() > this.maximumCapacity) {
            return false;
        }

        this.box.add(thing);
        return true;
    }

    @Override
    public int getVolume() {
        int volume = 0;

        for (Thing thing : this.box) {
            volume += thing.getVolume();
        }

        return volume;
    }


}
