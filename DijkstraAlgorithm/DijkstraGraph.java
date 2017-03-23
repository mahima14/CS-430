import java.util.HashMap;

/**
 * Created by Mahima on 10/10/2016.
 */

//Creating graph for Dijkstra Algorithm
public class DijkstraGraph {

    HashMap<Integer, Integer> adjWeightList = new HashMap<>();
    int weight = 0;
    int vertex =0;

    DijkstraGraph[] dijkstraGraph;

    DijkstraGraph() {
    }

    DijkstraGraph(int size) {
        dijkstraGraph = new DijkstraGraph[size];
        for ( int i = 0; i < size; i++ ) {
            dijkstraGraph[i] = new DijkstraGraph();
        }

    }
    void addWeightedVertex(int vertex, int weight)
    {
        this.adjWeightList.put(vertex,weight);
    }
}
