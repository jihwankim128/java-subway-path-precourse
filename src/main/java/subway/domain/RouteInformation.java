package subway.domain;

import static subway.domain.station.StationInformation.SECOND_LINE_GANGNAM;
import static subway.domain.station.StationInformation.SECOND_LINE_GYODAE;
import static subway.domain.station.StationInformation.SECOND_LINE_YEOKSAM;
import static subway.domain.station.StationInformation.SIBUNDANG_CITIZEN_FOREST;
import static subway.domain.station.StationInformation.SINBUNDANG_GANGNAM;
import static subway.domain.station.StationInformation.SINBUNDANG_YANGJAE;
import static subway.domain.station.StationInformation.THIRD_LINE_GYODAE;
import static subway.domain.station.StationInformation.THIRD_LINE_MAEBONG;
import static subway.domain.station.StationInformation.THIRD_LINE_NAMBU;
import static subway.domain.station.StationInformation.THIRD_LINE_YANGJAE;

import java.util.Arrays;
import subway.domain.station.Station;
import subway.domain.station.StationInformation;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

public enum RouteInformation {

    GYOADE_TO_GANGNAM(SECOND_LINE_GYODAE, SECOND_LINE_GANGNAM, 2, 3),
    GANGNAM_TO_YEOKSAM(SECOND_LINE_GANGNAM, SECOND_LINE_YEOKSAM, 2, 3),
    GYOADE_TO_NAMBU(THIRD_LINE_GYODAE, THIRD_LINE_NAMBU, 3, 2),
    NAMBU_TO_YANGJAE(THIRD_LINE_NAMBU, THIRD_LINE_YANGJAE, 6, 5),
    YANGJAE_TO_MAEBONG(THIRD_LINE_YANGJAE, THIRD_LINE_MAEBONG, 1, 1),
    GANGNAM_TO_YANGJAE(SINBUNDANG_GANGNAM, SINBUNDANG_YANGJAE, 2, 8),
    YANGJAE_TO_CITIZEN_FOREST(SINBUNDANG_YANGJAE, SIBUNDANG_CITIZEN_FOREST, 10, 3),
    ;

    private final StationInformation stationA;
    private final StationInformation stationB;
    private final int kilometer;
    private final int minute;


    RouteInformation(StationInformation stationA, StationInformation stationB, int kilometer, int minute) {
        this.stationA = stationA;
        this.stationB = stationB;
        this.kilometer = kilometer;
        this.minute = minute;
    }

    public static RouteInformation of(final Station stationA, final Station stationB) {
        return Arrays.stream(values())
                .filter(route -> hasPath(stationA, stationB, route))
                .findFirst()
                .orElseThrow(() -> new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA));
    }

    private static boolean hasPath(final Station stationA, final Station stationB, final RouteInformation route) {
        return (route.getStationA().getStationName().equals(stationA.getName()) &&
                route.getStationB().getStationName().equals(stationB.getName())) ||
                (route.getStationB().getStationName().equals(stationA.getName()) &&
                        route.getStationA().getStationName().equals(stationB.getName()));
    }

    public StationInformation getStationA() {
        return stationA;
    }

    public StationInformation getStationB() {
        return stationB;
    }

    public int getKilometer() {
        return kilometer;
    }

    public int getMinute() {
        return minute;
    }

}
