package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.exception.BadArgumentException;
import subway.exception.ExceptionMessage;

public class Route {

    private final Station startStation;
    private final Station endStation;
    private final DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstra;

    public Route(
            final Station startStation,
            final Station endStation,
            final DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstra
    ) {
        validateRoute(startStation, endStation);
        this.startStation = startStation;
        this.endStation = endStation;
        this.dijkstra = dijkstra;
    }

    private static void validateRoute(final Station startStation, final Station endStation) {
        validateNotSameStation(startStation, endStation);
        validateNotExistStation(startStation);
        validateNotExistStation(endStation);
    }

    private static void validateNotExistStation(Station startStation) {
        if (StationRepository.doesNotExistStation(startStation)) {
            throw new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA);
        }
    }

    private static void validateNotSameStation(Station startStation, Station endStation) {
        if (startStation.equals(endStation)) {
            throw new BadArgumentException(ExceptionMessage.SAME_STATION);
        }
    }

    public List<Station> getShortestPath() {
        try {
            return dijkstra.getPath(startStation, endStation).getVertexList();
        } catch (NullPointerException e) {
            throw new BadArgumentException(ExceptionMessage.INVALID_INPUT_DATA);
        }
    }

    public int getShortestTime() {
        final List<Station> shortestPath = getShortestPath();
        int minute = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            RouteInformation route = RouteInformation.of(shortestPath.get(i), shortestPath.get(i + 1));
            minute += route.getMinute();
        }
        return minute;
    }

    public int getShortestDistance() {
        final List<Station> shortestPath = getShortestPath();
        int distance = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            RouteInformation route = RouteInformation.of(shortestPath.get(i), shortestPath.get(i + 1));
            distance += route.getKilometer();
        }
        return distance;
    }

}
