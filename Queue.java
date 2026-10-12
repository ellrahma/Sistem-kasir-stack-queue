// Struktur Queue dengan prinsip FIFO
class Queue {
    private Node front;
    private Node rear;
    private int jumlah;

    // Menambahkan pelanggan ke belakang antrian
    public void enqueue(String nomor, String nama, double total) {
        Node baru = new Node(nomor, nama, total);

        if (rear == null) {
            front = rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
        jumlah++;
    }

    // Mengambil pelanggan paling depan
    public Node dequeue() {
        if (front == null) {
            return null;
        }

        Node hasil = front;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        hasil.next = null;
        jumlah--;
        return hasil;
    }

    // Menampilkan isi antrian
    public void display() {
        if (front == null) {
            System.out.println("Antrian kosong.");
            return;
        }

        Node current = front;
        System.out.println("\nAntrian Saat Ini:");
        while (current != null) {
            System.out.printf("Nomor: %s | Nama: %s | Total: Rp%.0f%n",
                    current.nomorAntrian, current.namaPelanggan,
                    current.totalBelanja);
            current = current.next;
        }
        System.out.println("Total pelanggan dalam antrian: " + jumlah);
    }

    public int getJumlah() {
        return jumlah;
    }
}
