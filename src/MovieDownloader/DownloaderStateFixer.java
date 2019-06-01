package MovieDownloader;

import MachineStateInterface.MachineState;

public class DownloaderStateFixer implements MovieDownloaderState , MachineState {

    private final String NAME = "fixer state" ;


    @Override
    public void enterState() {
        System.out.println("entered " + NAME) ;
    }

    @Override
    public void runState() {

    }

    @Override
    public void exitState() {
        System.out.println("exited " + NAME) ;
    }
}
