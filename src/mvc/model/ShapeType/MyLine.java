package mvc.model.ShapeType;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MyLine extends Line2D.Double implements ShapeInterface {
    @Override
    public void mySetFrameFromDiagonal(double x1, double y1, double x2, double y2) {
        setLine(x1,y1,x2,y2);
    }

    @Override
    public void mySetFrameFromDiagonal(Point2D first, Point2D second) {
        setLine(first, second);
    }

    @Override
    public double getMinX() {
        return getX1();
    }

    @Override
    public double getMinY() {
        return getY1();
    }

    @Override
    public double getMaxX() {
        return getX2();
    }

    @Override
    public double getMaxY() {
        return getY2();
    }

    @Override
    public boolean contains(Point2D p){
        Rectangle2D bounds = getBounds2D();
        return bounds.getMinX() < p.getX() && p.getX() < bounds.getMaxX() && bounds.getMinY() < p.getY() && p.getY() < bounds.getMaxY();
    }
}
