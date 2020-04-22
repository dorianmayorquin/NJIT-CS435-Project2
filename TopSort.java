import java.util.*;

public class TopSort
{
    ArrayList<Node> Kahns(final DirectedGraph graph)
    {
        ArrayList<Node> sorted = new ArrayList<>();
        HashMap<Node,Integer> inDegreeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        //Initialize all Nodes w/ indegree of 0
        for(Node n : graph.nodeList)
        {
            inDegreeMap.put(n,0);
        }

        //Populate map with actual Number of Incoming Edges for each node
        for(Node n : graph.nodeList)
        {
            for(Node adj : n.adjList)
            {
                inDegreeMap.replace(adj,inDegreeMap.get(adj)+1);
            }
        }

        //Add all nodes with 0 dependencies to queue

        for(Node node :  inDegreeMap.keySet())
        {
            if(inDegreeMap.get(node) == 0)
            {
                queue.add(node);
                inDegreeMap.replace(node,inDegreeMap.get(node)-1);
            }
        }


        while(!queue.isEmpty())
        {
            //Add First element in Queue to Sorted List
            Node curr = queue.poll();
            sorted.add(curr);

            //Decrease the Degree of first Element's neighbors
            for(Node node : curr.adjList)
            {
                inDegreeMap.replace(node,inDegreeMap.get(node)-1);
            }

            //Add New nodes with 0 inDegree to Queue
            for(Node node :  inDegreeMap.keySet())
            {
                if(inDegreeMap.get(node) == 0)
                {
                    queue.add(node);
                    inDegreeMap.replace(node,inDegreeMap.get(node)-1);
                }
             }

        }

        return sorted;
    }
}