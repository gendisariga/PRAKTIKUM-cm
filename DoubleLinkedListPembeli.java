public class DoubleLinkedListPembeli { // Class untuk mengelola antrian pembeli (Double Linked List)

    NodePembeli head;   // awal antrian
    NodePembeli tail;   // akhir antrian

    int nomor = 1;      // nomor antrian otomatis

    // tambah pembeli ke antrian
    public void tambahAntrian(Pembeli pembeli) {

        NodePembeli newNode =
                new NodePembeli(null,
                        nomor,
                        pembeli,
                        null);

        nomor++; // nomor antrian bertambah

        // jika antrian kosong
        if (head == null) {
            head = tail = newNode;
        } 
        // jika sudah ada data
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        System.out.println();
        System.out.println("Antrian berhasil ditambahkan dengan nomor: "
                + newNode.noAntrian);
    }

    // mencetak semua antrian
    public void cetakAntrian() {

        if (head == null) {
            System.out.println("Antrian kosong");
            return;
        }

        System.out.println("======================================");
        System.out.println("Daftar Antrian Pembeli");
        System.out.println("======================================");

        System.out.printf("%-12s %-15s %-15s\n",
                "No Antrian",
                "Nama",
                "No HP");

        NodePembeli current = head;

        // traversal dari head ke tail
        while (current != null) {
            System.out.printf("%-12d %-15s %-15s\n",
                    current.noAntrian,
                    current.pembeli.namaPembeli,
                    current.pembeli.noHp);

            current = current.next;
        }
    }

    // hapus antrian paling depan (FIFO)
    public Pembeli hapusAntrian() {

        if (head == null) {
            return null;
        }

        // simpan data pembeli di head
        Pembeli data = head.pembeli;

        // geser head ke node berikutnya
        head = head.next;

        // jika masih ada node, putuskan link prev
        if (head != null) {
            head.prev = null;
        }

        return data;
    }
}
    

