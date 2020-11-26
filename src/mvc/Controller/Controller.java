package mvc.Controller;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import mvc.model.Model;
import mvc.model.MyShape;
import mvc.view.MyFrame;
import mvc.view.MyPanel;

public class Controller {
    Model model;
    MyFrame frame;
    MyPanel panel;
    Point2D [] dotsArray;

    public Controller() {
        model = new Model();
        model.setMyShape(new MyShape(new Rectangle2D.Double()));
        panel = new MyPanel();
        panel.setController(this);
        frame = new MyFrame();
        frame.setPanel(panel);
        dotsArray = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        dotsArray[0] = p;
    }
    public void getPointTwo(Point2D p){
        dotsArray[1] = p;
        model.changeShape(dotsArray);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
