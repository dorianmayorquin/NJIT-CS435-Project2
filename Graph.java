import java.util.*;

public class Graph
{
    List<Node> nodeList = new ArrayList<>(); //List of all Nodes

    void addNode(final String nodeVal)
    {
        Node n = new Node(nodeVal);
        nodeList.add(n);
    }

    void addUndirectedEdge(final Node first, final Node second)
    {
        first.adjList.add(second);
        second.adjList.add(first);
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

    
