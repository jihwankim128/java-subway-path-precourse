package subway.ui;

import java.util.Arrays;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

public enum SearchFeatureType {

    SHORTEST_PATH("1"),
    SHORTEST_TIME("2"),
    BACK("B"),
    ;

    private final String input;

    SearchFeatureType(String input) {
        this.input = input;
    }

    public static SearchFeatureType from(final String input) {
        return Arrays.stream(values())
                .filter(item -> item.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA));
    }

}
