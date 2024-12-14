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
        if (exceptionHandler.retry(view::enterMainFeature) == MainInputType.SHOW_PATH) {
            // 작업
            run();
        }
    }

}
