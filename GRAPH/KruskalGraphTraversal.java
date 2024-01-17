package GRAPH;

import java.util.*;

// mendeklarasikan class "edge" yang merepresentasikan sisi graph
class Edge implements Comparable<Edge> {
    // mendefinisikan variable yang akan menyimpan node asal, node tujuan, dan bobot sisi
    String source;       
    String destination;  
    int weight;          

    // Konstruktor untuk membuat objek "edge" baru
    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    // methode compareTo untuk membandingkan sisi berdasarkan bobotnya
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// deklarasi class utama
public class KruskalGraphTraversal {
    /*
     * mendeklarasikan variable yang akan menyimpan daftar sisi dan representasi set
     */
    private List<Edge> edges = new ArrayList<>(); 
    private Map<String, String> parent = new HashMap<>(); 

    // Metode untuk menambahkan sisi ke graph
    public void addEdge(String source, String destination, int weight) {
        edges.add(new Edge(source, destination, weight));
    }

    // methode untuk mencari representasi set dari suatu node 
    public String find(String node) {
        if (!parent.containsKey(node)) {
            parent.put(node, node);
        }

        if (!parent.get(node).equals(node)) {
            parent.put(node, find(parent.get(node)));
        }

        return parent.get(node);
    }

    // methode untuk menggabungkan dua set 
    public void union(String node1, String node2) {
        String parent1 = find(node1);
        String parent2 = find(node2);
        parent.put(parent1, parent2);
    }

    // methode untuk menjalankan algoritma kruskal dan mencetak MST
    public void kruskalMST() {
        // Mengurutkan semua sisi berdasarkan bobot
        Collections.sort(edges); 

        // menyimpan total bobot dari MST
        int mstWeight = 0; 
        for (Edge edge : edges) {
            String root1 = find(edge.source);
            String root2 = find(edge.destination);

            // Mencetak sisi MST 
            if (!root1.equals(root2)) {
                System.out.println(edge.source + " - " + edge.destination + " [" + edge.weight + "]");
                mstWeight += edge.weight;
                union(edge.source, edge.destination);
            }
        }

        // mencetak total bobot dari MST
        System.out.println("Total bobot MST: " + mstWeight);
    }

    // Metode main untuk menjalankan Program
    public static void main(String[] args) {
        // membuat objek graph dari class KruskalGraphTraversal
        KruskalGraphTraversal graph = new KruskalGraphTraversal();
        
        // Menambahkan edge ke graf dengan bobot
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("B", "E", 10);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        
        
        graph.kruskalMST();
    }

}