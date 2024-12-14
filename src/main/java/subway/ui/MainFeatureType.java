package subway.ui;

import java.util.Arrays;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

public enum MainFeatureType {

    PATH_SEARCH("1"),
    EXIT("Q"),
    ;

    private final String input;

    MainFeatureType(String input) {
        this.input = input;
    }

    public static MainFeatureType from(final String input) {
        return Arrays.stream(values())
                .filter(item -> item.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA));
    }

}
