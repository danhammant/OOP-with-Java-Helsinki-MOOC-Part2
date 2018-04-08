import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Tournament {
    private List<Participant> participants;
    private int jumpCounter;

    public Tournament() {
        this.participants = new ArrayList<>();
        this.jumpCounter = 0;
    }

    public void addParticipant(String name) {
        this.participants.add(new Participant(name));
    }

    public void jump() {
        for (Participant jumper : this.participants) {
            jumper.newJump();
        }

        this.jumpCounter++;
    }

    public void sortJumpersAfterRound() {
        Collections.sort(this.participants);
    }

    public void sortJumpersAfterTournament() {
        Collections.sort(this.participants);
        Collections.reverse(this.participants);
    }


    public Participant getJumper(int index) {
        return this.participants.get(index);
    }

    public int getLength(int index) {
        return this.participants.get(index).getLength(this.jumpCounter - 1);
    }

    public String getAllLengths(int index) {
        String lengths = "";

        for (int i = 0; i < this.jumpCounter; i++) {
            if (this.jumpCounter - i == 1) {
                lengths += this.participants.get(index).getLength(i) + " m";
            } else {
                lengths += this.participants.get(index).getLength(i) + " m, ";
            }
        }

        return lengths;
    }

    public List<Integer> getVotes(int index) {
        return this.participants.get(index).getVotes(this.jumpCounter - 1);
    }

    public int getPoints(int index) {
        return this.participants.get(index).getPoints();
    }

    public String getJumperName(int index) {
        return this.participants.get(index).getName();
    }

    public void addPoints(int index) {
        this.participants.get(index).addPoints();
    }






}
