package MovieViewer;

import Events.*;
import MachineStateInterface.MachineState;

public class AMovieViewer implements MachineState , ViewerEventHandler {

    private MachineState currentState ;

    public AMovieViewer()
    {
        this.currentState = (MachineState) new ViewerStateIDle();
        enterState();
    }

    private void changeState(MachineState state){
        exitState();
        this.currentState = state ;
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


    @Override
    public void handleMovieOnEvent(EventMovieOn event) {
        if(!(currentState instanceof ViewerStateIDle))
            return ;

        changeState(new ViewerStatePlay());
    }

    @Override
    public void handleMoviePauseEvent(EventMoviePause event) {
        if(!(currentState instanceof ViewerStatePlay))
            return;

        changeState(new ViewerStatePause());
    }

    @Override
    public void handleMovieIdleEvent(EventMovieIdle event) {
        changeState(new ViewerStateIDle());
    }
}
