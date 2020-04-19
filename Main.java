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

    static Graph createLinkedList(int n)
    {
        //Didn't Know if nodes needed to be bidirectional or not.
        Graph linkedGraph = new Graph();

        for(int i = 0; i < n; i++)
        {
            linkedGraph.addNode(Integer.toString(i));
        }
        for(int i = 0; i < n-1; i++)
        {
            linkedGraph.addSingleEdge(linkedGraph.nodeList.get(i), linkedGraph.nodeList.get(i+1));
        }

        return linkedGraph;
    }

    public static void main(String[] args)
    {       

        
        

    }

    


    /*
        Tester code for DFSRec
        Graph gr = new Graph();

        gr.addNode("0");
        gr.addNode("1");
        gr.addNode("2");
        gr.addNode("3");
        gr.addNode("4");
        gr.addNode("5");
        gr.addNode("6");
        gr.addNode("8");
        gr.addNode("9");
        gr.addNode("10");

        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(1));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(2));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(3));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(4));
        gr.addSingleEdge(gr.nodeList.get(1), gr.nodeList.get(5));
        gr.addSingleEdge(gr.nodeList.get(1), gr.nodeList.get(6));

        GraphSearch gs = new GraphSearch(gr);

        System.out.println(gs.DFSRec(gr.nodeList.get(0), gr.nodeList.get(9)));


        //Tester code for DFSIter
        Graph gr = new Graph();

        gr.addNode("0");
        gr.addNode("1");
        gr.addNode("2");
        gr.addNode("3");
        gr.addNode("4");
        gr.addNode("5");
        gr.addNode("6");
        gr.addNode("7");
        gr.addNode("8");
        gr.addNode("9");
        gr.addNode("10");
        gr.addNode("11");
        gr.addNode("12");

        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(1));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(2));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(3));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(4));
        gr.addSingleEdge(gr.nodeList.get(1), gr.nodeList.get(5));
        gr.addSingleEdge(gr.nodeList.get(1), gr.nodeList.get(6));
        gr.addSingleEdge(gr.nodeList.get(4), gr.nodeList.get(7));
        gr.addSingleEdge(gr.nodeList.get(4), gr.nodeList.get(8));
        gr.addSingleEdge(gr.nodeList.get(8), gr.nodeList.get(9));
        gr.addSingleEdge(gr.nodeList.get(8), gr.nodeList.get(10));

        GraphSearch gs = new GraphSearch(gr);

        System.out.println(gs.DFSIter(gr.nodeList.get(0), gr.nodeList.get(3))); 

        //Tester for BFTRec
        Graph gr = new Graph();

        gr.addNode("0");
        gr.addNode("1");
        gr.addNode("2");
        gr.addNode("3");
        gr.addNode("4");
        gr.addNode("5");
        gr.addNode("6");
        gr.addNode("7");
        gr.addNode("8");
        gr.addNode("9");
        gr.addNode("10");
        gr.addNode("11");
        gr.addNode("12");

        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(1));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(2));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(3));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(4));
        gr.addSingleEdge(gr.nodeList.get(1), gr.nodeList.get(5));
        gr.addSingleEdge(gr.nodeList.get(1), gr.nodeList.get(6));
        gr.addSingleEdge(gr.nodeList.get(4), gr.nodeList.get(7));
        gr.addSingleEdge(gr.nodeList.get(4), gr.nodeList.get(8));
        gr.addSingleEdge(gr.nodeList.get(8), gr.nodeList.get(9));
        gr.addSingleEdge(gr.nodeList.get(8), gr.nodeList.get(10));
        gr.addSingleEdge(gr.nodeList.get(4), gr.nodeList.get(11));


        GraphSearch gs = new GraphSearch(gr);

        System.out.println(gs.BFTRec(gr));
        
        //Tester for BFTIter
        Graph gr = new Graph();

        gr.addNode("0");
        gr.addNode("1");
        gr.addNode("2");
        gr.addNode("3");
        gr.addNode("4");
        gr.addNode("5");
        gr.addNode("6");
        gr.addNode("7");
        gr.addNode("8");
        gr.addNode("9");
        gr.addNode("10");
        gr.addNode("11");
        gr.addNode("12");

        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(1));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(2));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(3));
        gr.addSingleEdge(gr.nodeList.get(0), gr.nodeList.get(4));
        gr.addSingleEdge(gr.nodeList.get(1), gr.nodeList.get(5));
        gr.addSingleEdge(gr.nodeList.get(1), gr.nodeList.get(6));
        gr.addSingleEdge(gr.nodeList.get(4), gr.nodeList.get(7));
        gr.addSingleEdge(gr.nodeList.get(4), gr.nodeList.get(8));
        gr.addSingleEdge(gr.nodeList.get(8), gr.nodeList.get(9));
        gr.addSingleEdge(gr.nodeList.get(8), gr.nodeList.get(10));
        gr.addSingleEdge(gr.nodeList.get(4), gr.nodeList.get(11));
        gr.addSingleEdge(gr.nodeList.get(9), gr.nodeList.get(12));


        GraphSearch gs = new GraphSearch(gr);

        System.out.println(gs.BFTIter(gr));
        
        */

}