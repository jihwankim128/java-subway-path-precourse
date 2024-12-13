package subway.domain.station.line;

import java.util.Objects;

public class Line {

    private final String name;

    public Line(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Line line = (Line) object;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
