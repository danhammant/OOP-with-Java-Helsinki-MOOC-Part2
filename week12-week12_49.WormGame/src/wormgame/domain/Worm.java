package wormgame.domain;


import wormgame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Worm {
    private int x;
    private int y;
    private Direction direction;
    private List<Piece> pieces;
    private boolean grow;

    public Worm (int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        pieces = new ArrayList<>();
        pieces.add(new Piece(x, y));
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLength() {
        return pieces.size();
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void move() {
        if (pieces.size() < 3) {
            grow();
        }

        Piece head = pieces.get(pieces.size() - 1);
        Piece newHead;
        x = head.getX();
        y = head.getY();

        if (direction == Direction.UP) {
            newHead = new Piece(x, y - 1);
        } else if (direction == Direction.DOWN) {
            newHead = new Piece(x, y + 1);
        } else if (direction == Direction.LEFT) {
            newHead = new Piece(x - 1, y);
        } else {
            newHead = new Piece(x + 1, y);
        }

        pieces.add(newHead);
        x = newHead.getX();
        y = newHead.getY();

        if (!grow) {
            pieces.remove(0);
        }

        grow = false;
    }

    public void grow() {
        grow = true;
    }

    public boolean runsInto(Piece piece) {
        for (Piece wormPiece : pieces) {
            if (wormPiece.getX() == piece.getX() && wormPiece.getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        for (Piece piece : pieces) {
            if (piece == pieces.get(pieces.size() - 1)) {
                continue;
            }

            if (piece.getY() == y && piece.getX() == x) {
                return true;
            }

        }

        return false;
    }
}
