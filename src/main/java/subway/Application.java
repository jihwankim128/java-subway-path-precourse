package subway;

import java.util.Scanner;
import subway.ui.ExceptionHandler;
import subway.ui.SubwayController;
import subway.ui.view.Prompt;
import subway.ui.view.View;
import subway.ui.view.impl.ConsolePrompt;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Prompt prompt = new ConsolePrompt(scanner);
        final View view = new View(prompt);
        final ExceptionHandler exceptionHandler = new ExceptionHandler(view);

        new SubwayController(view, exceptionHandler).run();
        scanner.close();
    }

}
