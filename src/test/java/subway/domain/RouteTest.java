package subway.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import subway.domain.station.Station;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

class RouteTest {

    @Test
    void 출발역과_도착역이_동일하면_예외가_발생한다() {
        // given
        Station startStation = new Station("출발역");
        Station endStation = new Station("출발역");

        // when & then
        assertThatThrownBy(() -> new Route(startStation, endStation))
                .isInstanceOf(BadArgumentException.class)
                .hasMessageContaining(ExceptionMessage.SAME_STATION.getMessage());
    }

    @Test
    void 없는_역_정보로_경로를_생성할_경우_예외가_발생한다() {
        // given, StationRepository
        Station startStation = new Station("출발역");
        Station endStation = new Station("도착역");

        // when & then
        assertThatThrownBy(() -> new Route(startStation, endStation))
                .isInstanceOf(BadArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_DATA.getMessage());
    }

}