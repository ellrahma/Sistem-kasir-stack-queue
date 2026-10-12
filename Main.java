import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int pilihan;

        System.out.println("===== SISTEM KASIR TOKO =====");
        System.out.println("Minimal 5 pelanggan dimasukkan ke antrian.");

        // Mengisi minimal 5 pelanggan sesuai spesifikasi kasus
        while (antrian.getJumlah() < 5) {
            System.out.println("\nPelanggan ke-" + (antrian.getJumlah() + 1));

            System.out.print("Masukkan Nomor Antrian: ");
            String nomor = sc.nextLine().trim();

            System.out.print("Masukkan Nama Pelanggan: ");
            String nama = sc.nextLine();

            double total;
            do {
                System.out.print("Masukkan Total Belanja: ");
                while (!sc.hasNextDouble()) {
                    System.out.print("Total belanja harus berupa angka: ");
                    sc.next();
                }
                total = sc.nextDouble();
                sc.nextLine();

                if (total < 0) {
                    System.out.println("Total belanja tidak boleh negatif.");
                }
            } while (total < 0);

            antrian.enqueue(nomor, nama, total);
            System.out.println("Data pelanggan ditambahkan ke antrian!");
        }

        do {
            System.out.println("\n===== SISTEM KASIR TOKO =====");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            while (!sc.hasNextInt()) {
                System.out.print("Input harus berupa angka. Pilih menu: ");
                sc.next();
            }
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    String nomor = sc.nextLine().trim();

                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = sc.nextLine();

                    double total;
                    do {
                        System.out.print("Masukkan Total Belanja: ");
                        while (!sc.hasNextDouble()) {
                            System.out.print("Total belanja harus berupa angka: ");
                            sc.next();
                        }
                        total = sc.nextDouble();
                        sc.nextLine();

                        if (total < 0) {
                            System.out.println("Total belanja tidak boleh negatif.");
                        }
                    } while (total < 0);

                    antrian.enqueue(nomor, nama, total);
                    System.out.println("Data pelanggan ditambahkan ke antrian!");
                    break;

                case 2:
                    Node pelanggan = antrian.dequeue();

                    if (pelanggan == null) {
                        System.out.println("Antrian kosong. Tidak ada pelanggan untuk dilayani.");
                    } else {
                        System.out.println("Melayani pelanggan "
                                + pelanggan.nomorAntrian + " ("
                                + pelanggan.namaPelanggan + ")");
                        riwayat.push(pelanggan);
                        System.out.println("Transaksi disimpan ke riwayat.");
                    }
                    break;

                case 3:
                    antrian.display();
                    break;

                case 4:
                    riwayat.display();
                    break;

                case 5:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilihan != 5);

        sc.close();
    }
}
