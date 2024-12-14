package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class Graph {

    private final WeightedMultigraph<Station, DefaultWeightedEdge> graph;

    public Graph() {
        this.graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
    }

    public DijkstraShortestPath<Station, DefaultWeightedEdge> extractShortestTime() {
        for (final Station station : StationRepository.stations()) {
            graph.addVertex(station);
        }
        connectGraphEdgesByTime();

        return new DijkstraShortestPath<>(graph);
    }

    public DijkstraShortestPath<Station, DefaultWeightedEdge> extractShortestPath() {
        for (final Station station : StationRepository.stations()) {
            graph.addVertex(station);
        }
        connectGraphEdgesByDistance();

        return new DijkstraShortestPath<>(graph);
    }

    private void connectGraphEdgesByDistance() {
        for (final RouteInformation value : RouteInformation.values()) {
            final Station stationA = StationRepository.getStation(value.getStationA());
            final Station stationB = StationRepository.getStation(value.getStationB());
            graph.setEdgeWeight(graph.addEdge(stationA, stationB), value.getKilometer());
        }
    }

    private void connectGraphEdgesByTime() {
        for (final RouteInformation value : RouteInformation.values()) {
            final Station stationA = StationRepository.getStation(value.getStationA());
            final Station stationB = StationRepository.getStation(value.getStationB());
            graph.setEdgeWeight(graph.addEdge(stationA, stationB), value.getMinute());
        }
    }

}
