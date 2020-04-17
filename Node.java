import java.util.*;

public class Node
{
    String nodeValue;
    List<Node> adjList = new ArrayList<>();

    Node(String val)
    {
        nodeValue = val;
    }

    String getValue()
    {
        return nodeValue;
    }

    
}