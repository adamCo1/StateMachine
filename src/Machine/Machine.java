package Machine;

import MachineStateInterface.MachineState;

public class Machine implements MachineState {

    private MachineState currentState ;

    public Machine(){
        this.currentState = (MachineState) new MachineStateOff() ;
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
