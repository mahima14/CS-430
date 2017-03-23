import java.util.Comparator;

/**
 * Created by Mahima on 10/9/2016.
 */

//Class created to create graph for Kruskal's
public class KruskalGraph implements Comparable<KruskalGraph> {


    String sourceNode;
    String destNode;
    int weight = 0;

    KruskalGraph[] kruskalGraph;

    KruskalGraph(){}
    KruskalGraph(int size)
    {
        kruskalGraph = new KruskalGraph[size];
        for(int i =0;i<size;i++) {
            kruskalGraph[i] = new KruskalGraph();
        }
    }
    //Comparator used to sort edges
    @Override
    public int compareTo(KruskalGraph graph) {
        if(this.weight == graph.weight)
            return 0;
        else
            return this.weight> graph.weight ? 1 : -1;

    }
}
