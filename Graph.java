import java.util.*;

public class Graph
{
    /*Graph graph = new Graph();
    graph.addNode("Node 1"); // Add nodes with name x, and with content "Node 1"
    graph.addUndirectedEdge(graph.nodeList.get(0),graph.nodeList.get(1));//Edge from node 0 to node 1 and viceversa
    */
    
    List<Node> nodeList = new ArrayList<>(); //List of all Nodes

    void addNode(final String nodeVal)
    {
        Node n = new Node(nodeVal);
        nodeList.add(n);
    }

    void addUndirectedEdge(final Node first, final Node second)
    {
        if(first.adjList.indexOf(second) != -1)
        {
            return;
        }
        else if(second.adjList.indexOf(first) != -1)
        {
            return;
        }
        else if(second != first)
        {
            first.adjList.add(second);
            second.adjList.add(first);
        }

    }

    void removeUndirectedEdge(final Node first, final Node second)
    {
        first.adjList.remove(second);
        second.adjList.remove(first);
    }

    HashSet<Node> getAllNodes()
    {
        HashSet<Node> nodes = new HashSet<Node>();
        ListIterator<Node> iterator = nodeList.listIterator();

        while(iterator.hasNext())
        {
            nodes.add(iterator.next());
        }

        return nodes;
    }
    

}

    
