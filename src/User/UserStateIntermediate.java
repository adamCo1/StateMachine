package User;

import MachineStateInterface.MachineState;

public class UserStateIntermediate implements UserState , MachineState {

    private final double DOWNLOAD_SPEED = 1.2 ;
    private final String NAME = "intermediate state" ;


    @Override
    public double getUserDownloadSpeed() {
        return this.DOWNLOAD_SPEED ;
    }

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
