package GRAPH;

import java.util.*;

// membuat class DirectedGraph
class DirectedGraph {
    private Map<String, List<String>> adjacencyList;

    // menginisialisasikan objek adjacencyList untuk merepresentasikan graph berarah
    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge berarah ke graf 
    public void addEdge(String source, String destination) {
        // memastikan node dengan kunci "source" telah dimasukkan kedalam "adjacencyList"
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // menambahkan destinasi sebagai tetangga dari source dalam representasi graph 
        adjacencyList.get(source).add(destination);
    }

    // mendapatkan daftar tetangga dari node dalam graph
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // methode untuk mencetak graph
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // class main untuk menjalankan program
    public static void main(String[] args) {
        // membuat objek graph dari class DirectedGraph
        DirectedGraph graph = new DirectedGraph();
        // membuat node
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // membuat edge ke graph
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        // tampilkan hasil
        graph.printGraph();
    }
}