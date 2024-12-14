package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static final List<Line> lines = new ArrayList<>();

    static {
        for (final LineInformation lineInformation: LineInformation.values()) {
            addLine(new Line(lineInformation.getLineName()));
        }
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }
    
    public static boolean hasNotContainLineName(final String lineName) {
        return lines.stream()
                .noneMatch(line -> Objects.equals(line.getName(), lineName));
    }

}
