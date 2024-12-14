package subway.domain;

import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

public class Route {

    private final Station startStation;
    private final Station endStation;

    public Route(final Station startStation, final Station endStation) {
        validateRoute(startStation, endStation);
        this.startStation = startStation;
        this.endStation = endStation;
    }

    private static void validateRoute(final Station startStation, final Station endStation) {
        validateNotSameStation(startStation, endStation);
        validateNotExistStation(startStation);
        validateNotExistStation(endStation);
    }

    private static void validateNotExistStation(Station startStation) {
        if (StationRepository.doesNotExistStation(startStation)) {
            throw new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA);
        }
    }

    private static void validateNotSameStation(Station startStation, Station endStation) {
        if (startStation.equals(endStation)) {
            throw new BadArgumentException(ExceptionMessage.SAME_STATION);
        }
    }

}
