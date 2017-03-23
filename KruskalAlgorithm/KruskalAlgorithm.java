import java.util.*;
import java.util.LinkedList;

/**
 * Created by Mahima on 10/9/2016.
 */
public class KruskalAlgorithm {

    //Nodes visited already
    Queue<String> visitedNode = new LinkedList<>();

    //Edges visited already
    Queue<Integer> visitedEdge = new LinkedList<>();

    //Method to find Minimum Spanning Tree
    public void minSpanTree(KruskalGraph[] kruskalGraph) {
        int length = kruskalGraph.length;

        //To iterate over vertices
        for ( int i = 0; i < length; i++ ) {

            String sourceNode = kruskalGraph[i].sourceNode;
            String destNode = kruskalGraph[i].destNode;

            //Checking loop
            if (this.visitedNode.contains(sourceNode)){
                if (!this.visitedNode.contains(destNode)) {
                    this.visitedNode.add(destNode);
                    this.visitedEdge.add(i); }
            }
            else if (!this.visitedNode.contains(sourceNode)){
                if (!this.visitedNode.contains(destNode)) {
                    this.visitedNode.add(sourceNode);
                    this.visitedNode.add(destNode);
                    this.visitedEdge.add(i);
                } else{
                    this.visitedNode.add(sourceNode);
                    this.visitedEdge.add(i); }

            }}
        this.showDfs(kruskalGraph);
    }

    //Method to MST edges
    public void showDfs(KruskalGraph[] kruskalGraph) {
        while(!this.visitedEdge.isEmpty())
        {
            int edge = this.visitedEdge.poll();
            if(kruskalGraph[edge].sourceNode!= null){
                System.out.println(" " + kruskalGraph[edge].sourceNode + "--" +
                        kruskalGraph[edge].destNode + ": " + kruskalGraph[edge].weight);}
        }
    }

    public static void main(String[] args) {

        //Creating Graph for this algorithm
        KruskalGraph kGraph = new KruskalGraph(5);

        kGraph.kruskalGraph[0].sourceNode = "A";
        kGraph.kruskalGraph[0].destNode = "D";
        kGraph.kruskalGraph[0].weight = 5;

        kGraph.kruskalGraph[1].sourceNode = "A";
        kGraph.kruskalGraph[1].destNode = "C";
        kGraph.kruskalGraph[1].weight = 6;

        kGraph.kruskalGraph[2].sourceNode = "A";
        kGraph.kruskalGraph[2].destNode = "B";
        kGraph.kruskalGraph[2].weight = 10;

        kGraph.kruskalGraph[3].sourceNode = "B";
        kGraph.kruskalGraph[3].destNode = "D";
        kGraph.kruskalGraph[3].weight = 15;

        kGraph.kruskalGraph[3].sourceNode = "C";
        kGraph.kruskalGraph[3].destNode = "D";
        kGraph.kruskalGraph[3].weight = 4;
        Arrays.sort(kGraph.kruskalGraph);

        KruskalAlgorithm kruskal = new KruskalAlgorithm();
        kruskal.minSpanTree(kGraph.kruskalGraph);
    }

}

