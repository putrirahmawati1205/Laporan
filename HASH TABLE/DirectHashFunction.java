
// class untuk hash dengan "table" sebagai struktur data untuk hash
class Hash {
    private int[] tabel;

    // konstruktor class hash dengan ukuran tertentu
    Hash(int size) {
        tabel = new int[size];
    }

    // methode untuk menyisipkan nilai kedalam table hash
    // nilai akan diambil dan akan dimasukkan kedalam table pada indeks tertentu
    void insert(int Nilai) {
        int indeks = Nilai;
        tabel[indeks] = Nilai;
        System.out.println("Angka: " + Nilai + " ditambahkan ke dalam indeks: " + indeks);
    }

    // methode untuk mencari nilai dalam table hash
    // terdapat kondisi dimana jika nilai pada indeks yang sesuai dengan nilai yang dicari, maka nilai ditemukan dan indeks dicetak
    // jika nilai yang dicari tidak sesuai, maka akan tampil pesan bahwa nilai tidak ditemukan
    void search(int Nilai) {
        if (tabel[Nilai] == Nilai) {
            System.out.print("\nAngka " + tabel[Nilai] + " berada pada indeks: " + Nilai);
            return;
        }
        System.out.print("\nAngka: " + Nilai + "  Tidak ada didalam tabel");
    }
}


class DirectHashFunctional{
    // clas main untuk menjalankan program
    public static void main(String[] args) {
            // membuat objek "table" dari kelas Hash dengan ukuran 200
            Hash tabel = new Hash(200);

            // input nilai kedalam table
            tabel.insert(199);
            tabel.insert(100);
            tabel.insert(128);
            tabel.insert(178);
            tabel.insert(199);

            // mencari nilai tertentu pada table
            tabel.search(178);
            tabel.search(128);
            tabel.search(180);

        }
    }


