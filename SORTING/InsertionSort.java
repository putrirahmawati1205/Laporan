
package SORTING;

// membuat class untuk insertion sort
public class InsertionSort {

    // methode mian untuk menjalankan program
    public static void main(String[] args) {

        // deklarasi dan inisialisasi array
        int[] arr = {7, 3, 9, 2, 12, 10, 1, 5};
        // menyimpan panjang array
        int n = arr.length;

        // perulangan untuk iterasi melalui seluruh array
        for ( int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // memindahkan elemen-elemen yang lebih besar dari "key" ke posisi yang lebih besar dalam array
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        // menampilkan array yang sudah diurutkan
        printArray(arr);
    }

    // methode print untuk menampilkan hasil array setelah pengurutan selesai
        static void printArray(int arr[]) {
            int n= arr.length;
            System.out.println("Data setelah terurut: ");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }

}
