package mvc.model.ShapeType;

import java.awt.*;
import java.awt.geom.Point2D;

public interface ShapeInterface extends Shape {

    void mySetFrameFromDiagonal(double x1, double y1, double x2, double y2);
    void mySetFrameFromDiagonal(Point2D first, Point2D second);

    Object clone();

    double getMinX();
    double getMinY();

    double getMaxX();
    double getMaxY();

    boolean contains(Point2D p);
}
