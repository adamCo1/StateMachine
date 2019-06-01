package Connections;

import MachineStateInterface.MachineState;

public class ConnectionStateOff implements MachineState , ConnectionState {

    private final boolean HAS_CONNECTION = false ;
    private final String NAME = "connectionOff state";

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

    @Override
    public boolean getConnectionState() {
        return this.HAS_CONNECTION;
    }
}
