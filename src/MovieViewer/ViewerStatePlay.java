package MovieViewer;

import MachineStateInterface.MachineState;

public class ViewerStatePlay implements MachineState {

    private final String NAME = "moviePlay state" ;
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
