package SORTING;

// create class bubble sort
//ascending
public class BubbleSort {

    //membuat fungsi main untuk menjalankan program
    public static void main(String[] args) {

        //membuat array data tidak terurut
        int[] arr = {44, 33, 55, 22, 11};
        int n = arr.length; //panjang array dan menyimpan data dalam variabel n
        boolean urut; //memeriksa setiap data apakah akan dilakukan pengurutan data

        //perulangan
        //i=0 menjadi indeks atau penghitung pertama dalam loop
        //i<n-1 menjalankan loop selama i kurang dari n-1
        // i++ ekspresi untuk menaikkan nilai i setiap kali loop 
        for (int i = 0; i < n - 1; i++) {
            urut = false;

            //perulangan kedua yang akan berjalan sebanyak n-i-1 kali pada setiap proses dari loop pertama
            for (int j = 0; j < n - i - 1; j++) {

                //memeriksa elemen ini lebih besar dari elemen berikutnya apa tidak
                //jika kondisi terpenuhi, maka elemen akan ditukar untuk diurutkan
                if (arr[j] > arr[j + 1]) { 
                    int temp = arr[j];       //menyimpan elemen saat ini pada variabel sementara temp
                    arr [j] = arr [j + 1];   //mengganti nilai elemen saat ini dengan nilai berikutnya
                    arr [j + 1] = temp;      //mengganti niai selanjutnya dengan nilai awal yang disimpan pada variabel tem
                    urut = true;
                }
            }
            //jika sudah terpenuhi setiap perulangan, maka program akan diberhentikan
            if (!urut) {
                break;
            }
        }
        //perulangan untuk mencetak elemen yang telah terurut
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " "); //mencetak setiap elemen dari array yang terurut
        }
    }
}
