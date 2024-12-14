package subway.domain.station;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class StationRepositoryTest {

    @Test
    void 초기_역_정보가_불러와지는지_확인() {
        List<Station> result = StationRepository.stations();
        assertThat(result).hasSize(7);
    }

}