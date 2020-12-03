package mvc.Controller;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import mvc.model.Model;
import mvc.model.MyShape;
import mvc.view.MyFrame;
import mvc.view.MyPanel;
import java.awt.Color;


public class Controller {
    Model model;
    MyFrame frame;
    MyPanel panel;
    Point2D [] pointsArray;
    State state;

    public Controller() {
        model = new Model();
        state = new State(model);
        state.setShape(new MyShape(new Rectangle2D.Double()));
        state.setColor(Color.black);
        panel = new MyPanel();
        panel.setController(this);
        model.addObserver(panel);
        frame = new MyFrame(state);
        frame.setPanel(panel);
        pointsArray = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        pointsArray[0] = p;
    }
    public void getPointTwo(Point2D p){
        pointsArray[1] = p;
        model.changeShape(pointsArray);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
