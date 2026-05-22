public class NodePesanan {
    // Node untuk Double Linked List pesanan
    Pesanan pesanan;     // data pesanan
    NodePesanan prev;    // node sebelumnya
    NodePesanan next;    // node berikutnya
    // constructor
    NodePesanan(NodePesanan prev,
                Pesanan pesanan,
                NodePesanan next) {

        this.prev = prev;
        this.pesanan = pesanan;
        this.next = next;
    }
}