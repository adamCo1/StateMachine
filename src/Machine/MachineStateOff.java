package Machine;

import MachineStateInterface.MachineState;

public class MachineStateOff implements MachineState {

    private final String NAME = "machineOff state" ;

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
