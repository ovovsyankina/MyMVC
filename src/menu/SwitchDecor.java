package menu;

import mvc.Controller.State;

public class SwitchDecor implements Command{
    State state;
    int p;
    int flag;
    boolean decor;

    public SwitchDecor(State state, int p, int flag, boolean decor) {
        this.state = state;
        this.p = p;
        this.flag = flag;
        this.decor = decor;
    }

    @Override
    public void execute() {
        if (decor && flag == 1) state.Decor(state.getShape(), this.p);
        else if (decor && flag == 2) state.XDecor(state.getShape());
        else state.NoDecor(state.getShape());
    }

}
