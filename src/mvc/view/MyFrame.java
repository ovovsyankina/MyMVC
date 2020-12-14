package mvc.view;

import menu.*;
import mvc.Controller.State;
import mvc.model.activity.Draw;
import mvc.model.activity.Move;
import mvc.model.decorator.Line.MyLine;
import mvc.model.decorator.MyShape;
import mvc.model.UndoMachine;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.*;

public class MyFrame extends JFrame {

    MyPanel panel;
    State state;
    UndoMachine undoMachine;

    public MyFrame(State state, UndoMachine undoMachine) {
        this.state = state;
        this.undoMachine = undoMachine;
        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);

        ArrayList<Action> menuItems = new ArrayList<>();
        menuItems.add(new SwitchState("Открыть",new ImageIcon("open.png"),
                new OpenFile(state)));
        menuItems.add(new SwitchState("Сохранить как", new ImageIcon("save.png"),
                new SaveFile(state)));
        menuItems.add(new SwitchState("Линия",new ImageIcon("line.png"),
                new SwitchShape(state, new MyLine.Double())));
        menuItems.add(new SwitchState("Прямоугольник",new ImageIcon("rect.png"),
                new SwitchShape(state, new Rectangle2D.Double())));
        menuItems.add(new SwitchState("Овал", new ImageIcon("elipse.png"),
                new SwitchShape(state, new Ellipse2D.Double())));
        menuItems.add(new SwitchState("Залитая", new ImageIcon("fill.png"),
                new SwitchFill(state, MyShape.FillBehavior.FILL)));
        menuItems.add(new SwitchState("Незалитая", new ImageIcon("no_fill.png"),
                new SwitchFill(state, MyShape.FillBehavior.NO_FILL)));
        menuItems.add(new SwitchState("Декорированная", new ImageIcon("decor.png"),
                new SwitchDecor(state, 10, true)));
        menuItems.add(new SwitchState("Недекорированная", new ImageIcon("no_decor.png"),
                new SwitchDecor(state, 0, false)));
        menuItems.add(new SwitchState("Рисовать", new ImageIcon("draw.png"),
                new SwitchActivity(state, new Draw())));
        menuItems.add(new SwitchState("Двигать", new ImageIcon("move.png"),
                new SwitchActivity(state, new Move())));
        menuItems.add(new SwitchUndo("Назад",new ImageIcon("undo.png"),undoMachine));
        menuItems.add(new SwitchRedo("Вперед",new ImageIcon("redo.png"),undoMachine));
        menuItems.add(new SwitchState("Выбор цвета", new ImageIcon("color.png"),
                new SwitchColor(state)));
        undoMachine.addObserver((SwitchUndo)menuItems.get(menuItems.size()-3));
        undoMachine.addObserver((SwitchRedo)menuItems.get(menuItems.size()-2));
        undoMachine.notifyMenu();

        JMenu fileMenu = new JMenu("Файл");
        bar.add(fileMenu);
        fileMenu.add(menuItems.get(0));
        fileMenu.add(menuItems.get(1));

        JMenu shapeMenu = new JMenu("Фигура");
        bar.add(shapeMenu);
        for (int i = 2; i <= 4; i++){
            shapeMenu.add(menuItems.get(i));
        }
        ArrayList<JMenu> list = new ArrayList<JMenu>();
        list.add(new JMenu("Заливка"));
        list.add(new JMenu("Декор"));
        list.add(new JMenu("Действие"));
        list.add(new JMenu("Назад/вперед"));
        int j = 5;
        for(JMenu el : list) {
            if(j < menuItems.size() - 2) {
                bar.add(el);
                el.add(menuItems.get(j));
                el.add(menuItems.get(j + 1));
                j = j + 2;
            }
        }
        JMenu colorMenu = new JMenu("Выбор цвета");
        bar.add(colorMenu);
        colorMenu.add(menuItems.get(13));

        JToolBar toolBar = new JToolBar();
        add(toolBar, BorderLayout.NORTH);
        for (int i = 2; i < menuItems.size(); i++) {
            toolBar.add(menuItems.get(i));
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 800);
        setVisible(true);
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }

}
