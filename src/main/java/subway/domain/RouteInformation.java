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

import subway.domain.station.StationInformation;

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
    private final StationInformation stationNameB;
    private final int kilometer;
    private final int minute;


    RouteInformation(StationInformation stationA, StationInformation stationNameB, int kilometer, int minute) {
        this.stationA = stationA;
        this.stationNameB = stationNameB;
        this.kilometer = kilometer;
        this.minute = minute;
    }

    public StationInformation getStationA() {
        return stationA;
    }

    public StationInformation getStationNameB() {
        return stationNameB;
    }

    public int getKilometer() {
        return kilometer;
    }

    public int getMinute() {
        return minute;
    }

}
