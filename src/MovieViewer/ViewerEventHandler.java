package MovieViewer;

import Events.*;

public interface ViewerEventHandler {
    /**
    void handleMovieOnEvent(EventMovieOn event);
    void handleMoviePauseEvent(EventHoldMovie event);
    void handleMovieIdleEvent(EventMovieIdle event);
    void handleMovieRestartEvent(EventMovieRestart event);
    void handleMovieResumeEvent(EventResume event);
    void handleDownloadErrorEvent(EventDownloadError event);
    void handleMovieOffEvent(EventMovieOff event);
     */

    void handleEvent(MachineEvent event);
}
