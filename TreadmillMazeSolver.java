import java.util.*;

public class TreadmillMazeSolver
{
    ArrayList<Node> dijkstras(final WeightedGraph graph)
    {
        Map<Node,Integer> distance = new HashMap<Node,Integer>();
        Map<Node,Node> parent = new HashMap<>();
        Map<Node,Boolean> visited = new HashMap<>();
        ArrayList<Node> result = new ArrayList<>();


        PriorityQueue<Node> queue = new PriorityQueue<Node>(graph.nodeList.size(),new Node());


        for(Node n: graph.nodeList)
        {
            distance.put(n, Integer.MAX_VALUE);
            parent.put(n,null);
            visited.put(n,false);
        }

        distance.replace(graph.nodeList.get(0),0);
        parent.replace(graph.nodeList.get(0),graph.nodeList.get(0));
        queue.add(graph.nodeList.get(0));

        while(!queue.isEmpty())
        {
            Node smallestFromQ = queue.poll();
            for(Edge neighbour: smallestFromQ.edgeAdjList)
            {
                if(!visited.get(neighbour.destination))
                {
                    int tempDistance = distance.get(smallestFromQ) + neighbour.weight;

                    if(tempDistance < distance.get(neighbour.destination))
                    {
                        distance.replace(neighbour.destination, tempDistance);
                        parent.replace(neighbour.destination,smallestFromQ);

                    }
                    queue.add(neighbour.destination);
                }                

            }
            visited.replace(smallestFromQ, true);

        }

        /*for (Map.Entry<Node,Integer> entry : distance.entrySet())  
            System.out.println("Key = " + entry.getKey().nodeValue +  ", Value = " + entry.getValue()); 
            
        for (Map.Entry<Node,Boolean> entry : visited.entrySet())  
        System.out.println("Key = " + entry.getKey().nodeValue +  ", Value = " + entry.getValue());

        for (Map.Entry<Node,Node> entry : parent.entrySet())  
        System.out.println("Key = " + entry.getKey().nodeValue +  ", Value = " + entry.getValue().nodeValue);
        */


        return result;
    }
}