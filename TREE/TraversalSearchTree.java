package TREE;
import java.util.LinkedList;
import java.util.Queue;
public class TraversalSearchTree{

    // kelas node untuk memrepresentasikan sebuah node dalam binary tree
    class Node {
        int data; //deklarasi data yang disimpan
        Node left; //anak kiri
        Node right; //anak kanan

        //@param data Data yang akan disimpan dalam node
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

     /* 
     * methode untuk mencetak struktur pohon
     * @param root , root node dari pohon
     * @param prefix , untuk awalan setiap baris
     * @param isLeft, menentukan apakah node termasuk anak kiri
    */
    static void printTree(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.data);
            if (root.left != null || root.right != null) {
                printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
                printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
            }
        }
    }

    //methode untuk membuat preorder tranversal
    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
      }

    //methode untuk membuat in order tranversal
    static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    //methode untuk membuat post Order tranversal
    static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    //methode untuk membuat level order tranversal
    static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        // menambahkan node root kedalam antrian
        queue.add(root);

        // memulai loop while yang akan berjalan terus selama antrian tidak kosong
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            // mencetak data dari node saat ini
            System.out.print(current.data + " ");

            // jika node saat ini memiliki anak kiri, maka akan ditambahkan kedalam antrian dan akan diproses
            if (current.left != null) {
                queue.add(current.left);
            }

            // jika node saat ini memiliki anak kanan, maka akan ditambahkan kedalam antrian dan akan diproses
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TraversalSearchTree TreeObject = new TraversalSearchTree(); 

        //membuat pohon dari inputan node
       TraversalSearchTree.Node root = TreeObject.new Node(1);
        root.left = TreeObject.new Node(2);
        root.right = TreeObject.new Node(3);
        root.left.left = TreeObject.new Node(4);
        root.left.right = TreeObject.new Node(5);
        root.right.left = TreeObject.new Node(6);
        root.right.right = TreeObject.new Node(7);
        root.left.left.left = TreeObject.new Node(8);
        root.left.right.left = TreeObject.new Node(9);
        root.right.left.left = TreeObject.new Node(10);

        // Struktur Pohon
        System.out.println("\nModel Struktur folder:");
        printTree(root, "", true);

        //print hasil dari traversal
        System.out.println("\nPreOrder: ");
        preOrderTraversal(root);
        System.out.println("\nInOrder: ");
        inOrderTraversal(root);
        System.out.println("\nPostOrder");
        postOrderTraversal(root);
        System.out.println("\nLevelOrder");
        levelOrder(root);
    }
}
