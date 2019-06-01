package MovieDownloader;

import MachineStateInterface.MachineState;

public class MovieDownloaderDownload implements MovieDownloaderState , MachineState {

    private MachineState currentState ;

    public MovieDownloaderDownload(){
        this.currentState = new DownloaderStateDownloadOn();
    }


    @Override
    public void enterState(){
        this.currentState.enterState();
    }

    @Override
    public void runState() {
        this.currentState.runState();
    }

    @Override
    public void exitState(){
        this.currentState.exitState();
    }

}
