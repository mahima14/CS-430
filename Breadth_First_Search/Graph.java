import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Mahima on 9/26/2016.
 */
public class Graph {
    HashMap<String, LinkedList<String>> graphMap = new HashMap<>();

    LinkedList<String> nodeList;

    // Creates edge between two vertices
    public void addEdge(String vertex,   String childNodes) {
        nodeList = new LinkedList<>();

        nodeList.add(childNodes);
        if(graphMap.get(vertex) != null )
        {
            graphMap.get(vertex).add(childNodes);
        }
        else
            graphMap.put(vertex, nodeList);

    }
    }
