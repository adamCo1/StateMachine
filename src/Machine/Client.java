package Machine;

import Connections.Connections;
import Events.EventMovieOn;
import Events.EventMoviePause;
import Events.MachineEvent;
import MachineStateInterface.MachineState;
import MovieDownloader.AMovieDownloader;
import MovieViewer.AMovieViewer;
import MovieViewer.MovieViewerState;
import User.User;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {

        ArrayList<MachineState> machine = new ArrayList<>();

        MachineState user = new User();
        MachineState movieViewer = new AMovieViewer();
        MachineState movieDownloader = new AMovieDownloader();
        MachineState connections = new Connections();

        machine.add(connections);
        machine.add(user);
        machine.add(movieDownloader);
        machine.add(movieViewer);

        Machine stateMachine = new Machine(machine);

        try {
            Thread machineThread = new Thread(() -> runMachine(stateMachine));
            machineThread.start();

            Thread clientThread = new Thread(() -> runClient(machine));
            clientThread.start();

            clientThread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void runClient(ArrayList<MachineState> states){

        long t1,t2 = 0 ;

        t1 = System.currentTimeMillis();
        t2 = t1 ;
        while(t2 - t1 < 3000){
            t2 = System.currentTimeMillis();

        }

        ((Connections)states.get(0)).switchToOnState();

        t1 = System.currentTimeMillis();
        t2 = t1;
        while(t2-t1 < 2000){
            t2 = System.currentTimeMillis();
        }

        EventMovieOn movieOn = new MachineEvent() ;
        ((AMovieViewer)states.get(3)).handleMovieOnEvent(movieOn);

        t1 = System.currentTimeMillis();
        t2 = t1;
        while(t2-t1 < 4000){
            t2 = System.currentTimeMillis();
        }

        EventMoviePause moviePause = new MachineEvent() ;
        ((AMovieViewer)states.get(3)).handleMoviePauseEvent(moviePause);

    }


    private static void runMachine(Machine stateMachine){

        final int TICK_PERIOD = 1000 ;
        boolean ticked = false;
        long t1 = 0 , t2 ;

        while(true){
            if(ticked) {
                t1 = System.currentTimeMillis();
                ticked = false ;
            }

            t2 = System.currentTimeMillis();

            if(t2 - t1 >= TICK_PERIOD){//tick
                stateMachine.runState();
                ticked = true ;
            }

        }

    }

}
