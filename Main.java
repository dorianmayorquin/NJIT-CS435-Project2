import java.util.Random;

public class Main
{
    /*Graph graph = new Graph();
    graph.addNode("Node 1"); // Add nodes with name x, and with content "Node 1"
    graph.addUndirectedEdge(graph.nodeList.get(0),graph.nodeList.get(1));//Edge from node 0 to node 1 and viceversa
    */

    static Graph createRandomUnweightedGraphIter(int n)
    {
        Graph newgraph = new Graph();
        Random rand = new Random();
        int random = rand.nextInt(n);
        int random2 = rand.nextInt(n);

        for(int i = 0; i < random; i++)
        {
            newgraph.addNode(Integer.toString(random));
        }

        for(int i = 0; i < random; i++)
        {
            if(random > random2 && random > 0)
            {
                newgraph.addUndirectedEdge(newgraph.nodeList.get(random-1),newgraph.nodeList.get(random2));
                random2 = rand.nextInt(n);
            }
        }

        /*System.out.println(newgraph.nodeList); //List of all Nodes
        for(int i = 0; i < random; i++) // Adj List for Each node
        {
            System.out.println(newgraph.nodeList.get(i).adjList);
        }*/
        

        return newgraph;
    }

    public static void main(String[] args)
    {
        Graph gr = createRandomUnweightedGraphIter(5);
        

    }

    


}