
import java.util.Scanner; //menggunakan fungsi scanner

// membuat kelas Binary Search
public class BinarySearch {
    public static int binarySearch(int[] arr, int NilaiTarget) {    //mendeklarasikan data array dan data nilai ynag dicari atau target
        int NilaiAwal = 0;   //nilai awal sama dengan 0
        int NilaiAkhir = arr.length - 1;    //nilai akhir sama dengan panjang array - 1

        //dilakukan perulangan kondisi
        //dimana kondisi akan berjalan selama Nilai awal kecil sama dengan nilai akhir
        while (NilaiAwal <= NilaiAkhir) {
            int mid = ((NilaiAwal + NilaiAkhir) / 2);    //proses perhitungan dalam menemukan mid/nilai tengah

            //kondisi jika nilai tengah sama dengan nilai yang dicari
            if (arr[mid] == NilaiTarget) {
                return mid;     //jika ditemukan maka akan mengembalikan indeks mid sebagai hasil

                //kondisi jika nilai tengah kurang dari nilai yang di cari
                // maka nilai yang di cari ada di sebelah kanan (akan di +)
            } else if (arr[mid] < NilaiTarget) {
                NilaiAwal = mid + 1;

                //sebaliknya jika nilai tengah lebih dari nilai yang dicari maka nilainya ada disebelah kiri (akan di -)
            } else {
                NilaiAkhir = mid - 1;
            }
        }
        return -1 ; //menegembalikan nilai dari metode binarysearch ketika elemen yang dicari tidak ditemukan dalam array
    }

    //method main untuk menjalankan program
    public static void main(String[] args) {
        /*
         * inisialisasi arr yang menyimpan data
         * menggunakan scanner dengan nama "Data" untuk mengambil inputan
         */
        int [] arr = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90}; 
        Scanner Data = new Scanner(System.in); 

        /* 
         * menampilkan pesan perintah untuk memasukkan nilai yg dicari
         * mendeklarasikan variabel "nilai target" dan menyimpan nilai inputan
         *  mendeklarasikan variabel "indeks" menggunakan metode binarysearch untuk mencrai nilai target dalam array
        */
        System.out.print("masukkan nilai yang dicari: "); 
        int NilaiTarget = Data.nextInt(); 
        int Indeks = binarySearch(arr, NilaiTarget);

        // kondisi yang memeriksa indeks tidak sama dengan -1 dan berarti elemen yang di cari ditemukan, sehingga menmpilkan pesan nilai target ditemukan.
        // kondisi dimana indeks sama dengan -1 dan akan menampilkan pesan nilai target tidak ditemukan
        if (Indeks != -1){ 
            System.out.println("Nilai " + NilaiTarget + " telah ditemukan pada indeks: " + Indeks);

        } else { 
            System.out.println("Nilai " + NilaiTarget + " tidak ditemukan");
        }
    }
}