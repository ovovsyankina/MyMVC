package mvc.model.ShapeType.Line;

import java.awt.geom.*;
import java.io.Serializable;

public abstract class MyLine extends RectangularShape {

    public static class Double extends MyLine implements Serializable {
        double x1,x2,y1,y2;

        public double getX(){
            return x1;
        }

        public double getY(){
            return y1;
        }

        public double getWidth(){
            return x2;
        }

        public double getHeight(){
            return y2;
        }

        @Override
        public double getMinX() {
            return getX();
        }

        @Override
        public double getMinY() {
            return getY();
        }

        @Override
        public double getMaxX() {
            return getWidth();
        }

        @Override
        public double getMaxY() {
            return getHeight();
        }

        public boolean isEmpty(){
            return (x1 == x2 && y1 == y2);
        }

        public void setFrame(double x, double y, double w, double h){
            x1 = x;
            x2 = w;
            y1 = y;
            y2 = h;
        }

        public void setFrame(Point2D[] p){
            x1 = p[0].getX();
            x2 = p[1].getX();
            y1 = p[0].getY();
            y2 = p[1].getY();
        };

        @Override
        public void setFrameFromDiagonal(double x, double y, double w, double h) {
            x1 = x;
            x2 = w;
            y1 = y;
            y2 = h;
        }
        @Override
        public void setFrameFromDiagonal(Point2D d, Point2D p) {
            x1 = d.getX();
            x2 = p.getX();
            y1 = d.getY();
            y2 = p.getY();
        }

        public Rectangle2D getBounds2D(){
            double x, y, w, h;
            if (x1 < x2) {
                x = x1;
                w = x2 - x1;
            } else {
                x = x2;
                w = x1 - x2;
            }
            if (y1 < y2) {
                y = y1;
                h = y2 - y1;
            } else {
                y = y2;
                h = y1 - y2;
            }
            return new Rectangle2D.Double(x, y, w, h);
        }

    }

    public boolean contains(double x0, double y0){
        double w, h, x, y;
        w = getWidth();
        h = getHeight();
        if (w <= 0.0) return false;
        if (h <= 0.0) return false;
        x = (w - x0) / w - 0.5;
        y = (h - y0) / h - 0.5;
        return Math.abs(x)+Math.abs(y) <= 0.5;
    }

    public boolean contains(Point2D p){
        double w, h, x, y;
        w = getWidth();
        h = getHeight();
        if (w <= 0.0) return false;
        if (h <= 0.0) return false;
        x = (w - p.getX()) / w - 0.5;
        y = (h - p.getY()) / h - 0.5;
        return Math.abs(x)+Math.abs(y) <= 0.5;
    }

    public boolean contains(double x0, double y0, double w, double h){
        return (contains(x0, y0) && contains(x0 + w, y0) && contains(x0, y0 + h) && contains(x0 + w, y0 + h));
    }

    public boolean intersects(double x, double y, double w, double h) {
        return true;
    }

    public PathIterator getPathIterator(AffineTransform at){
        return new MyPathIterator(this, at);
    }
}
