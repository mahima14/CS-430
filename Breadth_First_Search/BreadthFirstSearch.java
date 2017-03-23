import java.util.*;

/**
 * Created by Mahima on 10/8/2016.
 */
public class BreadthFirstSearch {

    //Vertices with adjacent nodes
    HashMap<String , LinkedList<String>> graphMap = new HashMap<>();

    //List of visited nodes
    ArrayList<String> visitedNodes = new ArrayList<>();

    //Nodes traversed in BFS
    Queue<String> nodeQueue  = new LinkedList<>();

    //Keeps the child Parent map
    HashMap<String,String> childParentMap = new HashMap<>();

    //Shortest Path stack
    Stack<String> shortestPath = new Stack<>();

    //To traverse in BFS
    public void bfs(String source, String destination)
    {
        nodeQueue.add(source);
        childParentMap.put(source, null);
        while(!nodeQueue.isEmpty())
        {
            String nextNode = nodeQueue.poll().toString();
            visitedNodes.add(nextNode);
            if(graphMap.containsKey(nextNode))
                         bfsTraversal(graphMap.get(nextNode), nextNode);
        }
        System.out.println("BFS Traversal");
        System.out.println(visitedNodes);

        System.out.println("Shortest Path from " + source + " -- " + destination);
        findShortestPath(destination);
    }

    void bfsTraversal(LinkedList<String> adjacentNodes, String source)
    {
        Iterator iterator = adjacentNodes.iterator();
        while (iterator.hasNext())
        {
            String childNode = iterator.next().toString();
            if(!visitedNodes.contains(childNode))
            {
                nodeQueue.add(childNode);
                childParentMap.put(childNode, source);
            }
        }
    }

    //To get the shortest path to destination node
    void findShortestPath(String destNode)
    {
        if(destNode != null)
        {
            shortestPath.add(destNode);
            destNode= childParentMap.get(destNode);
            findShortestPath(destNode);
        }
        while(!shortestPath.isEmpty())
            System.out.print(shortestPath.pop());
    }

    public static void main(String args[])
    {
        ArrayList<String> childNodes = new ArrayList<>();
        String source = "A";
        String destination = "D";
        Graph graph  = new Graph();

        graph.addEdge("A", "B");
        graph.addEdge("A", "E");
        graph.addEdge("B", "D");
        graph.addEdge("D", "E");
        graph.addEdge("E", "C");
        graph.addEdge("C", "D");
        graph.addEdge("C", "F");
        graph.addEdge("F", "F");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.graphMap = graph.graphMap;
        bfs.bfs(source, destination);
    }
}
