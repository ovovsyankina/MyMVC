package menu;

import mvc.Controller.State;

public class SwitchDecor implements Command{
    State state;
    int p;
    boolean decor;

    public SwitchDecor(State state, int p, boolean decor) {
        this.state = state;
        this.p = p;
        this.decor = decor;
    }

    @Override
    public void execute() {
        if (decor) state.Decor(state.getShape(), this.p);
        else state.NoDecor(state.getShape());
    }

}
