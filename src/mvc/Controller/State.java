package mvc.Controller;

import mvc.model.Model;
import mvc.model.MyShape;
import java.awt.Color;
import java.awt.geom.RectangularShape;

public class State {
    Model model;
    MyShape shape;
    Color color;
    MyShape.FillBehavior fb;
    RectangularShape rectangularShape;

    public State(Model model) {
        this.model = model;
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    public void setColor(Color color) {
        this.color = color;
        shape.setColor(color);
        model.setMyShape(shape);
    }

    public void setFb(MyShape.FillBehavior fb) {
        this.fb = fb;
        shape.setFb(fb);
        model.setMyShape(shape);
    }

    public void setRectangularShape(RectangularShape rectangularShape) {
        this.rectangularShape = rectangularShape;
        shape.setShape(rectangularShape);
        model.setMyShape(shape);
    }

    public MyShape getShape() {
        return shape;
    }

}
