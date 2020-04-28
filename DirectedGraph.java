import java.util.*;
public class DirectedGraph
{
    List<Node> nodeList = new ArrayList<>(); //List of all Nodes

    void addNode(String nodeVal) 
   {
        Node n = new Node(nodeVal);
        nodeList.add(n);
   }

   void addDirectedEdge(final Node first, final Node second)
    {
        if(first.adjList.indexOf(second) != -1) // If first is adjList of second
        {
            return;
        }
        else if(second.adjList.indexOf(first) != -1) //if second is in adjList of first
        {
            return;
        }
        else if(second != first)
        {
            first.adjList.add(second);
        }

    }
   void removeDirectedEdge(final Node first, final Node second)
   {
        if(first.adjList.indexOf(second) != -1)
        {first.adjList.remove(second);}
   }

   public HashSet<Node> getAllNodes()
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