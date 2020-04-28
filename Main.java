import java.util.*;

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
        Random rand2 = new Random();
        int random = rand.nextInt(n);
        int random2 = rand2.nextInt(n);

        for(int i = 0; i < n; i++)
        {
            newgraph.addNode(Integer.toString(n));
        }

        for(int i = 0; i < n; i++)
        {
            if(random > 0 && random2 > 0)
            {
                newgraph.addUndirectedEdge(newgraph.nodeList.get(random-1),newgraph.nodeList.get(random2-1));
            }
            random = rand.nextInt(n);
            random2 = rand2.nextInt(n);
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

    static ArrayList<Node> BFTRecLinkedList(final Graph graph)
    {
        GraphSearch newsearch = new GraphSearch(graph);
    
        return newsearch.BFTRec(graph);
    }

    static ArrayList<Node> BFTIterLinkedList(final Graph graph)
    {
        GraphSearch newsearch = new GraphSearch(graph);

        return newsearch.BFTIter(graph);
    }

    static DirectedGraph createRandomDAGIter(final int n)
    {
        DirectedGraph newgraph = new DirectedGraph();
        Random rand = new Random();
        Random rand2 = new Random();
        int random = rand.nextInt(n);
        int random2 = rand2.nextInt(n);

        for(int i = 0; i < n; i++)
        {
            newgraph.addNode(Integer.toString(n));
        }

        for(int i = 0; i < n; i++)
        {

            if(random > 0 && random2 > 0)
            {
                newgraph.addDirectedEdge(newgraph.nodeList.get(random-1),newgraph.nodeList.get(random2-1));
            }
            random = rand.nextInt(n);
            random2 = rand2.nextInt(n);
        }

        /*System.out.println(newgraph.nodeList); //List of all Nodes
        for(int i = 0; i < random; i++) // Adj List for Each node
        {
            System.out.println(newgraph.nodeList.get(i).adjList);
        }*/
        

        return newgraph;

    }

    static WeightedGraph createRandomCompleteWeightedGraph(final int n)
    {
        WeightedGraph wg = new WeightedGraph();
        Random rand = new Random();
        int random = rand.nextInt(50) + 1;

        for(int i = 0; i < n; i++)
        {
            wg.addNode(Integer.toString(i));
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                wg.addWeightedEdge(wg.nodeList.get(i), wg.nodeList.get(j), random);
                random = rand.nextInt(50) + 1;
            }
        }


        return wg;
    }


    public static void main(String[] args)
    {       
        Graph gr = createLinkedList(10000);
        BFTIterLinkedList(gr);

        WeightedGraph wg = new WeightedGraph();
        
        wg.addNode("0");
        wg.addNode("1");
        wg.addNode("2");

        wg.addWeightedEdge(wg.nodeList.get(0),wg.nodeList.get(1), 5);
        wg.addWeightedEdge(wg.nodeList.get(0),wg.nodeList.get(1), 5);
        wg.removeDirectedEdge(wg.nodeList.get(0),wg.nodeList.get(1));

        wg = createRandomCompleteWeightedGraph(5);

       

    }


}




/*

        Tester for completeWeightedRandom:

        int i = 0;
        for(Node n : wg.nodeList)
        {
            for(Edge e : n.edgeAdjList)
            {
                System.out.println("From " + e.source.getValue() + " To " + e.destination.getValue() +
                "weight " + e.weight);
            }
        }


        ////
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
        
        
        //Tester for Khans
        DirectedGraph dirGra = new DirectedGraph();

        dirGra.addNode("0");
        dirGra.addNode("1");
        dirGra.addNode("2");
        dirGra.addNode("3");
        dirGra.addNode("4");
        dirGra.addNode("5");

        dirGra.addDirectedEdge(dirGra.nodeList.get(5), dirGra.nodeList.get(2));
        dirGra.addDirectedEdge(dirGra.nodeList.get(5), dirGra.nodeList.get(0));
        dirGra.addDirectedEdge(dirGra.nodeList.get(4), dirGra.nodeList.get(0));
        dirGra.addDirectedEdge(dirGra.nodeList.get(4), dirGra.nodeList.get(1));
        dirGra.addDirectedEdge(dirGra.nodeList.get(2), dirGra.nodeList.get(3));
        dirGra.addDirectedEdge(dirGra.nodeList.get(3), dirGra.nodeList.get(1));
  

        TopSort ts = new TopSort();

        System.out.println(ts.Kahns(dirGra));
        for(Node n : ts.Kahns(dirGra))
        {
            System.out.print(n.getValue() + " ");
        }


        //Tester for mDFS
        DirectedGraph dirGra = new DirectedGraph();

        dirGra.addNode("A");
        dirGra.addNode("B");
        dirGra.addNode("C");
        dirGra.addNode("D");
        dirGra.addNode("E");
        dirGra.addNode("F");
        dirGra.addNode("G");
        dirGra.addNode("H");

        dirGra.addDirectedEdge(dirGra.nodeList.get(0), dirGra.nodeList.get(1));
        dirGra.addDirectedEdge(dirGra.nodeList.get(0), dirGra.nodeList.get(3));
        dirGra.addDirectedEdge(dirGra.nodeList.get(2), dirGra.nodeList.get(3));
        dirGra.addDirectedEdge(dirGra.nodeList.get(2), dirGra.nodeList.get(6));
        dirGra.addDirectedEdge(dirGra.nodeList.get(2), dirGra.nodeList.get(7));
        dirGra.addDirectedEdge(dirGra.nodeList.get(3), dirGra.nodeList.get(6));
        dirGra.addDirectedEdge(dirGra.nodeList.get(7), dirGra.nodeList.get(4));
        dirGra.addDirectedEdge(dirGra.nodeList.get(7), dirGra.nodeList.get(5));
        
  

        TopSort ts = new TopSort();

        for(Node n : ts.mDFS(dirGra))
        {
            System.out.print(n.getValue() + " ");
        }*/