package mvc.model;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Model {
    MyShape currentShape;

    public Model() {
    }

    public void setMyShape(MyShape myShape) {
        this.currentShape = myShape;
    }
    public void changeShape(Point2D[] dotsArray){
        currentShape.setFrame(dotsArray);
    }
    public void draw(Graphics2D g){
        currentShape.draw(g);
    }
}
