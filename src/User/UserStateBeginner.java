package User;

import MachineStateInterface.MachineState;

public class UserStateBeginner implements UserState , MachineState {

    private final double DOWNLOAD_SPEED = 1 ;
    private final String NAME = "beginner state" ;


    @Override
    public double getUserDownloadSpeed() {
        return this.DOWNLOAD_SPEED ;
    }

    @Override
    public void enterState() {
        System.out.println("entered " + NAME);
    }

    @Override
    public void exitState(){
        System.out.println("exited " + NAME);
    }

    @Override
    public void runState() {

    }
}
