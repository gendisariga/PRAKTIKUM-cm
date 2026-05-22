public class NodePembeli {
    // Node untuk Double Linked List pembeli (antrian)
    int noAntrian;         // nomor antrian
    Pembeli pembeli;       // data pembeli
    NodePembeli prev;      // pointer ke node sebelumnya
    NodePembeli next;      // pointer ke node berikutnya
    // constructor node
    NodePembeli(NodePembeli prev,
                int noAntrian,
                Pembeli pembeli,
                NodePembeli next) {

        this.prev = prev;
        this.noAntrian = noAntrian;
        this.pembeli = pembeli;
        this.next = next;
    }
}
