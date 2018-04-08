package dungeon;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<char[]> board;
    private List<Vampire> vampires;
    private int length;
    private int height;
    private final char VAMPIRE_CHAR = "v".charAt(0);
    private final char PLAYER = "@".charAt(0);
    private final char EMPTY = ".".charAt(0);


    public Board(int length, int height) {
        this.length = length;
        this.height = height;
        this.board = new ArrayList<>();
        createBoard();
    }

    public void addVampires(List<Vampire> vampires) {
        this.vampires = vampires;
    }

    public void moveVampires() {
        for (Vampire vampire : this.vampires) {
            int x = vampire.getXPosition();
            int y = vampire.getYPosition();

            vampire.move();
            replaceVampireCoordinate(vampire, x, y);
        }
    }

    public void movePlayer(Player player, String moves) {
        int x = player.getXPosition();
        int y = player.getYPosition();
        this.board.get(y)[x] = EMPTY;

        player.move(moves);
        x = player.getXPosition();
        y = player.getYPosition();

        this.board.get(y)[x] = PLAYER;
    }

    public void printBoard() {
        for(char[] row : this.board) {
            String rowToString = new String(row);
            System.out.println(rowToString);
        }
    }

    public boolean coordinateIsEmpty(int x, int y) {
        return this.board.get(y)[x] == EMPTY;
    }

    public void vampireToBeRemoved(int x, int y) {
        List<Vampire> toBeRemoved = new ArrayList<>();

        for (Vampire vampire : this.vampires) {
            if (vampire.getXPosition() == x && vampire.getYPosition() == y) {
                toBeRemoved.add(vampire);
                this.board.get(y)[x] = EMPTY;
            }
        }

        this.vampires.removeAll(toBeRemoved);
    }

    private void createBoard() {
        for (int i = 0; i < this.height; i++) {
            char[] row = new char[this.length];

            for (int j = 0; j < this.length; j++) {
                row[j] = EMPTY;
            }

            this.board.add(row);
        }
        this.board.get(0)[0] = PLAYER;

    }

    private void replaceVampireCoordinate(Vampire vampire, int x, int y) {
        while (true) {
            int newX = vampire.getXPosition();
            int newY = vampire.getYPosition();

            if (coordinateIsEmpty(newX, newY)) {
                this.board.get(newY)[newX] = VAMPIRE_CHAR;
                this.board.get(y)[x] = EMPTY;
                break;
            }

            vampire.move();
        }

    }



}
