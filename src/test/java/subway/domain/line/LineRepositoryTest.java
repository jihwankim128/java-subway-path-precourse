package subway.domain.line;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LineRepositoryTest {

    @Test
    void 초기_라인_정보가_불러와지는지_확인() {
        List<Line> lines = LineRepository.lines();
        assertThat(lines).hasSize(3);
    }

    @Test
    void 호선이_포함되어있는지_학인() {
        boolean result = LineRepository.hasNotContainLineName("2호선");
        assertThat(result).isFalse();
    }

    @Test
    void 호선이_포함되어있지_않은지_학인() {
        boolean result = LineRepository.hasNotContainLineName("4호선");
        assertThat(result).isTrue();
    }

}