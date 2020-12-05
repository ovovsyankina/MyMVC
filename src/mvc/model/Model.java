package mvc.model;

import mvc.model.decorator.ShapeDecorator;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.ArrayList;

public class Model extends Observable {

    ShapeDecorator currentShape;
    ShapeDecorator sampleShape;
    ArrayList<ShapeDecorator> list;

    public Model() {
        list = new ArrayList<>();
    }

    public void initCurrentShape() {
        currentShape = sampleShape.clone();
        list.add(currentShape);
    }

    public void setMyShape(ShapeDecorator myShape) {
        this.sampleShape = myShape;
    }

    public void changeShape(Point2D[] pd) {
        currentShape.setFrame(pd);
        this.setChanged();
        this.notifyObservers();
    }

    public void draw(Graphics2D g) {
        if (list != null) {
            for (ShapeDecorator s : list) {
                s.draw(g);
            }
        }
    }

}
