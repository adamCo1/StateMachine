package Machine;

import MachineStateInterface.MachineState;

import java.util.ArrayList;

public class MachineStateOn implements MachineState {

    private final String NAME = "machineOn state" ;
    private ArrayList<MachineState> states ;

    public MachineStateOn(ArrayList<MachineState> states){
        this.states = new ArrayList<>();
        this.states.addAll(states) ;
    }

    @Override
    public void enterState() {
        System.out.println("entered " + NAME);
    }

    @Override
    public void exitState() {
        System.out.println("entered " + NAME);
    }

    @Override
    public void runState() {

        for (MachineState state :
                    this.states)
            state.runState();
    }
}
