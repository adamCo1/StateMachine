package Disk;

import MachineStateInterface.MachineState;

/**
 * singleton for disk
 */

public class Disk implements MachineState , DiskActions{

    private static Disk disk = new Disk();
    private static double freeSpace = 100 ;
    private final String NAME = "diskRunning state" ;

    private Disk(){

    }

    public static Disk getInstance(){
        return disk ;
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

    @Override
    public boolean checkForFreeSpace(double fileSize) {
        return this.freeSpace <= fileSize ;
    }

    @Override
    public void deleteFile(double fileSize) {
        this.freeSpace += fileSize ;
    }

    @Override
    public void placeFile(double fileSize) {
        this.freeSpace -= fileSize ;
    }
}
