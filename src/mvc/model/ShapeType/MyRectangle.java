package mvc.model.ShapeType;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle extends Rectangle2D.Double implements ShapeInterface {

    @Override
    public void mySetFrameFromDiagonal(double x1, double y1, double x2, double y2) {
        setFrameFromDiagonal(x1,y1,x2,y2);
    }

    @Override
    public void mySetFrameFromDiagonal(Point2D first, Point2D second) {
        setFrameFromDiagonal(first,second);
    }

    @Override
    public boolean contains(Point2D p){
        Rectangle2D bounds = getBounds2D();
        return bounds.getMinX() < p.getX() && p.getX() < bounds.getMaxX() && bounds.getMinY() < p.getY() && p.getY() < bounds.getMaxY();
    }
}
