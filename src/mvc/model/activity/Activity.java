package mvc.model.activity;

import mvc.model.Model;
import java.awt.geom.Point2D;

public interface Activity {
    void getPointOne(Point2D p1);
    void getPointTwo(Point2D p1);
    void setModel(Model m);
    void execute();
    void unexecute();
    Activity clone();
}
