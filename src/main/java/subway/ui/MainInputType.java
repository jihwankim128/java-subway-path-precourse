package subway.ui;

import java.util.Arrays;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

public enum MainInputType {

    SHOW_PATH("1"),
    EXIT("Q"),
    ;

    private final String input;

    MainInputType(String input) {
        this.input = input;
    }

    public static MainInputType from(final String input) {
        return Arrays.stream(values())
                .filter(item -> item.input.equals(input))
                .findFirst()
                .orElseThrow(() -> new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA));
    }

}
