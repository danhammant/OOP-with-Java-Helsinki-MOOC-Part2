package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon {

    private int moves;
    private boolean vampiresMove;
    private List<Vampire> vampireList;
    private Player player;
    private Board board;
    private Scanner reader;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.board = new Board(length, height);
        this.vampireList = new ArrayList<>();
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.player = new Player(this.board, length, height);
        this.reader = new Scanner(System.in);

        createVampires(length, height, vampires);
        this.board.addVampires(this.vampireList);
        this.board.moveVampires();

    }

    public void run() {
        while (true) {
            System.out.println(this.moves);
            System.out.println();
            printPlayerAndVampires();
            printBoard();

            System.out.println();
            String input = this.reader.nextLine();
            handleInput(input);
            this.moves--;

            if (this.vampireList.isEmpty()) {
                System.out.println("YOU WIN");
                break;
            }

            if (this.moves == 0) {
                System.out.println("YOU LOSE");
                break;
            }
        }
    }

    private void handleInput(String moves) {
        if (this.vampiresMove) {
            movePlayerAndVampires(moves);
        } else {
            movePlayer(moves);
        }
    }

    private void movePlayerAndVampires(String moves) {
        this.board.movePlayer(this.player, moves);
        this.board.moveVampires();
    }

    private void movePlayer(String moves) {
        this.board.movePlayer(this.player, moves);
    }


    private void printBoard() {
        this.board.printBoard();
    }

    private void printPlayerAndVampires() {
        System.out.println("@ " + this.player.getXPosition() + " " + this.player.getYPosition());

        for(Vampire vampire : this.vampireList) {
            System.out.println("v " + vampire.getXPosition() + " " + vampire.getYPosition());
        }

        System.out.println();
    }

    private void createVampires(int length, int height, int vampireAmount) {
        for (int i = 0; i < vampireAmount; i++) {
            this.vampireList.add(new Vampire(this.board, length, height));
        }
    }
}
