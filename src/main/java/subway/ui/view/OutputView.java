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
    }

    protected void displayMainFeature() {
        stringBuilder.append("## 메인화면\n").append("1. 경로 조회\n").append("Q. 종료\n").append("\n");
        clear();
    }

    protected void displayWantedFeature() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

}