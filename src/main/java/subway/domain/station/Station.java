package subway.domain.station;

import subway.domain.station.line.Line;

public class Station {

    private final String name;
    private Line line;

    public Station(final String name, final String lineName) {
        this.name = name;
        this.line = new Line(lineName);
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
