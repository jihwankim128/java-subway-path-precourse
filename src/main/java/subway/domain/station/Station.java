package subway.domain.station;

import java.util.Objects;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

public class Station {

    private final String name;

    public Station(final String name) {
        validateStationNameNullOrEmpty(name);
        this.name = name;
    }

    private void validateStationNameNullOrEmpty(final String name) {
        if (name == null || name.isEmpty()) {
            throw new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Station station = (Station) object;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

}
