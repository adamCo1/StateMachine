package MovieDownloader;

import Connections.Connections;

import MachineStateInterface.MachineState;

import java.util.Observable;
import java.util.Observer;

public class AMovieDownloader implements Observer , MachineState {

    private MachineState currentState ;
    private boolean hasInternetConnection ;

    public AMovieDownloader(){
        this.currentState = new DownloaderStateIdle();
        enterState();
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof Connections){
            this.hasInternetConnection = ((Connections)o).getConnectionState();
        }
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
