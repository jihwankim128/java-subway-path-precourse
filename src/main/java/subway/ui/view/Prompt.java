package subway.ui.view;

import java.util.List;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

public interface Prompt {

    String readInputData();

    List<String> parseInputData();

    default void validateNotNullOrNotEmpty(final String data) {
        if (data == null || data.isEmpty()) {
            throw new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA);
        }
    }

}