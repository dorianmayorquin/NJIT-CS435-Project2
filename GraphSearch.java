import java.util.*;

public class GraphSearch
{
    ArrayList<Node> arr = new ArrayList<>();
    int graphSize = 0;
    Graph graph;
    boolean stopRec = false;

    GraphSearch(Graph gr)
    {
        graph = gr;
        ListIterator<Node> iterator = gr.nodeList.listIterator();

        while(iterator.hasNext())
        {
            iterator.next();
            graphSize++;
        }


    }
    ArrayList<Node> DFSRec(final Node start, final Node end)
    {
        boolean visited[] = new boolean[graphSize];

        visited[graph.nodeList.indexOf(start)] = true;
        arr.add(start);
        //System.out.println(graph.nodeList.indexOf(start) + " "); Nodes in DFS Order
        if(start == end)
        {
            //System.out.println("Complete");
            stopRec = true;
            return arr;
        }

        Iterator<Node> iterator = start.adjList.listIterator();
        while(iterator.hasNext())
        {
            Node n = iterator.next();
            if(!visited[graph.nodeList.indexOf(n)])
            {
                if(stopRec)
                {
                    return arr;
                }
                DFSRec(n,end);
            }
        }

        if(arr.indexOf(end) == -1)
        {
            return null;
        }

        return arr;

    }
}