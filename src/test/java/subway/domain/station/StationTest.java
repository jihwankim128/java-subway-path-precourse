package subway.domain.station;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import subway.exception.ExceptionMessage;

class StationTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 역_이름은_null_이거나_공백일_수_없다(String name) {
        // given
        // when
        assertThatThrownBy(() -> new Station(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionMessage.INVALID_INPUT_DATA.getMessage());
    }

    @Test
    void 역_이름이_같으면_같은_역이다() {
        // given
        Station stationA = new Station("A");
        Station stationB = new Station("A");

        // when
        boolean equals = stationA.equals(stationB);

        // then
        assertThat(equals).isTrue();
    }

    @Test
    void 역_이름이_다르면_다른_역이다() {
        // given
        Station stationA = new Station("A");
        Station stationB = new Station("B");

        // when
        boolean equals = stationA.equals(stationB);

        // then
        assertThat(equals).isFalse();
    }

}