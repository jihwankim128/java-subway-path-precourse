package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.station.line.LineRepository;
import subway.exception.ExceptionMessage;
import subway.exception.InitializeException;

public class StationRepository {

    private static final List<Station> stations = new ArrayList<>();

    static {
        for (final StationInformation stationInformation : StationInformation.values()) {
            if (LineRepository.hasNotContainLineName(stationInformation.getLineName())) {
                throw new InitializeException(ExceptionMessage.INITIALIZE_FAIL);
            }
            addStation(new Station(stationInformation.getStationName(), stationInformation.getLineName()));
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
}
