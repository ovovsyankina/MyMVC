package mvc.model.decorator;

import mvc.model.MyShape;
import mvc.model.ShapeType.MyLine;
import mvc.model.ShapeType.ShapeInterface;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class XLineDecorator implements ShapeDecorator, Serializable {

    ShapeDecorator shape;

    public XLineDecorator(ShapeDecorator shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics2D g) {
        ShapeInterface line1 = new MyLine();
        ShapeInterface line2 = new MyLine();
        ShapeInterface shape_clone = (ShapeInterface) shape.getShape().clone();
        Point2D x1 = new Point2D.Double(shape_clone.getMinX() - 10, shape_clone.getMinY() - 10);
        Point2D x2 = new Point2D.Double(shape_clone.getMaxX() + 10, shape_clone.getMinY() - 10);
        Point2D y1 = new Point2D.Double(shape_clone.getMinX() - 10, shape_clone.getMaxY() + 10);
        Point2D y2 = new Point2D.Double(shape_clone.getMaxX() + 10, shape_clone.getMaxY() + 10);
        line1.mySetFrameFromDiagonal(x1, y2);
        line2.mySetFrameFromDiagonal(x2, y1);
        shape.draw(g);
        g.draw(line1);
        g.draw(line2);
    }

    @Override
    public void setParametr(int p) {

    }

    @Override
    public ShapeInterface getShape() {
        return  shape.getShape();
    }

    @Override
    public ShapeDecorator clone() {
        XLineDecorator xd = new XLineDecorator(shape.clone());
        return xd;
    }

    @Override
    public void setColor(Color c) {
        shape.setColor(c);
    }

    @Override
    public void setFb(MyShape.FillBehavior f) {
        shape.setFb(f);
    }

    @Override
    public void setShape(ShapeInterface r) {
        shape.setShape(r);
    }

    @Override
    public void setFrame(Point2D[] p) {
        shape.setFrame(p);
    }

    @Override
    public boolean contains(Point2D p){
        return shape.contains(p);
    }

}

