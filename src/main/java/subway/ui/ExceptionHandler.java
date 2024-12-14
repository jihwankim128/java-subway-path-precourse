package subway.ui;

import java.util.function.Supplier;
import subway.ui.view.View;

public class ExceptionHandler {

    private final View view;

    public ExceptionHandler(final View view) {
        this.view = view;
    }

    public <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (final IllegalArgumentException e) {
                view.displayErrorMessage(e.getMessage());
            }
        }
    }

}
