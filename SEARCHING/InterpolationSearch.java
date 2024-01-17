import java.util.Scanner; //menggunakan scanner dalam program

//deklarasi kelas InterpolationSearch
public class InterpolationSearch {

    //deklarasi metode yang akan melakukan pencarian secara interpolation
    //ada dua paramenter, integer array 'arr' nilai yang dicari dan nilai target 'find'
    public static int interpolationSearch(int[] arr, int find) {
        //inisialisasi variable 'low' dan 'high' untuk menunjukkan batasan
        int low = 0;
        int high = arr.length - 1;

        //perulangan untuk melakukan interpolasi
        //perulangan akan terus berjalan selama "low" kurang dari sama dengan 'high'
        // dan niai 'find' berada dalam rentangan antara 'arr[low]' dan 'arr[high]'
        while (low <= high && find >= arr[low] && find <= arr[high]) {
            /*
             * low-> nilai indeks paling bawah
             * high-> nilai indeks paling tinggi
             * find-> nilai terget
             * arr[low] -> nilai/elemen/data terendah
             * arr[high] -> nilai/elemen/data tertinggi
             */
            int mid = low + ((high - low) * (find - arr[low])) / (arr[high] - arr[low]); //rumus interpolation search

            //mengecek elemen/nilai diposisi mid(nilai tengah) sama dengan find(nilai terget)
            //jika "iya" maka mengembalikan indeks mid (nilai tengah)
            if (arr[mid] == find) {
                return mid;
            }

            //memperbarui niai 'low' artau 'high' sesuai dengan perbandingan elemen yang dicari 'find' dan 'arr[mid]'
            //jika kurang dari 'find', maka 'low akan di update
            //jika lebih besar dari 'find', maka 'high' yang akan diperbarui
            if (arr[mid] < find) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        //mengembalikan -1 menandakan elemen/nilai yang cari tidak ditemukan
        return -1;
    }

    //mendeklarasikan dan inisialisasi array 'arr' yang terdapat data yang akan dicari
    public static void main(String[] args) {
        int[] arr = {12, 15, 21, 23, 25, 40, 45, 55, 87, 90};

        //objek scanner dengan nama "Data" yang menerima inputan
        Scanner Data = new Scanner(System.in);

        //menampilkan pesan untuk memasukkan nilai target
        System.out.print("Masukkan Nilai target yang ingin dicari: ");

        //membaca inputan menggunakan 'nextInt()' dari scanner dan disimpan dalam variabel 'NilaiTarget'
        int NilaiTarget = Data.nextInt();

        //memanggil metode untuk mencari 'NilaiTarget' dalam array 'arr' dan disimpan hasilnya dalam variabel 'Indeks"
        int Indeks = interpolationSearch(arr, NilaiTarget);


        // menggunakan sebuah kondisi untuk menguji hasil pencarian
        //memeriksa apakah 'indeks' (indeks dari elemen yang ditemukan) tidak sama dengan '-1'
        //jika hasilnya tidak sama dengan '-1', elemen yang dicari 'NilaiTarget' ditemukan dalam array
        if (Indeks != -1) {
            //dan akan mencetak pesan bahwa elemen telah ditemukan di indeks tersebut
            System.out.println("Nilai " + NilaiTarget + " ditemukan di indeks " + Indeks);

            //namun, jika 'Indeks' sama dengan '-1', maka  program akan menjalankan pernyataan yang ada diblok 'else'
        } else {
            //dan akan mencetak pesan bahwa elemen tidak ditemukan
            System.out.println("Nilai " + NilaiTarget + " tidak ditemukan.");
        }

        //menutup program
        Data.close();
    }
}
