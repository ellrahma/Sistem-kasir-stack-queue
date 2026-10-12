// Struktur Stack dengan prinsip LIFO
class Stack {
    private Node top;
    private int jumlah;

    // Menyimpan transaksi terbaru di bagian atas stack
    public void push(Node transaksi) {
        transaksi.next = top;
        top = transaksi;
        jumlah++;
    }

    // Mengambil transaksi paling atas
    public Node pop() {
        if (top == null) {
            return null;
        }

        Node hasil = top;
        top = top.next;
        hasil.next = null;
        jumlah--;
        return hasil;
    }

    // Menampilkan transaksi dari terbaru ke lama
    public void display() {
        if (top == null) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        Node current = top;
        System.out.println("\nRiwayat Transaksi (Terbaru ke Lama):");
        while (current != null) {
            System.out.printf("Nomor: %s | Nama: %s | Total: Rp%.0f%n",
                    current.nomorAntrian, current.namaPelanggan,
                    current.totalBelanja);
            current = current.next;
        }
        System.out.println("Total transaksi: " + jumlah);
    }
}
