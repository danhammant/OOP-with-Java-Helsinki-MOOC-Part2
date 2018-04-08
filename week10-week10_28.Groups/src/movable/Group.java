package movable;

import java.util.ArrayList;
import java.util.List;

public class Group implements Movable {
    private List<Movable> movableList;

    public Group() {
        this.movableList = new ArrayList<>();
    }

    public void addToGroup(Movable movable) {
        this.movableList.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (int i = 0; i < this.movableList.size(); i++) {
            this.movableList.get(i).move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String groupPositions = "";

        for (int i = 0; i < this.movableList.size(); i++) {
            groupPositions += this.movableList.get(i).toString() + "\n";
        }

        return groupPositions;
    }
}
