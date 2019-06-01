package MovieViewer;

import MachineStateInterface.MachineState;

public class AMovieViewer implements MachineState {

    private MachineState currentState ;

    public AMovieViewer()
    {
        this.currentState = (MachineState) new ViewerStateIDle();
        enterState();
    }


    @Override
    public void enterState() {
        this.currentState.enterState();
    }

    @Override
    public void exitState() {
        this.currentState.exitState();
    }

    @Override
    public void runState() {
        this.currentState.runState();
    }
}
