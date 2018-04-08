package dungeon;


public class Player extends Movable{
    private final String MOVES = "wsad";

    public Player(Board board, int length, int height) {
        super(board, length, height);
    }

    public void move(String moves) {
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == this.MOVES.charAt(0)) {
                handleW();
            } else if (moves.charAt(i) == this.MOVES.charAt(1)) {
                handleS();
            } else if (moves.charAt(i) == this.MOVES.charAt(2)) {
                handleA();
            } else if (moves.charAt(i) == this.MOVES.charAt(3)) {
                handleD();
            }
        }
    }

    private void handleW() {
        if (super.yPosition - 1 >= 0) {
            super.yPosition -= 1;
            checkIfVampireAtCoordinate();
        }
    }

    private void handleS() {
        if (super.yPosition + 1 < super.boardHeight) {
            super.yPosition += 1;
            checkIfVampireAtCoordinate();
        }
    }

    private void handleA() {
        if (super.xPosition - 1 >= 0) {
            super.xPosition -= 1;
            checkIfVampireAtCoordinate();
        }
    }

    private void handleD() {
        if (super.xPosition + 1 < super.boardLength) {
            super.xPosition += 1;
            checkIfVampireAtCoordinate();
        }
    }

    private void checkIfVampireAtCoordinate() {
        if(!coordinateIsEmpty()) {
            super.board.vampireToBeRemoved(super.xPosition, super.yPosition);
        }
    }


}
