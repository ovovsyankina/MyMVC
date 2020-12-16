package mvc.Controller;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import mvc.model.Model;
import mvc.model.ShapeType.MyRectangle;
import mvc.model.activity.Draw;
import mvc.model.MyShape;
import mvc.model.activity.Activity;
import mvc.view.MyFrame;
import mvc.view.MyPanel;
import java.awt.Color;
import mvc.model.UndoMachine;


public class Controller {
    Model model;
    MyFrame frame;
    MyPanel panel;
    Point2D [] pointsArray;
    State state;
    UndoMachine undoMachine;

    public Controller() {
        model = new Model();
        undoMachine = new UndoMachine();
        state = new State(model);
        state.setShape(new MyShape(new MyRectangle()));
        state.setColor(Color.black);
        state.setActivity(new Draw());
        panel = new MyPanel();
        panel.setController(this);
        model.addObserver(panel);
        frame = new MyFrame(state, undoMachine);
        frame.setPanel(panel);
        pointsArray = new Point2D[2];
    }
    public void getPointOne(Point2D p){
        Activity activity = state.getActivity();
        activity.getPointOne(p);
        undoMachine.add(activity.clone());
    }
    public void getPointTwo(Point2D p){
        state.getActivity().getPointTwo(p);
    }

    public void draw(Graphics2D g2) {
        model.draw(g2);
    }
}
