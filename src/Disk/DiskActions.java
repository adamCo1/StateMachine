package Disk;

public interface DiskActions {

    boolean checkForFreeSpace(double fileSize) ;
    void deleteFile(double fileSize);
    void placeFile(double fileSize);
}
