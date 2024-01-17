package TREE;
import java.util.LinkedList;
import java.util.Queue;


//Binary search tree (BST)
// membuat class binary search tree
public class BinarySearchTree {


    // class untuk node
    class Node {    
        int data; //deklarasi data yang disimpan
        Node left;  
        Node right;

        // @param data, data yang akan disimpan dalam node
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

    /*
     * methode untuk melakukan traversal preorder
     * @param root, root untuk node pohon
     */
    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


     /*
     * methode untuk melakukan traversal Inorder
     * @param root, root untuk node pohon
     */
    static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }


     /*
     * methode untuk melakukan traversal Postorder pohon
     * @param root, root untuk node pohon
     */
    static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    
     /*
     * methode untuk melakukan traversal levelorder pohon
     * @param root, root untuk node pohon
     */
    static void levelOrder(Node root) {
        // membuat object antrian yang menyimpan objek dari Node
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); 

        // memulai loop while yang akan terus berjalan selama antrian tidak kosong
        while (!queue.isEmpty()) {
            // mengambil dan menghapus elemen pertama dari antrian
            Node current = queue.poll();
            // mencetak data node saat ini
            System.out.print(current.data + " ");

            // kondisi dimana jika node memiliki anak kiri, akan ditambahkan anak kiri tersebut ke dalam antrian
            if (current.left != null) {
                queue.add(current.left);
            }
            // kondisi dimana jika node memiliki anak kanan, akan di tambahkan anak kanan tersebut bke dalam antrian
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // methode main untuk menjalankan code
    public static void main(String[] args) {
        // deklarasi dan inisialisasi objek class BinarySearchTree dengan objek TreeObject
        BinarySearchTree TreeObject = new BinarySearchTree();

                // membuat pohon BST
                Node root2 = TreeObject.new Node(50);
                root2.left = TreeObject.new Node(30);
                root2.right = TreeObject.new Node(70);
                root2.left.left = TreeObject.new Node(10);
                root2.left.right = TreeObject.new Node(35);
                root2.right.left = TreeObject.new Node(65);
                root2.right.right = TreeObject.new Node(80);

                // menampilkan struktur dari pohon
                System.out.println("\nModel Struktur folder:");
                printTree(root2, "", true);

                // mencetak/menampilkan hasil traversal
                System.out.println("\nPreOrder: ");
                preOrderTraversal(root2);
                System.out.println("\nInOrder: ");
                inOrderTraversal(root2);
                System.out.println("\nPostOrder");
                postOrderTraversal(root2);
                System.out.println("\nLevelOrder");
                levelOrder(root2);
            }
        }
