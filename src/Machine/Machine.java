package Machine;

import MachineStateInterface.MachineState;

import java.util.ArrayList;

public class Machine implements MachineState {

    private MachineState currentState ;
    private ArrayList<MachineState> states;

    public Machine(ArrayList<MachineState> states){
        this.currentState = new MachineStateOff();

        this.states = new ArrayList<>(states);

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
}
