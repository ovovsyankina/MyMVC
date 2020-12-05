package mvc.model;

import mvc.model.decorator.ShapeDecorator;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Observable;

public class Model extends Observable {

    ShapeDecorator currentShape;

    public Model() {
    }

    public void setMyShape(ShapeDecorator myShape) {
        this.currentShape = myShape;
    }

    public void changeShape(Point2D[] pd) {
        currentShape.setFrame(pd);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        currentShape.draw(g);
    }

}
