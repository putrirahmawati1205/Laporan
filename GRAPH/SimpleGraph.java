package GRAPH;
import java.util.*;

/*
 * membuat class untuk simple graph
 */
public class SimpleGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    // konstruktor untuk kelas SimpleGraph
    public SimpleGraph(){
        adjacencyList = new HashMap<>();

    }

    // menambahkan node baru ke graph
    public void addnode(Integer node){
        adjacencyList.putIfAbsent (node, new ArrayList<>());

    }

    // menambahkan edge 
    public void addEdge(int source, int destination){
        adjacencyList.get(source).add(destination);
    }

    /*
     * methode untuk mengembalikan daftar dari sebuah simpul tertentu
     * mengambil nilai dengan kunci "node" dari adjacencyList. jika tidak ada kunci, getOrDefault akan mengembalikan daftar kosong Collections.emptyList()
     */
    public List<Integer> getNeighbors(int node){
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    
    }

    // mencetak representasi graph yang disimpan
    public void printGraph(){
        for (int node : adjacencyList.keySet()){
            System.out.print("Node " + node + " terhubung dengan node: ");
            for (int neighbor : adjacencyList.get(node)){
                System.out.print(neighbor+ " ");
            }
            System.out.println();
        }
    }

    // methode main untuk menjalankan program
    public static void main(String[] args){
        // membuat objek graph dari class SimpleGraph
        SimpleGraph graph = new SimpleGraph();

        // menambah dan membuat node
        graph.addnode(0);
        graph.addnode(1);
        graph.addnode(2);
        graph.addnode(3);
        graph.addnode(4);

        // membuat edge
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(0, 4);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(4, 0);

        // mencetak graph
        graph.printGraph();
    }
}

