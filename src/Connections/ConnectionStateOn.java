package Connections;

import MachineStateInterface.MachineState;

public class ConnectionStateOn implements MachineState , ConnectionState {

    private final boolean HAS_CONNECTION = true ;
    private final String NAME = "connectionOn state";

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
