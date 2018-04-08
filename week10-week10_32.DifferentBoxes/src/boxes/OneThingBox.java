package boxes;

import java.util.ArrayList;
import java.util.List;

public class OneThingBox extends Box {
    private List<Thing> oneThing;

    public OneThingBox() {
        this.oneThing = new ArrayList<>();
    }

    @Override
    public void add(Thing thing) {
        if (this.oneThing.size() < 1) {
            this.oneThing.add(thing);
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return this.oneThing.contains(thing);
    }
}
