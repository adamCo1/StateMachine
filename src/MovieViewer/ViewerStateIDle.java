package MovieViewer;

import MachineStateInterface.MachineState;

public class ViewerStateIDle implements MachineState {

    private final String NAME = "MovieViewer idle state" ;

    @Override
    public void enterState() {
        System.out.println("entered " + NAME);
    }

    @Override
    public void exitState() {
        System.out.println("exited " + NAME);
    }

    @Override
    public void runState() {

    }
}
