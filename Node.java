import java.util.*;

public class Node implements Comparator<Node>
{
    String nodeValue;
    int cost;
    List<Node> parent = new ArrayList<>();
    List<Node> adjList = new ArrayList<>();
    List<Edge> edgeAdjList = new ArrayList<>();

    Node()
    {

    }
    Node(String val)
    {
        nodeValue = val;
    }

    String getValue()
    {
        return nodeValue;
    }

    @Override
    public int compare(Node node1, Node node2) 
    { 
        Node commonParent = new Node();
        for(int i = 0; i < node1.parent.size();i++)
        {
            for(int j = 0; j < node2.parent.size();j++)
            {
                if(node1.parent.get(i) == node2.parent.get(j))
                {
                    commonParent = node1.parent.get(i);
                }
            }
        }

        for(Edge e: commonParent.edgeAdjList)
        {
            if(e.destination == node1)
            {
                node1.cost = e.weight;
            }
            else if(e.destination == node2)
            {
                node2.cost = e.weight;
            }
        }
        
        if (node1.cost < node2.cost) 
            return -1; 
        if (node1.cost > node2.cost) 
            return 1; 
        return 0; 
    }

    
}