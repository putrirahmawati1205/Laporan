
import java.util.LinkedList;

// membuat kelas untuk menyimpan table hash 
 class HashString {
    private LinkedList<String>[] tabel;

    // konstruktor membuat table hash dengan ukuran tertentu
    // setiap elemen table diinisialisasi sebagai objek "linkedlist"
    public HashString(int size) {
        tabel = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            tabel[i] = new LinkedList<>();
        }
    }

    // fungsi menghitung indeks hash berdasarkan karakter pertama dari string "key"
    // operasi (%) digunakan untuk memastikan agar indeks tetap berada dalam rentang ukuran table hash
    public int hashFunction(String key) {
        return key.charAt(0) % tabel.length;
    }

    // methode untuk menyisispkan nilai kedalam hash table
    // indeks dihitung menggunakan fungsi hash dan nilai ditambahkan kedalam linkedlist pada indeks tertentu
    public void insert(String value) {
        int indeks = hashFunction(value);
        tabel[indeks].add(value);
    }

    // methode mencari nilai dalam table hash
    // nilai dihitung dan akan dicari apakah nilai tersebut ada didalam linkedlist pada indeks tersebut
    public boolean search(String value) {
        int indeks = hashFunction(value);
        return tabel[indeks].contains(value);
    }

    // menampilkan nilai yang terdapat pada indeks hash tertentu
    // jika indeks dalam linkedlist tidak kosong, maka nilai akan dicetak. jika kosong, akan tampil pesan bahwa nilai tidak ditemukan
    public void tampil(String key) {
        int indeks = hashFunction(key);
        if(!tabel[indeks].isEmpty()){
            System.out.println("Nilai ditemukan: ");
            System.out.print("Nilai pada indeks " + indeks + " adalah ");
            for (String nilai : tabel[indeks]){
                System.out.print(nilai + " ");
            }
            System.out.println();
        }else {
            System.out.println("Nilai tidak ditemukan: ");
            System.out.println("Tidak ada nilai pada indeks " + indeks );
        }
    }
}


class main{
    public static void main(String[] args) {
        // methode main dnegan objek hashstring yang dibuat dengan ukuran 150
        HashString hashTable = new HashString(150);

        // input nilai kedalam table
        hashTable.insert("tujuh puluh lima");
        hashTable.insert("seratus dua puluh lima");

        // digunakan untuk menampilkan nilai pada indeks hash yang dihasilkan dari karakter 's'
        hashTable.tampil("s");
    }
}
