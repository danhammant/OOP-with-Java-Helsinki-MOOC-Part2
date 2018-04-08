import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Jump {
    private int points;
    private int length;
    private List<Integer> jump;
    private Random randomiser;

    public Jump() {
        this.jump = new ArrayList<>();
        this.randomiser = new Random();
        this.points = 0;
        this.length = this.randomiser.nextInt(120-60) + 60;
        newJumpVotes();
        setPoints();
    }


    public int getLength() {
        return this.length;
    }

    public List<Integer> getJumpVotes() {
        return this.jump;
    }

    public int getPoints() {
        return this.points;
    }


    private void setPoints() {
        Collections.sort(this.jump);

        int tempPoints = 0;
        for (int i = 1; i < 4; i++) {
            tempPoints += this.jump.get(i);
        }

        this.points += tempPoints;
        this.points += this.length;

    }

    private void newJumpVotes() {
        for (int i = 0; i < 5; i++) {
            this.jump.add(this.randomiser.nextInt(20-10) + 10);
        }
    }

}
