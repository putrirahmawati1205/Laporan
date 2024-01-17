
// membuat class untuk StepHash
public class StepHash {

    /*  
     * mendeklarasikan array "table" sebagai table hash
     * mendeklarasikan variable "step" untuk menunjukkan langkah untuk menangani kolisi dan diinisialisasi dengan nilai 1 
     * mendeklarasikan konstruktor untuk kelas "StepHash"
     * menciptakan table hash dengan ukuran/size yang diberikan
    */
    private int[]table;
    private int step=1;
    public StepHash(int size){
        table=new int[size];
    }

    // mendeklarasikan methode 'insert' untuk memasukkan nilai kedalam table hash
    public void insert(int value){

        /*
         * menghitung indeks menggunakan fungsi hash sederhana
         */
        int indeks=value%table.length;

      
        // perulangan jika indeks yang dihasilkan sudah terisi terjadi kolisi
        while(table[indeks] !=0){

            /*
             * mencetak pesan bahwa terjadi kolisi pada indeks tertentu
             * menggunakan langkah/step untuk mencari indeks yang kosong
             * mencetak pesan bahwa indeks digeser
             */
            System.out.println(" Terjadi collusion pada indeks: " + indeks);
            indeks=(indeks+step) % table.length;
            System.out.println("Indeks digeser ke: " + indeks);
        }

        /*
         * input nilai kedalam table pada indeks yang telah dihitung
         * mencetak baris baru
         * mencetak pesan bahwa data dimasukkan ke indeks tertentu
         */
        table[indeks]=value;
        System.out.print("\n");
        System.out.print("Data dimasukkan kedalam indeks: "+ indeks);
    }


    public int search(int value){
        // menghitung indeks awal menggunakan fungsi hash
        int indeks = value % table.length;
    
        // perulangan yang berlanjut selama slot pada indeks yang dihitung sudah terisi (kolisi)
        while (table[indeks]!=0){

            // kondisi memeriksa apakah nilai pada indeks saat ini cocok dengan nilai target.
            // jika benar, mengembalikan indeks
            if (table[indeks]==value){
                return indeks;
            }
            indeks=(indeks + step) % table.length;
        }
        // jika loop selesai tanpa menemukan nilai target, mengembalikan -1, menandakan bahwa nilai tidak ada didalam table
        return -1;
    }

    // methode main untuk menjalankan program
    public static void main(String[] args) {
        // membuat objek baru "StepHash" degan table hash dengan panjang 15
        StepHash stepHash = new StepHash(15);

        // menyisipkan nilai ke dalam table hash
        stepHash.insert(7);
        stepHash.insert(7);
        stepHash.insert(14);
        stepHash.insert(25);
        stepHash.insert(10);

        // melakukan pencarian terhadap table dan mencetak indeks tempat nilai yang ditemukan
        System.out.println("\n");
        System.out.println("Nilai 7 berada pada indeks: " + stepHash.search(7));
        System.out.println("Nilai 14 berada pada indeks: " + stepHash.search(14));
        System.out.println("Nilai 25 berada pada indeks: " + stepHash.search(25));


    }

}
