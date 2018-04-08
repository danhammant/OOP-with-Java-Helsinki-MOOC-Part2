package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;


public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (withinBoard(x, y)) {
            getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (withinBoard(x, y)) {
            getBoard()[x][y] = false;
        }
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (!withinBoard(x, y)) {
            return false;
        }

        return getBoard()[x][y];
    }

    @Override
    public void initiateRandomCells(double probabilityForEachCell) {
        if (probabilityForEachCell == 0.0) {
            turnAllDead();
        } else if (probabilityForEachCell == 1.0) {
            turnAllAlive();
        } else {
            generateRandomAlive(probabilityForEachCell);
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int neighbours = 0;

        if (isAlive(x - 1, y - 1)) {
            neighbours ++;
        }
        if (isAlive(x, y - 1)) {
            neighbours++;
        }
        if (isAlive(x + 1, y - 1)) {
            neighbours++;
        }
        if (isAlive(x - 1, y)) {
            neighbours++;
        }
        if (isAlive(x + 1, y)) {
            neighbours++;
        }
        if (isAlive(x - 1, y + 1)) {
            neighbours++;
        }
        if (isAlive(x, y + 1)) {
            neighbours++;
        }
        if (isAlive(x + 1, y + 1)) {
            neighbours++;
        }

        return neighbours;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2 || livingNeighbours > 3) {
            turnToDead(x, y);
        }

        if (!isAlive(x, y) && livingNeighbours == 3) {
            turnToLiving(x, y);
        }


    }

    private boolean withinBoard(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }

    private boolean isCorner(int x, int y) {
        if (x == 0 && y == 0) {
            return true;
        } else if (x == 0 && y == getHeight() - 1) {
            return true;
        } else if (x == getWidth() - 1 && y == 0) {
            return true;
        } else if (x == getWidth() -1 && y == getHeight() -1) {
            return true;
        }

        return false;
    }

    private void turnAllDead() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                turnToDead(x, y);
            }
        }
    }

    private void turnAllAlive() {
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                turnToLiving(x, y);
            }
        }
    }

    private void generateRandomAlive(double probabilityForEachCell) {
        Random random = new Random();
        double numberOfCellsToBeAlive = (getHeight() * getWidth()) * probabilityForEachCell;
        int cellsToBeAliveAsInt = (int) Math.round(numberOfCellsToBeAlive);

        int i = 0;
        while (i < cellsToBeAliveAsInt) {
            int x = random.nextInt(getWidth());
            int y = random.nextInt(getHeight());

            if (!isAlive(x, y)) {
                turnToLiving(x, y);
                i++;
            }
        }
    }




}
