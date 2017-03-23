import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by Mahima on 10/8/2016.
 */
public class DepthFirstSearch {

    //Stores
    HashMap<String, LinkedList<String>> graphMap = new HashMap<>();

    //Stores the visited nodes
    Stack<String> parentVisited = new Stack<>();

    //Size of graph
    int graphSize;

    //Initialize the graph size
    DepthFirstSearch(int graphSize)
    {
        this.graphSize =graphSize;
    }


    //Starts with the source and checks if node already visited.
    public void dfs(){
        Iterator iterator = graphMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry nextParent = (Map.Entry)iterator.next();
            if(!parentVisited.contains(nextParent.getKey().toString()))
                parentVisited.push(nextParent.getKey().toString());
                 dfsVisit(graphMap.get(nextParent.getKey()));
        }

        showDfs();
    }

    // Display DFS traverses nodes
    public void showDfs()
    {
        System.out.print(parentVisited);
    }
    // Visits nodes in Deptth First Search and stores the output in Stack parentVisited.
    public void dfsVisit(LinkedList<String> childNodes){
        String source;
        if(childNodes != null)
        for(int i = 0;i<childNodes.size();i++)
        {
            source = childNodes.get(i);
            dfsVisit(graphMap.get(graphMap.get(childNodes.get(i))));
            if(!parentVisited.contains(source))
            {
                parentVisited.push(source);
            }
        }
    }

public static void main(String args[])
    {
        Graph graph  = new Graph();

        // Graph creation using adjacency list
        graph.addEdge("A", "B");
        graph.addEdge("A", "E");
        graph.addEdge("B", "D");
        graph.addEdge("D", "E");
        graph.addEdge("E", "B");
        graph.addEdge("C", "D");
        graph.addEdge("C", "F");
        graph.addEdge("F", "F");
        DepthFirstSearch dfs = new DepthFirstSearch(graph.graphMap.size());
        dfs.graphMap = graph.graphMap;
        dfs.dfs();


    }
}
