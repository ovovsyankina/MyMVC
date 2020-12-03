package mvc.view;

import mvc.Controller.State;
import mvc.model.MyShape;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyFrame extends JFrame {

    MyPanel panel;
    State state;

    public MyFrame(State state) {
        this.state = state;
        JMenuBar bar = new JMenuBar();
        this.setJMenuBar(bar);
        JMenu menuFB = new JMenu("FB");
        bar.add(menuFB);
        JMenu menuShape = new JMenu("Shape");
        bar.add(menuShape);
        JMenu menuColor = new JMenu("Color");
        bar.add(menuColor);
        JMenuItem fillShape = new JMenuItem("Fill");
        JMenuItem noFillShape = new JMenuItem("NoFill");
        menuFB.add(fillShape);
        menuFB.add(noFillShape);
        JMenuItem RectShape = new JMenuItem("Rectangle");
        JMenuItem EllipseShape = new JMenuItem("Ellipse");
        menuShape.add(RectShape);
        menuShape.add(EllipseShape);
        JMenuItem Red = new JMenuItem("Red");
        JMenuItem Blue = new JMenuItem("Blue");
        JMenuItem Green = new JMenuItem("Green");
        JMenuItem Yellow = new JMenuItem("Yellow");
        JMenuItem Black = new JMenuItem("Black");
        JMenuItem Magenta = new JMenuItem("Magenta");
        menuColor.add(Red);
        menuColor.add(Blue);
        menuColor.add(Green);
        menuColor.add(Yellow);
        menuColor.add(Black);
        menuColor.add(Magenta);

        //FB listeners
        fillShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setFb(MyShape.FillBehavior.FILL);
            }
        });
        noFillShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setFb(MyShape.FillBehavior.NO_FILL);
            }
        });
        //Shape listeners
        RectShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setRectangularShape(new Rectangle2D.Double());
            }
        });
        EllipseShape.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setRectangularShape(new Ellipse2D.Double());
            }
        });
        //Color listeners
        Red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.red);
            }
        });
        Blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.blue);
            }
        });
        Green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.green);
            }
        });
        Yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.yellow);
            }
        });
        Black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.black);
            }
        });
        Magenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.setColor(Color.magenta);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }

}
