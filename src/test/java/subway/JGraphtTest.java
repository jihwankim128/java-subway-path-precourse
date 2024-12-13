package subway;

import org.assertj.core.api.Assertions;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();

        assertThat(shortestPath.size()).isEqualTo(3);
    }

    @Test
    void 연결되어있지_않은_간선_정보로_경로를_구하면_예외가_발생한다() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");  graph.addVertex("v2"); graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 2);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        Assertions.assertThatThrownBy(() -> dijkstraShortestPath.getPath("v2", "v3").getVertexList())
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void 없는_정점_번호로_간선을_만들_경우_예외가_발생한다() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");  graph.addVertex("v2"); graph.addVertex("v3");
        Assertions.assertThatThrownBy(() -> graph.addEdge("v3", "v4"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 연결되어_있지_않은_경로를_구할_경우_예외가_발생한다() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");  graph.addVertex("v2"); graph.addVertex("v3"); graph.addVertex("v4");
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v4"), 2);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        Assertions.assertThatThrownBy(() -> dijkstraShortestPath.getPath("v1", "v4").getVertexList())
                .isInstanceOf(NullPointerException.class);
    }

}
