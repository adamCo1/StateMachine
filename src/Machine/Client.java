package Machine;

import Connections.Connections;
import MachineStateInterface.MachineState;
import MovieDownloader.AMovieDownloader;
import MovieViewer.AMovieViewer;
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
            machineThread.run();

            Thread clientThread = new Thread(() -> runClient());
            clientThread.run();

            clientThread.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private static void runClient(){

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
