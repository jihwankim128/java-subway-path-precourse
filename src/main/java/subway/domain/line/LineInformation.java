package subway.domain.line;

public enum LineInformation {

    SECOND_LINE("2호선"),
    THIRD_LINE("3호선"),
    SINBUNDANG("신분당선"),
    ;

    private final String lineName;

    LineInformation(String lineName) {
        this.lineName = lineName;
    }

    public String getLineName() {
        return lineName;
    }

}
