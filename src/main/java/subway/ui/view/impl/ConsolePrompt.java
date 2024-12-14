package subway.ui.view.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import subway.ui.view.Prompt;

public class ConsolePrompt implements Prompt {

    private static final String PARSING_DELIMITER = ",";

    private final Scanner console;

    public ConsolePrompt(final Scanner console) {
        this.console = console;
    }

    @Override
    public String readInputData() {
        final String inputData = console.nextLine();
        validateNotNullOrNotEmpty(inputData);
        System.out.println();

        return inputData;
    }

    @Override
    public List<String> parseInputData() {
        return Arrays.stream(readInputData()
                .split(PARSING_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

}

