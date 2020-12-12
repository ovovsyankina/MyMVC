package menu;

import mvc.Controller.State;
import mvc.model.decorator.MyLine;

public class SwitchLine implements Command{
    State state;
    MyLine line;

    public SwitchLine(State state, MyLine line) {
        this.state = state;
        this.line = line;
    }

    @Override
    public void execute() {
        state.line();
    }

}
