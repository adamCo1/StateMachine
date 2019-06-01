package MovieViewer;

import MachineStateInterface.MachineState;

public class ViewerStatePlay implements MachineState {

    private final String NAME = "moviePlay state" ;
    private int timeInMovie , playSpeed  ;

    public ViewerStatePlay(){
        this.timeInMovie = 0 ;
        this.playSpeed = 1 ;
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
        timeInMovie += playSpeed ;
    }

    public void setTimeInMovie(int time){
        this.timeInMovie = time ;
    }

}
