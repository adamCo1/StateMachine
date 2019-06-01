package MovieViewer;

import Events.EventMovieIdle;
import Events.EventMovieOn;
import Events.EventMoviePause;

public interface ViewerEventHandler {

    void handleMovieOnEvent(EventMovieOn event);
    void handleMoviePauseEvent(EventMoviePause event);
    void handleMovieIdleEvent(EventMovieIdle event);
}
