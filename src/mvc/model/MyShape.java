package mvc.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

public class MyShape {
    RectangularShape shape;

    public MyShape(RectangularShape shape) {
        this.shape = shape;
    }

    public MyShape() {
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }
    
    public void setFrame(Point2D[] dotsArray){
        shape.setFrameFromDiagonal(dotsArray[0], dotsArray[1]);
    }

    void draw(Graphics2D g) {
        g.draw(shape);
    }
    
}
