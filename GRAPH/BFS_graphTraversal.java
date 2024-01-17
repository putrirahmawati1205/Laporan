package GRAPH;

import java.util.*;

// membuat class untuk edge
class Edges{
    String destination;
    int weight;
    
    public Edges(String destination, int weight){
    this.destination = destination;
    this.weight = weight;
    }
}

// BFS==metode yang melakukan pencarian secara melebar yang mengunjungi simpul secara preorder yaitu mengunjungi suatu simpul kemudian mengunjungi semua simpul yang bertetangga dengan simpul tersebut dahulu.
// membuat class untuk BfsGraphTraversal
public class BFS_graphTraversal {
    private Map<String, List<Edges>> adjacencyList;

    public BFS_graphTraversal() {
        adjacencyList = new HashMap<>();
    }
    // Menambahkan node baru ke graph
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge berbobot ke graph
    public void addEdge(String source, String destination, int weight) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge berbobot ke graph
        adjacencyList.get(source).add(new Edges(destination, weight));
    }

    // Mendapatkan daftar tetangga dan bobot dari node
    public List<Edges> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // BFS traversal dari node sumber
    public void bfsTraversal(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            // Menambahkan semua tetangga yang belum dikunjungi ke antrian
            for (Edges edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(edge.destination)) {
                    queue.add(edge.destination);
                    visited.add(edge.destination);
                    // System.out.print("-> (" + edge.weight + ") " + edge.destination + " ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Membuat objek BfsGraphTraversal
        BFS_graphTraversal graph = new BFS_graphTraversal();

        // Menambahkan node-node ke dalam graph
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        // Menambahkan edge-edge dengan bobot ke dalam graph
        graph.addEdge("A", "B", 5);
        graph.addEdge("A", "C", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 4);

        // Memulai traversing graf menggunakan Breadth-First Search dari node "A"
        graph.bfsTraversal("A");
    }

}