package subway.application;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.station.Station;

public class SearchResponse {

    private final int totalDistance;
    private final int totalTime;
    private final List<String> stationNames;

    public SearchResponse(final int totalDistance, final int totalTime, final List<String> stationNames) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.stationNames = stationNames;
    }

    public static SearchResponse of(final int totalDistance, final int totalTime, final List<Station> stations) {
        return new SearchResponse(
                totalDistance,
                totalTime,
                convertStationToStationName(stations)
        );
    }

    private static List<String> convertStationToStationName(final List<Station> stations) {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public List<String> getStationNames() {
        return stationNames;
    }

}
