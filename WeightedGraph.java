import java.util.*;
public class WeightedGraph
{
    List<Node> nodeList = new ArrayList<>(); //List of all Nodes

    void addNode(final String nodeVal)
    {
        Node n = new Node(nodeVal);
        nodeList.add(n);
    }

    void addWeightedEdge(final Node first, final Node second, final int weight)
    {        
        for(Edge e : first.edgeAdjList)
        {
            if(e.destination == second)
            {
                return;
            }
        }

        for(Edge e : second.edgeAdjList)
        {
            if(e.destination == first)
            {
                return;
            }
        }
        if(first != second)
        {
            Edge edge = new Edge(first,second,weight);
            first.edgeAdjList.add(edge);
        }


    }

    void removeDirectedEdge(final Node first, final Node second)
    {
        for(Edge e : first.edgeAdjList)
        {
            if(e.source == first && e.destination == second)
            {
                first.edgeAdjList.remove(e);
                return;
            }
        }

        System.out.print("Edge Does Not Exist");
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