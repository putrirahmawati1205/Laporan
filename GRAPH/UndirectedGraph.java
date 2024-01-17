package GRAPH;
import java.util.*;

// class untuk UndirectedGraph
class UndirectedGraph {
    // mendeklarasikan sebuah variable untuk menyimpan informasi hubungan antar node pada graph
    private Map<String, List<String>> adjacencyList;

    // konstruktor untuk menyimoan hubungan antar node 
    public UndirectedGraph(){
        adjacencyList = new HashMap<>();
    }

    // methode untuk menambahkan node baru ke graph
    public void addnode(String node){
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // methode untuk menambahkan edge antar dua node
    public void addEdge(String source, String destination){
        // memastikan kedua node ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.putIfAbsent(destination, new ArrayList<>());

        // menambahkan edge tak berarah antara "source" dan "destination"
        // koneksi atau hubungan antar dua simpul bersifat dua arah
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    } 

    // methode untuk mencetak graph
    public void printGraph(){
        for (String node : adjacencyList.keySet()){
            System.out.println("Node " + node + " terhubung dengan node: ");
            for (String neighbor : adjacencyList.get(node)){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    // methode main untuk menjalankan program
    public static void main(String[] args) {
        // membuat objek graph dari class UndirectedGraph
        UndirectedGraph graph = new UndirectedGraph();

        // menambahkan node/simpul graph
        graph.addnode("A");
        graph.addnode("B");
        graph.addnode("C");
        graph.addnode("D");

        // membuat edge 
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");

        // mencetak graph
        graph.printGraph();
    }
}

