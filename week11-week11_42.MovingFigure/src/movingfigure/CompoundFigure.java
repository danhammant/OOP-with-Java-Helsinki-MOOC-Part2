package movingfigure;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class CompoundFigure extends Figure {
    private List<Figure> figures;

    public CompoundFigure() {
        super(0, 0);
        this.figures = new ArrayList<>();
    }

    public void add(Figure f) {
        this.figures.add(f);
    }

    @Override
    public void move(int x, int y) {
        for (Figure figure : this.figures) {
            figure.move(x, y);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        for (Figure figure : this.figures) {
            figure.draw(graphics);
        }
    }
}
