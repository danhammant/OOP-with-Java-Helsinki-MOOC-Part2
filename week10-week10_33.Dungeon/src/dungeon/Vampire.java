package dungeon;

import java.util.Random;


public class Vampire extends Movable{
    private Random random;

    public Vampire(Board board, int length, int height) {
        super (board, length, height);

        this.random = new Random();
        initialPosition();
    }


    public void move() {
        super.xPosition = this.random.nextInt(super.boardLength);
        super.yPosition = this.random.nextInt(super.boardHeight);
    }

    private void initialPosition() {
        while (true) {
            move();

            if(super.getXPosition() != 0 && super.getYPosition() != 0 && coordinateIsEmpty()) {
                break;
            }
        }
    }



}
