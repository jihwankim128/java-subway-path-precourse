package subway.ui.view;

import subway.ui.MainInputType;

public class View extends OutputView {

    private final Prompt prompt;

    public View(final Prompt prompt) {
        this.prompt = prompt;
    }

    public MainInputType enterMainFeature() {
        displayMainFeature();
        displayWantedFeature();
        return MainInputType.from(prompt.readInputData());
    }
}
