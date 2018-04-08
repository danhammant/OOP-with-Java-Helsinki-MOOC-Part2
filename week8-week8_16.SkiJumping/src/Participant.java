import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Participant implements Comparable<Participant> {
    private String name;
    private int points;
    private List<Jump> jumps;
    private int jumpCounter;

    public Participant(String name) {
        this.name = name;
        this.points = 0;
        this.jumps = new ArrayList<>();
        this.jumpCounter = 0;
    }

    public void newJump() {
        this.jumps.add(new Jump());
        this.jumpCounter++;

    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getVotes(int index) {
        return this.jumps.get(index).getJumpVotes();
    }

    public int getLength(int index) {
        return this.jumps.get(index).getLength();
    }

    public int getPoints() {
        return this.points;
    }

    public void addPoints() {
        this.points = 0;
        int tempPoints = 0;

        for (Jump jump : this.jumps) {
            tempPoints += jump.getPoints();
        }

        this.points = tempPoints;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.points + " points)";
    }

    @Override
    public int compareTo(Participant participant) {
        if (this.points - participant.getPoints() == 0) {
            return 0;
        } else if (this.points > participant.getPoints()) {
            return 1;
        } else {
            return -1;
        }
    }








}
