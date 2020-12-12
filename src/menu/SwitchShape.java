package menu;


import mvc.Controller.State;
import java.awt.geom.RectangularShape;

public class SwitchShape implements Command{
    State state;
    RectangularShape rs;

    public SwitchShape(State state, RectangularShape rs) {
        this.state = state;
        this.rs = rs;
    }
    
    @Override
    public void execute() {
        state.setRectangularShape(rs);
    }
    
}
