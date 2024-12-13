package subway.domain.station;

public enum StationInformation {

    SECOND_LINE_GYODAE("2호선", "교대역"),
    SECOND_LINE_GANGNAM("2호선", "강남역"),
    SECOND_LINE_YEOKSAM("2호선", "역삼역"),
    THIRD_LINE_GYODAE("3호선", "교대역"),
    THIRD_LINE_NAMBU("3호선", "남부역"),
    THIRD_LINE_YANGJAE("3호선", "양재역"),
    THIRD_LINE_MAEBONG("3호선", "매봉역"),
    SINBUNDANG_GANGNAM("신분당선", "강남역"),
    SINBUNDANG_YANGJAE("신분당선", "양재역"),
    SIBUNDANG_CITIZEN_FOREST("신분당선", "양재시민의숲역"),
    ;

    private final String lineName;
    private final String stationName;

    StationInformation(String lineName, String stationName) {
        this.lineName = lineName;
        this.stationName = stationName;
    }

    public String getLineName() {
        return lineName;
    }

    public String getStationName() {
        return stationName;
    }

}
