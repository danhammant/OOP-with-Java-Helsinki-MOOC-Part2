package wormgame.gui;

import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;


public class DrawingBoard extends JPanel implements Updatable{
    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard (WormGame wormGame, int pieceLength) {
        super.setBackground(Color.gray);
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        for (Piece piece : wormGame.getWorm().getPieces()) {
            g.fill3DRect(pieceLength * piece.getX(), pieceLength * piece.getY(), pieceLength, pieceLength, true);
        }

        Apple apple = wormGame.getApple();

        g.setColor(Color.RED);
        g.fillOval(pieceLength * apple.getX(), pieceLength * apple.getY(), pieceLength, pieceLength);
    }

    @Override
    public void update() {
        super.repaint();
    }
}
