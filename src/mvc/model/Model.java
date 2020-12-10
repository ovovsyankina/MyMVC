package mvc.model;

import mvc.model.decorator.ShapeDecorator;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.Observable;
import java.util.ArrayList;

public class Model extends Observable {

    ShapeDecorator currentShape;
    ShapeDecorator sampleShape;
    ArrayList<ShapeDecorator> list;

    public Model() {
        list = new ArrayList<>();
    }

    public ShapeDecorator initCurrentShape() {
        currentShape = sampleShape.clone();
        list.add(currentShape);
        return currentShape;
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

    public ShapeDecorator findShape(Point2D p1) {
        if (list != null) {
            for (ShapeDecorator s : list) {
                if (s.contains(p1)) {
                    currentShape = s;
                    return currentShape;
                };
            }
        }
        return null;
    }

    public void moveShape(Point2D[] p) {
        double deltaX = p[0].getX() - p[1].getX();
        double deltaY = p[0].getY() - p[1].getY();
        if (currentShape != null) {
            RectangularShape s = currentShape.getShape();
            double xMin = s.getMinX() - deltaX;
            double yMin = s.getMinY() - deltaY;
            double xMax = s.getMaxX() - deltaX;
            double yMax = s.getMaxY() - deltaY;
            s.setFrameFromDiagonal(xMin, yMin, xMax, yMax);
            p[0] = p[1];
            setChanged();
            notifyObservers();
        }
    }

}
