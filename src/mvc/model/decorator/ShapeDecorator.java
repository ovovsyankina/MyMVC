package mvc.model.decorator;

import mvc.model.MyShape;
import mvc.model.ShapeType.ShapeInterface;

import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics2D;

public interface ShapeDecorator {
    void draw(Graphics2D g);
    void setParametr(int p);
    void setColor(Color c);
    void setFb(MyShape.FillBehavior f);
    void setShape(ShapeInterface r);
    void setFrame(Point2D[] p);
    boolean contains(Point2D p);

    ShapeInterface getShape();
    ShapeDecorator clone();
}
