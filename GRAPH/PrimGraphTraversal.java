package GRAPH;
import java.util.*;

// mendefinisikan kelas edge yang implementasi dari antarmuka 
class Edge implements Comparable<Edge> {
    /*
     * source: atribut untuk menyimpan simpul asal
     * destination: atribut untuk menyimpan simpul tujuan
     * weight: atribut untuk menyimpan bobot dari edge
     */
    String source; 
    String destination;
    int weight;

    // konstruktor untuk membuat objek "edge" dengan nilai awal
    public Edge(String source, String destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    // methode untuk membandingkan antar objek berdasarkan bobotnya
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

// definisi kelas utama
public class PrimGraphTraversal {
    // atribut untuk menyimpan representasi adjacencylist dari graph
    private Map<String, List<Edge>> adjacencyList;

    // konstruktor membuat objek PrimGraphTraversal
    // inisialisasi atribut adjacencyList sebagai objek HashMap
    public PrimGraphTraversal() {
        adjacencyList = new HashMap<>();
    }

    // methode Menambahkan node baru pada graph
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // methode Menambahkan edge berbobot pada graph
    public void addEdge(String source, String destination, int weight) {
        // memastikan kedua nodenya ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // menambahkan edge berbobot
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        adjacencyList.get(destination).add(new Edge(destination, source, weight)); // Untuk graf tidak terarah
    }

    // Methode mendapatkan daftar tetangga dan bobot dari sebuah simpul (node)
    public List<Edge> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Methode untuk menjalankan algoritma Prim untuk mencari MST
    public void primMST(String start) {
        // PriorityQueue yang akan menyimpan edge-edge dengan bobot terkecil
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        // menyimpan simpul yang sudah termasuk MST
        Set<String> inMST = new HashSet<>();
        // membuat HashMap untuk menyimpan edge yangmenghubungkan simpul dalam MST
        Map<String, Edge> edgeTo = new HashMap<>();

        // Inisialisasi dengan simpul awal
        inMST.add(start);
        // perulangan untuk membuat MST
        for (Edge edge : adjacencyList.getOrDefault(start, Collections.emptyList())) {
            pq.add(edge);
            edgeTo.put(edge.destination, edge);
        }
        // Variabel untuk menyimpan total bobot dari MST dan dimulai dari 0
        int totalWeight = 0; 

        // perulangan yang dilakukan selama PriorityQueue "pq" tidak kosong.
        // 'pq' berfungsi sebagai antrian yang akan menyimpan edge yang berbobot terkecil
        while (!pq.isEmpty()) {
            // mengambil dan menghapus edge dngan bobot terkecil dari 'pq'
            Edge edge = pq.poll();
            if (inMST.contains(edge.destination)) continue;

            // menambahkan simpul tujuan kedalam (set) 'intMST' yang menandakan bahwa simpul tersebut sudah termasuk MST
            inMST.add(edge.destination);
            // mencetak edge yang terpilih 
            System.out.println(edgeTo.get(edge.destination).source + " - " + edge.destination + " [" + edge.weight + "]");
            // Menambahkan bobot edge ke total bobot MST
            totalWeight += edge.weight; 

            // perulangan untuk mengecek edge yang terhubung dengan simpul tujuan dan ditambahkan keddalam MST
            for (Edge nextEdge : adjacencyList.getOrDefault(edge.destination, Collections.emptyList())) {
                /*
                 * Jika simpul tujuan dari edge yang diperiksa belum termasuk dalam MST, maka:
                 * pq.add(nextEdge) menambahkan edge kedalam priorityQueue untuk pertimbangan ke iterasi berikutnya
                 * edgeTo.put(nextEdge.destination, nextEdge) menyimpan edge yang terhubung dalam "edgeTo" sehingga dapat digunakan pada iterasi berikutnya
                 */
                if (!inMST.contains(nextEdge.destination)) {
                    pq.add(nextEdge);
                    edgeTo.put(nextEdge.destination, nextEdge);
                }
            }
        }

        // mencetak total bobot MST
        System.out.println("Total bobot MST: " + totalWeight); // Mencetak total bobot
    }

    // methode main untuk menjalankan program
    public static void main(String[] args) {
        PrimGraphTraversal graph = new PrimGraphTraversal();

        // Menambahkan simpul/node ke graph
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        // menambahkan edge ke graph dengan bobot
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("B", "E", 10);
        graph.addEdge("C", "D", 8);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        
        // menjalankan algoritma primMST dari simpul "A" dan mencetak MST yang terbentuk
        graph.primMST("A");
    }

    
}
