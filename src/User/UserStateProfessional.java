package User;

import MachineStateInterface.MachineState;

public class UserStateProfessional implements UserState , MachineState {

    private final double DOWNLOAD_SPEED = 1.5;
    private final String NAME = "professional state";

    public UserStateProfessional(){
        System.out.println("entered professional state");
    }

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
        System.out.println("exited " + NAME );
    }

    @Override
    public void runState() {

    }
}
