package dungeon;


public class Movable {
    protected Board board;
    protected int xPosition;
    protected int yPosition;
    protected int boardLength;
    protected int boardHeight;

    public Movable(Board board, int boardLength, int boardHeight) {
        this.board = board;
        this.xPosition = 0;
        this.yPosition = 0;
        this.boardLength = boardLength;
        this.boardHeight = boardHeight;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    public boolean coordinateIsEmpty() {
        return this.board.coordinateIsEmpty(this.xPosition, this.yPosition);
    }



}
