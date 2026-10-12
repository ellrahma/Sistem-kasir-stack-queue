// Node untuk menyimpan data pelanggan/transaksi
class Node {
    String nomorAntrian;
    String namaPelanggan;
    double totalBelanja;
    Node next;

    Node(String nomorAntrian, String namaPelanggan, double totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}
