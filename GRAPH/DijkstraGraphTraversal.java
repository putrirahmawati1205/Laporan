package GRAPH;

import java.util.*;

class Sisi {
    String destination;
    int weight;

    // Konstruktor untuk membuat objek Sisi dengan tujuan (destination) dan bobot(weight)
    public Sisi(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

// membuat class untuk DijkstraGraphTraversal
public class DijkstraGraphTraversal {
    // Map yang menyimpan daftar node dan daftar sisi terkait untuk setiap node
    private Map<String, List<Sisi>> adjacencyList = new HashMap<>();

    // Metode untuk menambahkan node ke graph
    public void addNode(String node) {
        // Menambahkan node ke adjacencyList jika belum ada
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node (sumber dan tujuan) sudah ada dalam adjacencyList.
        addNode(source);
        addNode(destination);

        adjacencyList.get(source).add(new Sisi(destination, weight));
        // Untuk graf tidak terarah, tambahkan baris berikut:
        adjacencyList.get(destination).add(new Sisi(source, weight));
    }

    public int dijkstra(String start, String end) {
        // PriorityQueue untuk menyimpan pasangan (node, jarak) yang diurutkan
        // berdasarkan jarak
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());

        // Map untuk menyimpan jarak terpendek dari start ke setiap node
        Map<String, Integer> distances = new HashMap<>();

        // Set untuk menyimpan node yang sudah dikunjungi
        Set<String> settled = new HashSet<>();

        // Inisialisasi jarak dari start ke setiap node dengan nilai tak terhingga
        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }

        // Jarak dari start ke start diatur menjadi 0
        distances.put(start, 0);

        // Menambahkan start ke PriorityQueue dengan jarak 0
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        // perulangan utama Dijkstra
        while (!pq.isEmpty()) {
            // Mengambil node dengan jarak terpendek dari PriorityQueue
            String current = pq.poll().getKey();

            // Jika node yang diambil adalah tujuan akhir, kembalikan jarak terpendek
            if (current.equals(end)) {
                return distances.get(end);
            }

            // Lewati node yang sudah dikunjungi
            if (settled.contains(current)) {
                continue;
            }
            settled.add(current);

            // Iterasi melalui sisi-sisi terhubung dari node saat ini
            for (Sisi edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                // Jika node tujuan belum dikunjungi
                if (!settled.contains(edge.destination)) {
                    // Hitung jarak baru melalui node saat ini
                    int newDistance = distances.get(current) + edge.weight;

                    // Jika jarak baru lebih kecil dari jarak sebelumnya, perbarui jarak
                    if (newDistance < distances.get(edge.destination)) {
                        distances.put(edge.destination, newDistance);

                        // Tambahkan node tujuan dan jaraknya ke PriorityQueue
                        pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDistance));
                    }
                }
            }
        }

        // Jika tujuan akhir tidak terjangkau, kembalikan nilai tak terhingga
        return distances.get(end);
    }

    // class main untuk mejalankan program
    public static void main(String[] args) {
        DijkstraGraphTraversal graph = new DijkstraGraphTraversal();

        // Tambahkan node dan edge
        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "B", 12);
        graph.addEdge("A", "E", 8);
        graph.addEdge("B", "E", 10);

        // output untuk hasil dijkstra
        int distance = graph.dijkstra("A", "E");
        System.out.println("Jarak dari NodeAwal ke NodeAkhir adalah " + distance);
    }
}