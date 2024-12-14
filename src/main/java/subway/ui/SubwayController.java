package subway.ui;

import subway.application.SearchResponse;
import subway.domain.Graph;
import subway.domain.Route;
import subway.domain.station.Station;
import subway.ui.view.View;

public class SubwayController {

    private final View view;
    private final ExceptionHandler exceptionHandler;

    public SubwayController(final View view, final ExceptionHandler exceptionHandler) {
        this.view = view;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
        if (exceptionHandler.retry(view::enterMainFeature) == MainFeatureType.PATH_SEARCH) {
            processPathSearch();
            run();
        }
    }

    private void processPathSearch() {
        final SearchFeatureType searchFeatureType = exceptionHandler.retry(view::enterSearchFeatureType);
        if (searchFeatureType == SearchFeatureType.SHORTEST_PATH) {
            view.displaySearchResult(processShortestDistanceSearch());
        }
        if (searchFeatureType == SearchFeatureType.SHORTEST_TIME) {
            view.displaySearchResult(processShortestTimeSearch());
        }
    }

    private SearchResponse processShortestTimeSearch() {
        final Route route = exceptionHandler.retry(this::extractShortestTimeRoute);
        return SearchResponse.of(
                route.getShortestDistance(),
                route.getShortestTime(),
                route.getShortestPath()
        );
    }

    private SearchResponse processShortestDistanceSearch() {
        final Route route = exceptionHandler.retry(this::extractShortestPathRoute);
        return SearchResponse.of(
                route.getShortestDistance(),
                route.getShortestTime(),
                route.getShortestPath()
        );
    }

    private Route extractShortestTimeRoute() {
        return new Route(
                new Station(view.enterStartStation()),
                new Station(view.enterEndStation()),
                new Graph().extractShortestTime()
        );
    }

    private Route extractShortestPathRoute() {
        return new Route(
                new Station(view.enterStartStation()),
                new Station(view.enterEndStation()),
                new Graph().extractShortestPath()
        );
    }

}
