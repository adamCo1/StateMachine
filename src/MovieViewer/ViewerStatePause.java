package MovieViewer;

import MachineStateInterface.MachineState;

public class ViewerStatePause implements MachineState {

    private final String NAME = "moviePause state";

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
