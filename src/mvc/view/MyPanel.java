package mvc.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;
import mvc.Controller.Controller;

public class MyPanel extends JPanel{
    Controller controller;
    
    public MyPanel(){
        
        addMouseListener(new MouseAdapter() {
            @Override
             public void mousePressed(MouseEvent point){
                 controller.getPointOne( point.getPoint());
             }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent point) {
                controller.getPointTwo(point.getPoint());
                repaint();
               
            }
        });
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        controller.draw(g2);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
   
}
