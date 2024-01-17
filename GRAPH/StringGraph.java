package GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * membuat class untuk StringGraph
 * adjacencyList untuk menyimpan daftar tetangga setiap simpul 
 */
public class StringGraph {
    private Map<String, List<String>> adjacencyList;

    // konstruktor utnuk mneginisialisasi adjacencyList sebagai objek
    public StringGraph(){
        adjacencyList=new HashMap<>();
    
    }

    // menambahkan node baru ke graph
    public void addnode(String node){
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // menambahkan edge dantara dua node
    public void addEdge (String source, String destination){
        adjacencyList.get(source).add(destination);
    }

    // mencetak garph dengan menampilkan daftarn tentangga setiap simpul
    public void printGraph(){
        for(String node : adjacencyList.keySet()){
            System.out.print("Node " + node + " terhubung dengan node: ");
            for(String neighbor : adjacencyList.get(node)){
                System.out.println(neighbor + " ");
            }
            System.out.println();
        }

    }

    // methode main untuk menjalankan program
    public static void main(String[] args) {
        // membuat objek graph dari class StringGraph
        StringGraph graph=new StringGraph();

        // menambahkan node
        graph.addnode("Bengkalis");
        graph.addnode("Pakning");
        graph.addnode("Pekanbaru");
        graph.addnode("Dumai");
        graph.addnode("Duri");

        // membuat edge antar node
        graph.addEdge("Bengkalis", "Pakning");
        graph.addEdge("Pakning", "Dumai");

    }
}
