import java.util.*;
public class Edge extends Node
{
    Node source;
    Node destination;
    int weight;

    Edge()
    {

    }

    Edge(Node source, Node destination, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        destination.parent.add(source);
    }
}