package TREE;

import java.util.LinkedList;
import java.util.Queue;

//BST String
// class untuk tree node
class TreeNode {
    // deklarasi data yang disimpan
    String data;    
    TreeNode left;
    TreeNode right;

    // @param data, data yang akan disimpan dalam node
    public TreeNode(String data) {
        this.data = data;
        left = right = null;
    }
}

// class untuk Binary search tree buah
class BSTbuah {
    TreeNode root;

    public BSTbuah() {
        root = null;
    }

    // Metode untuk menyisipkan node baru dalam BST
    public TreeNode insert(TreeNode root, String data) {
        // pengecekan apakah node saat ini (root) adalah null/tidak ada
        // jika kosong, amka akan dibuatkan node baru dibuat dan akan diatur sebagai root
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        // pengecekan apakah data yang disisipkan lebih kecil dari data saat ini
        // jika iya, maka akan dipanggil pada subtree kiri
        if (data.compareTo(root.data) < 0) {
            root.left = insert(root.left, data);
        
        // pengecekan apakah data yang disispkan lebih besar dari data saat ini
        // jika iya, makan akan dipangil pada subtree kanan
        } else if (data.compareTo(root.data) > 0) {
            root.right = insert(root.right, data);
        }
        // mengembalikan node saat ini setelah penyisipan dilakukan
        return root;
    }

    // Metode untuk melakukan traversal preorder
    public void preorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }

    // Metode untuk melakukan traversal inorder
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    // Metode untuk melakukan traversal postorder
    public void postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Metode untuk melakukan traversal level-order
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // membuat objek antrian "queue" yang akan menyimpan objek dari tipe "TreeNode"
        // linkedlist mendukung operasi (enqueue) penambahan elemen diakhir antrian dan (dequeue) pengambilan elemen dari depan antrian
        Queue<TreeNode> queue = new LinkedList<>();
        // menambahkan node root kedalam antrian
        queue.add(root);

        // memulai loop while yang akan berjalan terus selama antrian tidak kosong
        while (!queue.isEmpty()) {
            // mengambil dan menghapus elemen pertama dalam antrian dan akan diproses
            TreeNode current = queue.poll();
            // mencetak data dari node saat ini
            System.out.print(current.data + " ");

            // jika node saat ini memiliki anak kiri, maka tambahkan kedalam antrian
            if (current.left != null) {
                queue.add(current.left);
            }

            // jika node saat ini memiliki anak kanan, maka tambahkan kedalam antrian 
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /* 
     * methode untuk mencetak struktur pohon
     * @param root , root node dari pohon
     * @param prefix , untuk awalan setiap baris
     * @param isLeft, menentukan apakah node termasuk anak kiri
    */
    public static void printTreeStructure(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.data);
            printTreeStructure(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTreeStructure(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // methode main untuk menjalankan code
    public static void main(String[] args) {
        // deklarasi dan inisialisasi objek class BSTbuah dengan objek Tree
        BSTbuah tree = new BSTbuah();

        // membuat pohon
        tree.root = tree.insert(tree.root, "mango");
        tree.root = tree.insert(tree.root, "apple");
        tree.root = tree.insert(tree.root, "banana");
        tree.root.right = tree.insert(tree.root.right, "orange");
        tree.root.right = tree.insert(tree.root.right, "grapes");
        tree.root.right.right = tree.insert(tree.root.right.right, "pineapple");
        tree.root = tree.insert(tree.root, "peach");

        // Struktur Pohon
        System.out.println("Struktur Pohon:");
        printTreeStructure(tree.root, "", true);

        // Cetak Hasil Traversal
        System.out.println("\nPreorder Traversal:");
        tree.preorderTraversal(tree.root);

        System.out.println("\n\nInorder Traversal:");
        tree.inorderTraversal(tree.root);

        System.out.println("\n\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);

        System.out.println("\n\nLevel-order Traversal:");
        tree.levelOrderTraversal(tree.root);
    }
}