package mvc.model;

import mvc.model.ShapeType.MyLine;
import mvc.model.ShapeType.MyRectangle;
import mvc.model.ShapeType.ShapeInterface;
import mvc.model.decorator.ShapeDecorator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.io.Serializable;

public class MyShape implements ShapeDecorator, Serializable {

    Color color;
    ShapeInterface shape;
    FillBehavior fb;

    public MyShape(ShapeInterface shape) {
        this.shape = shape;
        color = Color.black;
        fb = FillBehavior.NO_FILL;
    }

    public MyShape() {
        color = Color.black;
        shape = new MyRectangle();
        fb =  FillBehavior.NO_FILL;;
    }

    public MyShape(Color color, ShapeInterface shape, FillBehavior fb) {
        this.color = color;
        this.shape = shape;
        this.fb = fb;
    }

    public void setFb(FillBehavior fb) {
        this.fb = fb;
    }

    public void setShape(ShapeInterface shape) {
        this.shape = shape;
    }

    public void setFrame(Point2D[] pd) {
        shape.mySetFrameFromDiagonal(pd[0], pd[1]);
    }

    public void draw(Graphics2D g) {
        if(shape instanceof MyLine){
            Paint paint = g.getPaint();
            g.setPaint(color);
            g.draw(shape);
            g.setPaint(paint);
        }
        else fb.draw(g,color,shape);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public MyShape.FillBehavior getFb() {
        return fb;
    }

    public boolean contains(Point2D p){
        return shape.contains(p);
    }

    @Override
    public void setParametr(int p) {
    }

    @Override
    public ShapeInterface getShape() {
        return shape;
    }

    @Override
    public ShapeDecorator clone() {
        ShapeDecorator s = new MyShape();
        ShapeInterface s1 = (ShapeInterface) shape.clone();
        s.setColor(color);
        s.setShape(s1);
        ((MyShape)s).fb = this.fb;
        return s;
    }

    public enum FillBehavior {
        FILL {
            @Override
            public void draw(Graphics2D g,  Color c, ShapeInterface sh) {
                Paint paint = g.getPaint();
                g.setPaint(c);
                g.fill(sh);
                g.setPaint(paint);
            }
        } ,
        NO_FILL {
            @Override
            public void draw(Graphics2D g, Color c, ShapeInterface sh) {
                Paint paint = g.getPaint();
                g.setPaint(c);
                g.draw(sh);
                g.setPaint(paint);
            }
        };
        public abstract void  draw(Graphics2D g, Color c, ShapeInterface sh);
    }
}
