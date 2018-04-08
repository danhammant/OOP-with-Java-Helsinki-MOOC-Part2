package moving.logic;

import moving.domain.Box;
import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> packThings = new ArrayList<>();
        packThings.add(new Box(boxesVolume));

        int i = 0;
        for (Thing item : things) {
            if (!packThings.get(i).addThing(item)) {
                packThings.add(new Box(boxesVolume));
                i++;

                packThings.get(i).addThing(item);
            }
        }

        return packThings;
    }


}
