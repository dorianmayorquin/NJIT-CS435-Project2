public class Main
{

    public static void main(String[] args)
    {

        Graph graph = new Graph();

        graph.addNode("Node 1"); // Add nodes with name x, and with content "Node 1"
        graph.addNode("Node 2");
        graph.addNode("Node 3");
        graph.addNode("Node 4");

        graph.addUndirectedEdge(graph.nodeList.get(0),graph.nodeList.get(1));//Edge from node 0 to node 1 and viceversa
        graph.addUndirectedEdge(graph.nodeList.get(0),graph.nodeList.get(2));
        graph.addUndirectedEdge(graph.nodeList.get(0),graph.nodeList.get(3));
        graph.removeUndirectedEdge(graph.nodeList.get(0),graph.nodeList.get(3));

        System.out.println(graph.nodeList.get(0).adjList); // Edges for node 0
        System.out.println(graph.getAllNodes()); // List of all Nodes
        





        

    }
}