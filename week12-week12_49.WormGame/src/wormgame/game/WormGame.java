package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        this.worm = new Worm(width / 2, height / 2, Direction.DOWN);

        createApple();

        addActionListener(this);
        setInitialDelay(2000);

    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }

        worm.move();

        if (worm.runsInto(apple)) {
            worm.grow();
            createApple();
        }

        if (worm.runsIntoItself()) {
            continues = false;
        }

        if (boarderHit()) {
            continues = false;
        }

        updatable.update();
        setDelay(1000 / worm.getLength());

    }

    private void createApple() {
        Random appleCoordinates = new Random();

        while (true) {
            int appleX = appleCoordinates.nextInt(width);
            int appleY = appleCoordinates.nextInt(height);
            apple = new Apple(appleX, appleY);

            if (!worm.runsInto(apple)) {
                break;
            }

        }
    }

    private boolean boarderHit() {
        Piece wormHead = worm.getPieces().get(worm.getPieces().size() - 1);

        if (wormHead.getX() < 0 || wormHead.getX() >= width) {
            return true;
        }

        if (wormHead.getY() < 0 || wormHead.getY() >= height) {
            return true;
        }

        return false;
    }

}
