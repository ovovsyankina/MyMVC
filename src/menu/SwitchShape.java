package menu;


import mvc.Controller.State;
import mvc.model.ShapeType.ShapeInterface;


public class SwitchShape implements Command{
    State state;
    ShapeInterface rs;

    public SwitchShape(State state, ShapeInterface rs) {
        this.state = state;
        this.rs = rs;
    }
    
    @Override
    public void execute() {
        state.setRectangularShape(rs);
    }
    
}
