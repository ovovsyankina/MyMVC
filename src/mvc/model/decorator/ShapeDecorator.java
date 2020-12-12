package mvc.model.decorator;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.awt.Color;
import java.awt.Graphics2D;

public interface ShapeDecorator {
    void draw(Graphics2D g);
    void setParametr(int p);
    void setColor(Color c);
    void setFb(MyShape.FillBehavior f);
    void setShape(RectangularShape r);
    void setFrame(Point2D[] p);
    void setLine(Line2D r);
    boolean contains(Point2D p);

    RectangularShape getShape();
    ShapeDecorator clone();
}
