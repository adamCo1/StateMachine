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
    }

    private static void runMachine(){

    }

}
