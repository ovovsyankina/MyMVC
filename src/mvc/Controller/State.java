package mvc.Controller;

import mvc.model.Model;
import mvc.model.ShapeType.ShapeInterface;
import mvc.model.decorator.MyShape;
import mvc.model.decorator.ShapeDecorator;
import java.awt.Color;
import java.awt.geom.RectangularShape;
import mvc.model.decorator.BorderDecorator;
import mvc.model.activity.Activity;

public class State {
    Model model;
    ShapeDecorator shape;
    Color color;
    MyShape.FillBehavior fb;
    ShapeInterface rectangularShape;
    Activity activity;

    public State(Model model) {
        this.model = model;
    }

    public Model getModel(){
        return this.model;
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    public ShapeDecorator getShape() {
        return this.shape;
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

    public void setRectangularShape(ShapeInterface rectangularShape) {
        this.shape = new MyShape();
        this.rectangularShape = rectangularShape;
        shape.setShape(rectangularShape);
        model.setMyShape(shape);
    }

    public void Decor(ShapeDecorator shape, int p){
        shape = new BorderDecorator(shape);
        shape.setParametr(p);
        shape = new BorderDecorator(shape);
        shape.setParametr(p+20);
        model.setMyShape(shape);
    }

    public void NoDecor(ShapeDecorator shape){
        model.setMyShape(shape);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        this.activity.setModel(model);
    }

    public Activity getActivity() {
        return activity;
    }

}
