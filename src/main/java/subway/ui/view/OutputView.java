package subway.ui.view;

public class OutputView {

    private final StringBuilder stringBuilder = new StringBuilder();

    protected OutputView() {}

    private void clear() {
        System.out.print(stringBuilder);
        stringBuilder.setLength(0);
    }

    public void displayErrorMessage(final String message) {
        System.out.println(message);
        System.out.println();
    }

    protected void displayMainFeatureType() {
        stringBuilder.append("## 메인화면\n").append("1. 경로 조회\n").append("Q. 종료\n").append("\n");
        clear();
    }

    protected void displayWantedFeature() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    protected void displaySearchFeatureType() {
        stringBuilder.append("## 경로 기준\n")
                .append("1. 최단 거리\n")
                .append("2. 최소 시간\n")
                .append("B. 돌아가기\n")
                .append("\n");
        clear();
    }

    protected void displayStartStation() {
        System.out.println("## 출발역을 입력하세요.");
    }

    protected void displayEndStation() {
        System.out.println("## 도착역을 입력하세요.");
    }

}