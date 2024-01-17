package SORTING;

// membuat kelas string character
public class StringCharacter {

    // mothode utama yang akan dieksekusi saat program dijalankan
    public static void main(String[] args) {
 
        // deklarasi dan inisialisasi array string "strings" dengan beberapa string sebagai elemen
        String[] strings = {"Belimbing", "Anggur", "Jeruk", "Apel", "Bengkuang"};
        // memanggil methode "sort" untuk mengurutkan array "strings"
        sort(strings); 

        // perulangan untuk menampilkan hasil setiap elemen
        for (String string : strings) {
            System.out.println(string);

        }
    }

    // proses pengurutandngan bubble sort
    // sort mengimplementasikan algoritma pengurutan gelembung
    static void sort(String[] arr) {
        
        // loop pertama (i) untuk iterasi sebanyak jumlah elemen dalam array kurang satu
        // loop kedua (j) untuk membandingkan dan menukar elemen secara berurutan
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j+1]
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
