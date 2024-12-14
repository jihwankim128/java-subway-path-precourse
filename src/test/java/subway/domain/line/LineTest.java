package subway.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void 호선은_이름을_갖는다() {
        // given
        String lineName = "2호선";

        // when
        Line line = new Line(lineName);

        // then
        assertThat(line.getName()).isEqualTo(lineName);
    }

    @Test
    void 호선은_이름이_같다면_동일한_호선이다() {
        // givne
        Line line1 = new Line("2호선");
        Line line2 = new Line("2호선");

        // when
        boolean equals = line1.equals(line2);

        // then
        assertThat(equals).isTrue();
    }

}