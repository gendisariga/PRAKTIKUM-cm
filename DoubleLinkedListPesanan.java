// Class untuk mengelola data pesanan menggunakan Double Linked List
public class DoubleLinkedListPesanan {

    NodePesanan head; // node pertama (awal list)
    NodePesanan tail; // node terakhir (akhir list)

    // method untuk menambah pesanan ke dalam list
    public void tambahPesanan(Pesanan pesanan) {

        // membuat node baru berisi data pesanan
        NodePesanan newNode =
                new NodePesanan(null,
                        pesanan,
                        null);

        // jika list masih kosong
        if (head == null) {
            head = tail = newNode;
        }
        // jika sudah ada data
        else {
            tail.next = newNode;   // hubungkan tail ke node baru
            newNode.prev = tail;   // hubungkan balik ke tail lama
            tail = newNode;       // update tail ke node baru
        }
    }

    // method untuk mengurutkan pesanan berdasarkan nama (A-Z)
    public void sortingPesanan() {

        // jika list kosong, tidak perlu sorting
        if (head == null) {
            return;
        }

        // bubble sort pada linked list
        for (NodePesanan i = head;
                i.next != null;
                i = i.next) {

            for (NodePesanan j = i.next;
                    j != null;
                    j = j.next) {

                // membandingkan nama pesanan (case insensitive)
                if (i.pesanan.namaPesanan.compareToIgnoreCase(
                        j.pesanan.namaPesanan) > 0) {

                    // tukar isi data pesanan (bukan node)
                    Pesanan temp = i.pesanan;
                    i.pesanan = j.pesanan;
                    j.pesanan = temp;
                }
            }
        }
    }

    // method untuk menampilkan laporan pesanan
    public void laporanPesanan() {

        // sebelum ditampilkan, data diurutkan dulu
        sortingPesanan();

        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("======================================");

        // header tabel
        System.out.printf("%-15s %-20s %-10s\n",
                "Kode Pesanan",
                "Nama Pesanan",
                "Harga");

        NodePesanan current = head; // mulai dari awal list

        // traversal sampai akhir list
        while (current != null) {

            // cetak data pesanan
            System.out.printf("%-15d %-20s %-10d\n",
                    current.pesanan.kodePesanan,
                    current.pesanan.namaPesanan,
                    current.pesanan.harga);

            current = current.next; // pindah ke node berikutnya
        }
    }
}
