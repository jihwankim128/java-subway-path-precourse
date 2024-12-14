package subway.ui;

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
            processShortestDistanceSearch();
        }
        if (searchFeatureType == SearchFeatureType.SHORTEST_TIME) {
            processShortestTimeSearch();
        }
    }

    private void processShortestTimeSearch() {
        System.out.println("최소 시간 조회입니다.\n");
    }

    private void processShortestDistanceSearch() {
        System.out.println("최단 경로 조회입니다.\n");
    }

}
