package mvc.model.decorator;

import mvc.model.ShapeType.ShapeInterface;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.io.Serializable;

public class BorderDecorator implements ShapeDecorator, Serializable {

    ShapeDecorator shape;
    int borderWidth;

    public BorderDecorator(ShapeDecorator shape) {
        this.shape = shape;
    }

    @Override
    public void draw(Graphics2D g) {
        ShapeInterface border = (ShapeInterface) shape.getShape().clone();
        Point2D left = new Point2D.Double(border.getMinX()-borderWidth,
                border.getMinY()- borderWidth);
        Point2D right = new Point2D.Double(border.getMaxX()+borderWidth,
                border.getMaxY()+borderWidth);
        border.mySetFrameFromDiagonal(left, right);
        shape.draw(g);
        g.draw(border);
    }

    @Override
    public void setParametr(int p) {
        borderWidth = p;
    }

    @Override
    public ShapeInterface getShape() {
        return  shape.getShape();
    }

    @Override
    public ShapeDecorator clone() {
        BorderDecorator bd = new BorderDecorator(shape.clone());
        bd.borderWidth = borderWidth;
        return bd;
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

