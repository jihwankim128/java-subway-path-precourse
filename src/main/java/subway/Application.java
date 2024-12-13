package subway;

import java.util.Scanner;
import subway.domain.station.line.LineRepository;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println(LineRepository.lines());
    }
}
