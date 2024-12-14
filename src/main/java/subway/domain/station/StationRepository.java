package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.line.LineRepository;
import subway.exception.ExceptionMessage;
import subway.exception.InitializeException;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    static {
        for (final StationInformation stationInformation : StationInformation.values()) {
            validateContainLine(stationInformation.getLineName());
            addNotDuplicateStation(new Station(stationInformation.getStationName()));
        }
    }

    private static void validateContainLine(final String lineName) {
        if (LineRepository.hasNotContainLineName(lineName)) {
            throw new InitializeException(ExceptionMessage.INITIALIZE_FAIL);
        }
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    private static void addNotDuplicateStation(final Station station) {
        if (doesNotExistStation(station)) {
            addStation(station);
        }
    }

    public static boolean doesNotExistStation(final Station station) {
        return !stations.contains(station);
    }

}
