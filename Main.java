import java.util.Scanner;

// class utama program
public class Main {

    // method untuk menampilkan menu utama program
    static void menu() {

        System.out.println("======================================");
        System.out.println("SISTEM ANTRIAN ROYAL DELISH");
        System.out.println("======================================");

        // daftar menu program
        System.out.println("1. Tambah Antrian");
        System.out.println("2. Cetak Antrian");
        System.out.println("3. Hapus Antrian dan Pesan");
        System.out.println("4. Laporan Pesanan");
        System.out.println("0. Keluar");
    }

    // method utama program
    public static void main(String[] args) {

        // object scanner untuk input user
        Scanner sc = new Scanner(System.in);

        // object Double Linked List untuk antrian pembeli
        DoubleLinkedListPembeli antrian =
                new DoubleLinkedListPembeli();

        // object Double Linked List untuk data pesanan
DoubleLinkedListPesanan pesananList =
        new DoubleLinkedListPesanan();

        // ==========================================
        // KODE TAMBAHAN
        // Menambahkan 4 data dummy pembeli
        // agar antrean langsung terisi otomatis
        // ==========================================

            antrian.tambahAntrian(
            new Pembeli("Andi", "0811111111"));

            antrian.tambahAntrian(
            new Pembeli("Budi", "0822222222"));

            antrian.tambahAntrian(
            new Pembeli("Citra", "0833333333"));

            antrian.tambahAntrian(
            new Pembeli("Dina", "0844444444"));

// variabel pilihan menu
int pilih;

        // perulangan program
        do {

            // menampilkan menu
            menu();

            // input pilihan menu
            System.out.print("Pilih menu : ");
            pilih = sc.nextInt();
            sc.nextLine();

            // seleksi menu menggunakan switch case
            switch (pilih) {

                // ==============================
                // CASE 1 → TAMBAH ANTRIAN
                // ==============================
                case 1:

                    System.out.println();

                    // input nama pembeli
                    System.out.print("Nama Pembeli : ");
                    String nama = sc.nextLine();

                    // input nomor HP pembeli
                    System.out.print("No HP        : ");
                    String hp = sc.nextLine();

                    // membuat object pembeli
                    Pembeli p = new Pembeli(nama, hp);

                    // menambahkan pembeli ke antrian
                    antrian.tambahAntrian(p);

                    break;

                // ==============================
                // CASE 2 → CETAK ANTRIAN
                // ==============================
                case 2:

                    System.out.println();

                    // menampilkan seluruh antrian pembeli
                    antrian.cetakAntrian();

                    break;

                // ==========================================
                // CASE 3 → HAPUS ANTRIAN DAN BUAT PESANAN
                // ==========================================
                case 3:

                    System.out.println();

                    // mengambil pembeli paling depan
                    Pembeli pembeli = antrian.hapusAntrian();

                    // jika antrian kosong
                    if (pembeli == null) {

                        System.out.println("Antrian kosong");

                    } else {

                        // input kode pesanan
                        System.out.print("Kode Pesanan : ");
                        int kode = sc.nextInt();
                        sc.nextLine();

                        // input nama menu pesanan
                        System.out.print("Nama Pesanan : ");
                        String namaPesanan = sc.nextLine();

                        // input harga pesanan
                        System.out.print("Harga        : ");
                        int harga = sc.nextInt();
                        sc.nextLine();

                        // membuat object pesanan
                        Pesanan pesanan =
                                new Pesanan(kode,
                                        namaPesanan,
                                        harga);

                        // menambahkan pesanan ke linked list
                        pesananList.tambahPesanan(pesanan);

                        // menampilkan informasi pesanan
                        System.out.println();

                        System.out.println(
                                pembeli.namaPembeli
                                + " telah memesan "
                                + namaPesanan);
                    }

                    break;

                // ==============================
                // CASE 4 → LAPORAN PESANAN
                // ==============================
                case 4:

                    System.out.println();

                    // menampilkan laporan pesanan
                    pesananList.laporanPesanan();

                    break;

                // ==============================
                // CASE 0 → KELUAR PROGRAM
                // ==============================
                case 0:

                    System.out.println();

                    // menampilkan pesan program selesai
                    System.out.println("Program selesai");

                    break;

                // jika input menu tidak tersedia
                default:

                    System.out.println("Menu tidak tersedia");
            }

            System.out.println();

            // program berjalan sampai pilih = 0
        } while (pilih != 0);
    }
}
    

