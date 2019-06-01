package Connections;

import MachineStateInterface.MachineState;

import java.util.Observable;

public class Connections extends Observable implements MachineState , ConnectionActions {

    private MachineState currentState ;

    public Connections(){
        super();
        this.currentState = new ConnectionStateOff() ;
        enterState();
    }

    public boolean getConnectionState(){
        return ((ConnectionState)currentState).getConnectionState();
    }

    private void changeConnectionState(MachineState connectionState){

        if(!(connectionState instanceof ConnectionState))
            return ;

        exitState();
        currentState = connectionState ;
        enterState();
        notifyObservers();
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

    }

    @Override
    public void switchToOffState() {
        changeConnectionState(new ConnectionStateOff());
    }

    @Override
    public void switchToOnState() {
        changeConnectionState(new ConnectionStateOn());
    }
}
