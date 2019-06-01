package MovieViewer;

import Connections.Connections;
import Events.*;
import MachineStateInterface.MachineState;

import java.util.Observable;
import java.util.Observer;

public class AMovieViewer implements MachineState , ViewerEventHandler , Observer {

    private MachineState currentState ;
    private ViewerStatePlay moviePlaying;

    public AMovieViewer() {
        this.currentState = new ViewerStateIDle();
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
    public void update(Observable o, Object arg) {

    }

    @Override
    public void handleEvent(MachineEvent event) {
        if(event instanceof EventMovieOn)
            handleMovieOnEvent() ;
        else if(event instanceof EventHoldMovie)
            handleMoviePauseEvent();
        else if(event instanceof EventMovieRestart)
            handleMovieRestartEvent();
        else if(event instanceof EventResume)
            handleMovieResumeEvent();
        else if(event instanceof EventDownloadError)
            handleDownloadErrorEvent();
        else if(event instanceof EventMovieOff)
            handleMovieOffEvent();
    }


    private void handleMovieOnEvent() {
        if(!(currentState instanceof ViewerStateIDle))
            return ;

        moviePlaying = new ViewerStatePlay();
        changeState(moviePlaying);

    }

    private void handleMoviePauseEvent() {
        if(!(currentState instanceof ViewerStatePlay))
            return;

        changeState(new ViewerStatePause());
    }


    private void handleMovieRestartEvent() {
        if(!(currentState instanceof ViewerStatePlay))
            return;

        ((ViewerStatePlay)currentState).setTimeInMovie(0);
    }

    private void handleMovieResumeEvent () {
        if(!(currentState instanceof ViewerStatePause))
            return;

        changeState(this.moviePlaying);
    }


    private void handleDownloadErrorEvent() {
        if(!(currentState instanceof ViewerStatePlay))
            return;

        changeState(new ViewerStatePause());
    }


    private void handleMovieOffEvent() {
        changeState(new ViewerStateIDle());
    }




}
