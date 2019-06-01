package User;

import MachineStateInterface.MachineState;

public class User implements MachineState{

    private MachineState currentUserState ;
    private int points ;
    private final int DOWN_TO_BEGINNER = 3 , DOWN_TO_INTERMEDIATE = 6 ;
    private final int UP_TO_INTERMEDIATE = 4 , UP_TO_PRO = 7;

    public User(){
        this.currentUserState =(MachineState) new UserStateBeginner() ;
        this.points = 0 ;
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
            exitCurrentState();
            changeState(new UserStateBeginner()) ;
        }
        else if(points == DOWN_TO_INTERMEDIATE){
            exitCurrentState();
            changeState(new UserStateIntermediate());
        }

    }

    public void upgradeUser(){
        if(points == UP_TO_INTERMEDIATE){
            exitCurrentState();
            changeState(new UserStateIntermediate());
        }else if(points == UP_TO_PRO){
            exitCurrentState();
            changeState(new UserStateProfessional());
        }
    }

    private void changeState(UserState state){
         this.currentUserState = (MachineState) state ;
    }

    private void exitCurrentState(){
        this.currentUserState.exitState();
    }

    public int getPoints(){
        return this.points ;
    }

    @Override
    public void enterState() {

    }

    @Override
    public void exitState() {

    }

    @Override
    public void runState() {

    }
}
