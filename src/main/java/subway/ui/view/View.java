package subway.ui.view;

import subway.ui.MainFeatureType;
import subway.ui.SearchFeatureType;

public class View extends OutputView {

    private final Prompt prompt;

    public View(final Prompt prompt) {
        this.prompt = prompt;
    }

    public MainFeatureType enterMainFeature() {
        displayMainFeatureType();
        displayWantedFeature();
        return MainFeatureType.from(prompt.readInputData());
    }

    public SearchFeatureType enterSearchFeatureType() {
        displaySearchFeatureType();
        displayWantedFeature();
        return SearchFeatureType.from(prompt.readInputData());
    }

    public String enterStartStation() {
        displayStartStation();
        return prompt.readInputData();
    }

    public String enterEndStation() {
        displayEndStation();
        return prompt.readInputData();
    }

}
