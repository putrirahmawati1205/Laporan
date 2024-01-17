package GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// membuat class untuk edge yang merepesentasikan sebuah edge pada graph berbobot
 class Edge {
    // destination merupakan simpul tujuan dan weight merupakan bobot dari edge
    String destination;
    int weight;

    public Edge(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

/*
 * kelas untuk WeightedGraph
 * adjacencyList sebuah hashmap untuk menyimpan daftar simpul(node) sebagi kunci dan daftar edge yang terhubung dengan node tersebut
 */
class WeightedGraph {
    private Map<String, List<Edge>> adjacencyList;

    public WeightedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graph
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge berbobot ke grph
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    // Mencetak graf
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print(edge.destination + "(" + edge.weight + ") ");
            }
            System.out.println();
        }
    }


    // methode main untuk menjalankan program
    public static void main(String[] args) {
        // membuat objek graph dari class WeightedGraph
        WeightedGraph graph = new WeightedGraph();
        // menambahkan node
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // membuat edge dengan bobot
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // mencetak graph yang ada
        graph.printGraph();
    }
}
