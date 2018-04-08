import java.util.Scanner;

public class UserInterface {
    private Scanner reader;
    private Tournament tournament;
    private int counter;
    private int jumperCounter;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.tournament = new Tournament();
        this.counter = 0;
        this.jumperCounter = 0;
    }

    public void start() {
        System.out.println("Kumpula ski jumping week");
        System.out.println();

        addParticipants();

        System.out.println("The tournament begins!");
        System.out.println();

        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String input = this.reader.nextLine();

            if (!input.equals("jump")) {
                break;
            } else {
                jump();
            }
        }

        System.out.println("Thanks!");
        System.out.println();

        tournamentResults();

    }

    private void addParticipants() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while(true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();

            if (name.isEmpty()) {
                break;
            }

            this.tournament.addParticipant(name);
            this.jumperCounter++;
        }

        System.out.println();
    }

    private void jump() {
        this.counter++;
        System.out.println("Round " + this.counter);

        System.out.println();
        System.out.println("Jumping order:");

        jumpingOrder();

        this.tournament.jump();

        System.out.println("Results of round " + this.counter);
        results();

        addPoints();
        this.tournament.sortJumpersAfterRound();


    }

    private void jumpingOrder() {
        for (int i = 1; i <= this.jumperCounter; i++) {
            System.out.println("  " + i + ". " + this.tournament.getJumper(i - 1));
        }

        System.out.println();
    }

    private void results() {
        for (int i = 0; i < this.jumperCounter; i++) {
            System.out.println("  " + this.tournament.getJumperName(i));
            System.out.println("    length: " + this.tournament.getLength(i));
            System.out.println("    judge votes:" + this.tournament.getVotes(i));
        }

        System.out.println();

    }

    private void addPoints() {
        for (int i = 0; i < this.jumperCounter; i++) {
            this.tournament.addPoints(i);
        }
    }

    private void tournamentResults() {
        this.tournament.sortJumpersAfterTournament();

        System.out.println("Tournament results:");
        System.out.println("Position    Name");

        for(int i = 0; i < this.jumperCounter; i++) {
            System.out.println((i + 1) + "           " + this.tournament.getJumper(i));
            System.out.print("            jump lengths: " + this.tournament.getAllLengths(i));
            System.out.println();

        }
    }
}
