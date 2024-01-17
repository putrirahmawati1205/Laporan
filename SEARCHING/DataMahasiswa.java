import java.util.ArrayList;
import java.util.Scanner;

// Membuat class untuk mahasiswa
class Mahasiswa {
    // deklarasi nim, namamahasiswa, dan jurusan
    private String Nim;
    private String NamaMahasiswa;
    private String Jurusan;

    // konstruktor(methode) untuk membuat objek mahasiswa
    public Mahasiswa(String Nim, String NamaMahasiswa, String Jurusan) {
        this.Nim = Nim;
        this.NamaMahasiswa = NamaMahasiswa;
        this.Jurusan = Jurusan;
    }

    // getter untuk mengambil nilai NIM
    public String getNim() {
        return Nim;
    }

    // getter untuk mengambil nilai nama mahasiswa
    public String getNamaMahasiswa() {
        return NamaMahasiswa;
    }

    // getter untuk mengambil nilai jurusan
    public String getJurusan() {
        return Jurusan;
    }

    // methode tostring untuk menghasilkan representasi string objek mahasiswa
    public String toString() {
        return "Nim" + Nim + ", NamaMahasiswa" + NamaMahasiswa + ", Jurusan" + Jurusan;
    }
}


// kelas untuk data mahasiswa
public class DataMahasiswa {
    // methode pencarian dengan squential search untuk mencari data mahasiswa berdasarkan nim
    public static int SquentialSearch(ArrayList<Mahasiswa> List, String NimTarget) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getNim().equals(NimTarget)) {
                return i;
            }
        }
        return -1;
    }

    //methode pencarian dengan binnary seacrh untuk mencari mahasiswa berdasarkan Nim
    public static int BinarySearch(ArrayList<Mahasiswa> List, String NimTarget) {
        int low = 0;
        int high = List.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (List.get(mid).getNim().compareTo(NimTarget) < 0) {
                low = mid + 1;
            } else if (List.get(mid).getNim().compareTo(NimTarget) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //mencari mahasiswa dengan interpolation search
    // mencari dengan Nim target
    public static int InterpolationSearch(ArrayList<Mahasiswa> List, String NimTarget) {
        int low = 0;
        int high = List.size();

        while (low <= high && NimTarget.compareTo(List.get(low).getNim()) >= 0 && NimTarget.compareTo(List.get(high).getNim()) <= 0) {
            int Position = low + (((int) (high - low) / (List.get(high).getNim().compareTo(List.get(low).getNim()))))
                    * (NimTarget.compareTo(List.get(low).getNim()) - low);
            if (List.get(Position).getNim().compareTo(NimTarget) < 0) {
                low = Position + 1;
            } else if (List.get(Position).getNim().compareTo(NimTarget) > 0) {
                high = Position + 1;
            } else {
                return Position;
            }
        }
        return -1;
    }

    //tampilan header tabel data dari mahasiswa
    public static void HeaderTabelMhs() {
        System.out.printf("+-------------------+-------------------------+---------------------+%n");
        System.out.printf("+        NIM        |   NAMA MAHASISWA        |        JURUSAN      |%n");
        System.out.printf("+-------------------+-------------------------+---------------------+%n");

    }

    //Menu Tampilan Utama
    // methode untuk menjalankan program
    public static void main(String[] args) {
        // membuat objek "scanner" dengan nama "scan" untuk membaca inputan dari pengguna
        Scanner scan = new Scanner(System.in);

        //membuat objek arraylist dengan nama "ListMahasiswa yang menyimpan data mhs
        ArrayList<Mahasiswa> ListMahasiswa = new ArrayList<>();
        // mendeklarasikan variable boolean dengan "continueInput" dan menginisialisasikan dengan nilai "true"
        boolean continueInput = true;

        //perulangan yang berjalan selama nilai variable "continueInput" adalah "true"
        // perulangan ini akan terus berjalan hingga dimana pengguna memilih menu keluar dari program
        while (continueInput) {
            System.out.println("Menu Utama");
            System.out.println("1. Tambahkan Data Mahasiswa");
            System.out.println("2. Tampilkan Semua Data Mahasiswa");
            System.out.println("3. Hapus Data Mahasiswa");
            System.out.println("4. Pencarian Data Mahasiswa-Squential Search");
            System.out.println("5. Pencarian Data Mahasiswa-Binnary Search");
            System.out.println("6. Pencarian Data Mahasiswa-Interpolation Search");
            System.out.println("Keluar");
            System.out.println("Pilih Opsi: ");

            //menerima dan membaca inputan dari pengguna menggunakan objek "scanner"
            int Pilih = scan.nextInt();
            scan.nextLine(); //mengosongkan ruang

            // membuka blok switch untuk menevaluasi niai dari "pilih" (pilihan dari pengguna)
            switch (Pilih) {

                // jika pengguna memilih 1, maka program akan menjalankan proses untuk menambahkan data mahasiswa
                // pada bagian ini, akan dimintai untuk memasukkan nim, nama mahasiswa, dan jurusan
                case 1:
                    // Tambah data mhs
                    System.out.println("Masukkan Nim: ");
                    // membaca inputan NIM dan menyimpan dalam variable "Nim"
                    String Nim = scan.nextLine();
                    // membaca inputan Nama mahasiswa dan menyimpan dalam variable "Nama"
                    System.out.println("Masukkan Nama: ");
                    String NamaMahasiswa = scan.nextLine();
                    System.out.println("Masukkan Jurusan: ");
                    // membaca inputan jurusan mahasiswa dan menyimpan dalam variable "jurusan"
                    String Jurusan = scan.nextLine();

                    // menambahkan data mahasiswa ke arraylist
                    ListMahasiswa.add(new Mahasiswa(Nim, NamaMahasiswa, Jurusan));
                    // mengakhiri blok "case" untuk pilihan 1
                    break; 


                // jika pengguna pilih 2, maka prograam akan menjalankan proses untuk menampilkan semua data mahasiswa
                case 2:
                    // memanggil fungsi "headertablemhs()" untuk menampilkan header tabel yang berisi kolom (NIM,Nama Mahasiswa, Jurusan) 
                    HeaderTabelMhs();

                    // perulangan untuk menampilkan data mahasiswa
                    for (Mahasiswa MHS : ListMahasiswa) {
                        System.out.printf("|%-18s |%-24s |%-20s | %n", MHS.getNim(), MHS.getNamaMahasiswa(), MHS.getJurusan());
                    }
                    
                    // menampilkan garis pembatas setelah semua data mahasiswa telah ditampilkan untuk memisahkan antar data
                    System.out.println("+-------------------+-------------------------+---------------------+");
                    break;


                // jika pengguna pilih 3, maka akan menghapus data mahasiswa berdasarkan indeks
                case 3:
                    System.out.println("masukkan indeks data mahasiswa yang akan dihapus: ");
                    int indeks = scan.nextInt();
                    if (indeks >= 0 && indeks < ListMahasiswa.size()) {
                        ListMahasiswa.remove(indeks);
                        System.out.println("Data Mahasiswa pada indeks " + indeks + "telah dihapus");
                    } else {
                        System.out.println("Indeks yang diberikan tidak benar");
                    }
                    break;

                 // jika pengguna pilih 4, maka akan mencari data mahasiswa dengan squential search
                 // pengguna akan dimintai untuk memasukkan NIM mahasiswa yang ingin dicari
                //  Jika data ditemukan, indeksnya ditampilkan. Jika tidak ditemukan, pesan bahwa data tidak ditemukan ditampilkan.
                case 4:
                    System.out.println("Masukkan Nim mahasiswa yang akan dicari: ");
                    String NimSeq = scan.nextLine();
                    int indeksSeq = SquentialSearch(ListMahasiswa, NimSeq);
                    if (indeksSeq != -1) {
                        System.out.println("Data Mahasiswa ditemukan pada indeks " + indeksSeq);
                        System.out.println(ListMahasiswa.get(indeksSeq));
                    } else {
                        System.out.println("Data Mahasiswa dengan NIM " + NimSeq + " tidak ditemukan");
                    }
                    break;


                // jika pengguna pilih 5, maka akan mencari data mahasiswa dengan binary search
                // pengguna akan dimintai untuk memasukkan NIM mahasiswa yang akan dicari
                // Jika data ditemukan, indeksnya ditampilkan. Jika tidak ditemukan, pesan bahwa data tidak ditemukan ditampilkan.
                case 5:
                    System.out.println("Masukkan Nim mahasiswa yang akan dicari: ");
                    String NimBin = scan.nextLine();
                    int indeksBin = BinarySearch(ListMahasiswa, NimBin);
                    if (indeksBin != -1) {
                        System.out.println("Data Mahasiswa ditemukan pada indeks " + indeksBin);
                    } else {
                        System.out.println("Data mahasiswa dengan NIM " + NimBin + " tidak ditemukan");
                    }
                    break;


                //  jika pengguna pilih 6, maka akan mencari data mahasiswa dengan interpolation Search
                // pengguna akan dimintai untuk memasukkan NIM mahasiswa yang akan dicari
                // Jika data ditemukan, indeksnya ditampilkan. Jika tidak ditemukan, pesan bahwa data tidak ditemukan ditampilkan.
                case 6:
                    System.out.println("Masukkan NIM yang di cari: ");
                    String NimInt = scan.nextLine();
                    int indeksInt = InterpolationSearch(ListMahasiswa, NimInt);
                    if (indeksInt != -1) {
                        System.out.println("Data mahasiswa ditemukan pada indeks " + indeksInt);
                        System.out.println(ListMahasiswa.get(indeksInt));
                    } else {
                        System.out.println("Data mahasiswa dengam Nim " + NimInt + " tidak ditemukan");
                    }
                    break;

                // jika pengguna pilih 7, maka akan menghentikan perulangan dan akan keluar dari program
                case 7:
                    continueInput = false;
                    break;
                default:
                
                    //menampilkan pesan jika pilihan tidak benar
                    System.out.println("Pilihan tidak benar"); 
            }
        }

        scan.close();
        //menampilkan pesan saat program berakhir
        System.out.println("Terima kasih telah menggunakan program ini.");
    }
}
