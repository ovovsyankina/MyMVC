package mvc.model.decorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.io.Serializable;

public class MyLine implements ShapeDecorator, Serializable {
    Color color;
    Line2D shape;
    double x1;
    double x2;
    double y1;
    double y2;

    public MyLine(){
        shape = new Line2D.Double(x1,y1,x2,y2);
    }
    @Override
    public void draw(Graphics2D g){
        g.setColor(color);
        g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
    };
    public void setParametr(int p){};
    public void setColor(Color c){
        this.color = c;
    };
    public void setFb(MyShape.FillBehavior f){};
    public void setShape(RectangularShape r){

    };

    public void setLine(Line2D r){
        this.shape = r;
    }
    public void setFrame(Point2D[] p){
        x1 = p[0].getX();
        x2 = p[1].getX();
        y1 = p[0].getY();
        y2 = p[1].getY();
    };
    public boolean contains(Point2D p){
        return shape.contains(p);
    };
    @Override
    public RectangularShape getShape(){return new Rectangle2D.Double();};
    @Override
    public ShapeDecorator clone(){
        ShapeDecorator s = new MyLine();
        Line2D.Double s1 = (Line2D.Double) shape.clone();
        s.setColor(color);
        s.setLine(s1);
        return s;
    };
}
