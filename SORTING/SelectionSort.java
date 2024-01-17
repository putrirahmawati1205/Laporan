package SORTING;


//mengurutkan secara ascending (dari nilai terbesar)
public class SelectionSort {

  // methode main untuk menjalankan program
    public static void main(String[] args) {

      // deklarasi dan inisialisasi array "arr" dengan beberapa bilangan bulat
        int[] arr= {22, 2, 90, 25, 20, 30, 6, 3};
        int n= arr.length;
        
        // implementasi selection sort
        // menentukan elemen terkecil diantara elemen yang belum diurutkan dan menukarkan posisinya
        for (int i=0; i < n-1; i++){

          // insialisasi indeks elemen terkecil
          int indeks = i;

          // mencari elemen terkecil diantar elemen yang  belum diurutkan
          // membandingkan nilai elemen pada indeks "j" dengan elemen pada indeks "indeks". 
          // jika nilai pada "j" lebih kecil, maka "indeks" diupdate dengan nilai "j"
          for (int j= i+1; j<n; j++){
              if (arr[j] < arr[indeks]){
                indeks=j;
              }
          }

          // menukarkan elemen terkecil dengan elemen yang ada di "i"
          int tmp= arr[indeks];
          arr[indeks] = arr[i];
          arr[i] = tmp;
        }


        // menampilkan data yang sudah diurutkan
        System.out.println("Data yang sudah diurutkan: ");
        for (int i=0; i<n; i++){
            System.out.print(arr[i] + " ");

        }

    }
}
