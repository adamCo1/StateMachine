package User;

import MachineStateInterface.MachineState;

public class User implements MachineState{

    private MachineState currentUserState ;
    private int points ;
    private double downloadSpeed ;
    private final int DOWN_TO_BEGINNER = 3 , DOWN_TO_INTERMEDIATE = 6 ;
    private final int UP_TO_INTERMEDIATE = 4 , UP_TO_PRO = 7;

    public User(){
        this.currentUserState =(MachineState) new UserStateBeginner() ;
        this.points = 0 ;
        this.downloadSpeed = ((UserState)currentUserState).getUserDownloadSpeed();
    }

    public double getUserDownloadSpeed(){
        return ((UserState)currentUserState).getUserDownloadSpeed() ;
    }

    public void addPoint(){
        points++ ;
        if(points == UP_TO_PRO || points == UP_TO_INTERMEDIATE)
            upgradeUser();
    }

    public void decrementPoint(){
        if(points == 1)
            return;

        points --;

        if(points == DOWN_TO_BEGINNER || points == DOWN_TO_INTERMEDIATE)
            downgradeUser();
    }

    public void downgradeUser(){
        if(points == DOWN_TO_BEGINNER){
            exitState();
            changeState(new UserStateBeginner());
            enterState();
        }
        else if(points == DOWN_TO_INTERMEDIATE){
            exitState();
            changeState(new UserStateIntermediate());
            enterState();
        }

    }

    public void upgradeUser(){
        if(points == UP_TO_INTERMEDIATE){
            exitState();
            changeState(new UserStateIntermediate());
            enterState();
        }else if(points == UP_TO_PRO){
            exitState();
            changeState(new UserStateProfessional());
            enterState();
        }
    }

    private void changeState(UserState state){
         this.currentUserState = (MachineState) state;

    }


    public int getPoints(){
        return this.points ;
    }

    @Override
    public void enterState() {
        currentUserState.enterState();
    }

    @Override
    public void exitState() {
        currentUserState.exitState();
    }

    @Override
    public void runState() {

    }
}
