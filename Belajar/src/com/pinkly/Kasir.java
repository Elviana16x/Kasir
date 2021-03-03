package com.pinkly;
// ini adalah library untuk pembuatan input
import java.util.Scanner;
// ini adalah class menu class yang akan diwariskan kedalam tiga class di bawah
class Menu {
    String nama_barang;
    int harga_barang;
    // ini adalah construktor akan dipanggil pertama kali pada saat objek dibuat
    Menu(String nama_barang, int harga_barang) {
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
    }
    // ini adalah fungsi untuk menampilkan isi objek
    void display() {
        System.out.println(this.nama_barang + " \t: RP." + this.harga_barang);
    }
}
// tiga class dibawah ini adalah class turunan dari class menu
// parameter construktor tiga class dibawah ini harus sama dengan yang di class menu
class Rokok extends Menu {
    Rokok(String nama_barang, int harga_barang) {
        super(nama_barang, harga_barang);
    }
}
class Kopi extends Menu {
    Kopi(String nama_barang, int harga_barang) {
        super(nama_barang, harga_barang);
    }
}
class Kacang extends Menu {
    Kacang(String nama_barang, int harga_barang) {
        super(nama_barang, harga_barang);
    }
}
public class Kasir {
    // ini adalah keyword untuk pembuatan input (dibuat statis agar tidak menyebabkan warning)
    static Scanner scan = new Scanner(System.in);
    static Scanner input = new Scanner(System.in);
    // ini adalah fungsi untuk melihat daftar menu
    static void Melihat_Daftar_Menu() {
        // membuat objek baru
        Rokok rokok = new Rokok("1. Rokok", 25000);
        Kopi koppi = new Kopi("2. Kopi", 10000);
        Kacang kacang = new Kacang("3. Kacang", 15000);
        // menampilkan objek
        rokok.display();
        koppi.display();
        kacang.display();
    }
    // ini adalah fungsi untuk memilih barang pada menu
    // dan melakukan perhitungan pembayaran jumlah barang yang dipilih pada menu
    static void Memilih_Daftar_Menu() {
        // pendeklarasian variabel ke semua data yang ada di dalam fungsi void ini
        // _________________________________________________________________________________
        // infomasi index array bedasarkan nama variabel jika data tidak dibuat dengan array
        /* rokok[0], jumlah_rokok[1], harga_rokok[2], total_harga_rokok[3] */
        int[] rokok = new int[4]; rokok[0] = 25000; rokok[1] = 0; rokok[2] = 0; rokok[3] = 0;
        /* kopi[0], jumlah_kopi[1], harga_kopi[2], total_harga_kopi[3] */
        int kopi[] = new int[4]; kopi[0] = 10000; kopi[1] = 0; kopi[2] = 0; kopi[3] = 0;
        /* kacang[0], jumlah_kacang[1], harga_kacang[2], total_harga_kacang[3] */
        int kacang[] = new int[4]; kacang[0] = 15000; kacang[1] = 0; kacang[2] = 0; kacang[3] = 0;
        /* diskon_1[0], diskon_2[1], harga_barang[2], total[3], total_harga[4] */
        int perhitungan[] = {50000, 20000, 0, 0, 0};
        // pada data array di atas array di pecah menjadi beberapa bagian
        // dan index array akan di operasikan dengan index array nama variabel masing-masing
        // _________________________________________________________________________________
        // dibawah ini bukan tipe data array (tidak memiliki index) 
        int jumlah_barang, bayar, kurang_bayar, bayar_lagi, kembalian;
        char pilih_menu, pilih_menu_lagi;
        // disini kita akan masuk ke perulangan do while
        // untuk melakukan pemilihan menu yang ingin kita pilih secara berulan-ulang
        do {
            // ini adalah input untuk memilih case (memilih menu)
            System.out.print("Silahkan Pilih Menu\t: ");
            pilih_menu = scan.next().charAt(0);
            // dibawah ini kondisi dibuat dengan percabangan menggunakan switch case
            switch (pilih_menu) {
                // tiga case dibawah ini yang akan dijalankan hanya case yang bernilai true
                // sesuai dengan pilihan yang kita masukan pada input di atas
                case '1' :
                    // jika case terpilih (true) kita akan masuk kesini
                    System.out.println("==============================================");
                    // disini kita akan memasukan input berapa jumlah menu (barang) yang kita pilih
                    System.out.print("Masukan Jumlah Barang\t: ");
                    jumlah_barang = scan.nextInt();
                    rokok[1] += jumlah_barang;
                    // ini adalah kondi ketika jumlah menu yang kita masukan 0 atau lebih kecil dari 0
                    if (jumlah_barang == 0 || jumlah_barang < 0) {
                        // dan jika jumlah menu 0 atau lebih kecil dari 0
                        // kita akan masuk kedalam perulangan do while
                        // untuk mengisi jumlah menu lagi sampai jumlah menu lebih besar dari 0
                        do {
                            System.out.println("==============================================");
                            System.out.println("Jumlah Barang Tidak Boleh 0 Atau Kurang Dari 0");
                            System.out.println("Silahkan Anda Masukan Lagi Jumlah Barang");
                            System.out.println("==============================================");
                            // disini kita akan memasukan jumlah menu lagi (tidak boleh 0)
                            // jika jumlah menu yang dimasukan 0 atau lebih kecil dari 0
                            // pengulangan akan dilakukan secara terus-menerus
                            System.out.print("Masukan Jumlah Barang\t: ");
                            jumlah_barang = scan.nextInt();
                            rokok[1] += jumlah_barang;
                        // dan pengulangan hanya akan dihentikan ketika jumlah menu lebih besar dari 0
                        } while (jumlah_barang < 0 || jumlah_barang < 1);
                        rokok[2] = rokok[0] * jumlah_barang;
                        perhitungan[2] += rokok[2];
                        System.out.println("==============================================");
                        System.out.println("Harga Rokok\t: " + jumlah_barang + "\t: RP." + rokok[2]);
                        System.out.println("==============================================");
                        rokok[3] += rokok[2];
                    // ini adalah kondisi ketika jmlah menu yang dimasukan pada input lebih besar dari 0
                    // pada kondisi else hanya akan dijalankan ketika kondisi if bernilai false
                    } else {
                        rokok[2] = rokok[0] * jumlah_barang;
                        perhitungan[2] += rokok[2];
                        System.out.println("==============================================");
                        System.out.println("Harga Rokok\t: " + jumlah_barang + "\t: RP." + rokok[2]);
                        System.out.println("==============================================");
                        rokok[3] += rokok[2];
                    }
                break;
                // kondisi case dua dan tiga dibawah ini sama dengan case satu yang di atas
                case '2' :
                System.out.println("==============================================");
                    System.out.print("Masukan Jumlah Barang\t: ");
                    jumlah_barang = scan.nextInt();
                    kopi[1] += jumlah_barang;
                    if (jumlah_barang == 0 || jumlah_barang < 0) {
                        do {
                            System.out.println("==============================================");
                            System.out.println("Jumlah Barang Tidak Boleh 0 Atau Kurang Dari 0");
                            System.out.println("Silahkan Anda Masukan Lagi Jumlah Barang");
                            System.out.println("==============================================");
                            System.out.print("Masukan Jumlah Barang\t: ");
                            jumlah_barang = scan.nextInt();
                            kopi[1] += jumlah_barang;
                        } while (jumlah_barang < 0 || jumlah_barang < 1);
                        kopi[2] = kopi[0] * jumlah_barang;
                        perhitungan[2] += kopi[2];
                        System.out.println("==============================================");
                        System.out.println("Harga Kopi\t: " + jumlah_barang + "\t: RP." + kopi[2]);
                        System.out.println("==============================================");
                        kopi[3] += kopi[2];
                    } else {
                        kopi[2] = kopi[0] * jumlah_barang;
                        perhitungan[2] += kopi[2];
                        System.out.println("==============================================");
                        System.out.println("Harga Kopi\t: " + jumlah_barang + "\t: RP." + kopi[2]);
                        System.out.println("==============================================");
                        kopi[3] += kopi[2];
                    }
                break;
                case '3' :
                System.out.println("==============================================");
                    System.out.print("Masukan Jumlah Barang\t: ");
                    jumlah_barang = scan.nextInt();
                    kacang[1] += jumlah_barang;
                    if (jumlah_barang == 0 || jumlah_barang < 0) {
                        do {
                            System.out.println("==============================================");
                            System.out.println("Jumlah Barang Tidak Boleh 0 Atau Kurang Dari 0");
                            System.out.println("Silahkan Anda Masukan Lagi Jumlah Barang");
                            System.out.println("==============================================");
                            System.out.print("Masukan Jumlah Barang\t: ");
                            jumlah_barang = scan.nextInt();
                            kacang[1] += jumlah_barang;
                        } while (jumlah_barang < 0 || jumlah_barang < 1);
                        kacang[2] = kacang[0] * jumlah_barang;
                        perhitungan[2] += kacang[2];
                        System.out.println("==============================================");
                        System.out.println("Harga Kacang\t: " + jumlah_barang + "\t: RP." + kacang[2]);
                        System.out.println("==============================================");
                        kacang[3] += kacang[2];
                    } else {
                        kacang[2] = kacang[0] * jumlah_barang;
                        perhitungan[2] += kacang[2];
                        System.out.println("==============================================");
                        System.out.println("Harga Kacang\t: " + jumlah_barang + "\t: RP." + kacang[2]);
                        System.out.println("==============================================");
                        kacang[3] += kacang[2];
                    }
                break;
                // ini adalah default hanya akan dijalankan ketika tiga case di atas bernilai false
                default : {
                    System.out.println("Maaf Menu Yang Anda Pilih Tidak Ada");
                }
            }
            System.out.println("Apakah Anda Ingin Memilih Menu Lagi [y/t] ?");
            // disini kita akan memasukan input untuk menentukan program berjalan (input do while)
            System.out.print("Masuakn Input [y/t] ?\t: ");
            pilih_menu_lagi = scan.next().charAt(0);
            System.out.println("==============================================");
        // dan pengulangan akan terus dilakukan ketika (input do while) yang dimasukan bernilai true
        } while (pilih_menu_lagi == 'y' || pilih_menu_lagi == 'y');
        // dibawah ini akan dijalankan ketika kondisi do while do while bernilai false
        System.out.print("\n");
        // ini adalah kondisi ketika pembelian barang (lebih dari RP.400000)
        if (perhitungan[2] > 400000) {
            System.out.println("----------------------------------------------");
            System.out.println("Anda Mendapatkan Diskon : RP.50000");
            System.out.println("Karena Pembelian Lebih Dari : RP.400000");
            System.out.println("----------------------------------------------");
            // tiga kondisi if dibawah ini hanya akan dijalankan ketika jumlah barang tidak sama dengan 0
            if (rokok[1] != 0) System.out.println("Harga Rokok\t: " + rokok[1] + "\t: RP." + rokok[3]);
            if (kopi[1] != 0) System.out.println("Harga Kopi\t: " + kopi[1] + "\t: RP." + kopi[3]);
            if (kacang[1] != 0) System.out.println("Harga Kacang\t: " + kacang[1] + "\t: RP." + kacang[3]);
            perhitungan[3] += perhitungan[2];
            perhitungan[4] += perhitungan[2] - perhitungan[0];
            System.out.println("----------------------------------------------");
            System.out.println("Total Barang\t\t: RP." + perhitungan[3]);
            System.out.println("Dapat Diskon\t\t: RP." + perhitungan[0]);
            System.out.println("Total Harga\t\t: RP." + perhitungan[4]);
            System.out.println("----------------------------------------------");
            // dibawah ini adalah input untuk melakukan pembayaran
            System.out.print("Jumlah Bayar\t\t: RP.");
            bayar = scan.nextInt();
            System.out.println("----------------------------------------------");
            kembalian = bayar - perhitungan[4];
            // ini adalah kondisi ketika input pembayaran kurang dari total harga (perhitingan[4])
            if (bayar < perhitungan[4]) {
                // dan jika jumlah pembayaran kurang dari total harga (perhitingan[4])
                kurang_bayar = perhitungan[4] - bayar;
                // kita akan masuk kedalam perulangan while
                while (kurang_bayar > 0 || kurang_bayar == 0) {
                    System.out.println("Pembayaran Kurang : RP." + kurang_bayar);
                    System.out.println("Silahkan Anda Bayar Lagi");
                    System.out.println("----------------------------------------------");
                    // disini kita akan memasukan jumlah bayar lagi
                    // jika jumlah pembayaran yang dimasukan lebih kecil dari total harga (perhitingan[4])
                    // pengulangan akan dilakukan secara terus-menerus
                    System.out.print("Jumlah Bayar\t\t: RP.");
                    bayar_lagi = scan.nextInt();
                    System.out.println("----------------------------------------------");
                    kembalian = bayar_lagi - kurang_bayar;
                    if (kembalian > 0 || kembalian == 0) break;
                    kurang_bayar -= bayar_lagi;
                    // dan pengulangan hanya akan dihentikan 
                    // ketika pembayaran lebih besar dari total harga (perhitingan[4])
                }
                // ini adalah kondisi ketika kembalian 0 (didalam kondisi kurang pembayaran)
                if (kembalian == 0) {
                    System.out.println("Pembayaran Pas Tidak Ada Kembalian");
                    System.out.println("Kembalian\t\t: RP." + kembalian);
                // ini adalah kondisi ketika kembalian tidak 0 (didalam kondisi kurang pembayaran)
                } else {
                    System.out.println("Kembalian\t\t: RP." + kembalian);
                }
            // ini adalah kondisi ketika kembalian 0 (diluar kondisi kurang pembayaran)
            } else if (kembalian == 0) {
                System.out.println("Pembayaran Pas Tidak Ada Kembalian");
                System.out.println("Kembalian\t\t: RP." + kembalian);
            // ini adalah kondisi ketika kembalian tidak 0 (diluar kondisi kurang pembayaran)
            } else {
                System.out.println("Kembalian\t\t: RP." + kembalian);
            }
        // kondisi (else if dan else) dibawah logika didalamnya kira-kira sama dengan kondisi if di atas
        // ini adalah kondisi ketika pembelian barang (lebih dari RP.200000 dan kurang dari RP.400000)
        } else if (perhitungan[2] > 200000 && perhitungan[2] < 400000) {
            System.out.println("----------------------------------------------");
            System.out.println("Anda Mendapatkan Diskon : RP.20000");
            System.out.println("Karena Pembelian Lebih Dari : RP.200000");
            System.out.println("Dan Pembelian kurang Dari : RP.400000");
            System.out.println("----------------------------------------------");
            if (rokok[1] != 0) System.out.println("Harga Rokok\t: " + rokok[1] + "\t: RP." + rokok[3]);
            if (kopi[1] != 0) System.out.println("Harga Kopi\t: " + kopi[1] + "\t: RP." + kopi[3]);
            if (kacang[1] != 0) System.out.println("Harga Kacang\t: " + kacang[1] + "\t: RP." + kacang[3]);
            perhitungan[3] += perhitungan[2];
            perhitungan[4] += perhitungan[2] - perhitungan[1];
            System.out.println("----------------------------------------------");
            System.out.println("Total Barang\t\t: RP." + perhitungan[3]);
            System.out.println("Dapat Diskon\t\t: RP." + perhitungan[1]);
            System.out.println("Total Harga\t\t: RP." + perhitungan[4]);
            System.out.println("----------------------------------------------");
            System.out.print("Jumlah Bayar\t\t: RP.");
            bayar = scan.nextInt();
            System.out.println("----------------------------------------------");
            kembalian = bayar - perhitungan[4];
            if (bayar < perhitungan[4]) {
                kurang_bayar = perhitungan[4] - bayar;
                while (kurang_bayar > 0 || kurang_bayar == 0) {
                    System.out.println("Pembayaran Kurang : RP." + kurang_bayar);
                    System.out.println("Silahkan Anda Bayar Lagi");
                    System.out.println("----------------------------------------------");
                    System.out.print("Jumlah Bayar\t\t: RP.");
                    bayar_lagi = scan.nextInt();
                    System.out.println("----------------------------------------------");
                    kembalian = bayar_lagi - kurang_bayar;
                    if (kembalian > 0 || kembalian == 0) break;
                    kurang_bayar -= bayar_lagi;
                }
                if (kembalian == 0) {
                    System.out.println("Pembayaran Pas Tidak Ada Kembalian");
                    System.out.println("Kembalian\t\t: RP." + kembalian);
                } else {
                    System.out.println("Kembalian\t\t: RP." + kembalian);
                }
            } else if (kembalian == 0) {
                System.out.println("Pembayaran Pas Tidak Ada Kembalian");
                System.out.println("Kembalian\t\t: RP." + kembalian);
            } else {
                System.out.println("Kembalian\t\t: RP." + kembalian);
            }
        // ini adalah kondisi ketika pembelian barang (kurang dari RP.200000)
        } else {
            System.out.println("----------------------------------------------");
            System.out.println("Anda Tidak Mendapatkan Diskon");
            System.out.println("Karena Pembelian Kurang Dari : RP.200000");
            System.out.println("----------------------------------------------");
            if (rokok[1] != 0) System.out.println("Harga Rokok\t: " + rokok[1] + "\t: RP." + rokok[3]);
            if (kopi[1] != 0) System.out.println("Harga Kopi\t: " + kopi[1] + "\t: RP." + kopi[3]);
            if (kacang[1] != 0) System.out.println("Harga Kacang\t: " + kacang[1] + "\t: RP." + kacang[3]);
            perhitungan[4] = perhitungan[4] + perhitungan[2];
            System.out.println("----------------------------------------------");
            System.out.println("Total Harga\t\t: RP." + perhitungan[4]);
            System.out.println("----------------------------------------------");
            System.out.print("jumlah Bayar\t\t: RP.");
            bayar = scan.nextInt();
            System.out.println("----------------------------------------------");
            kembalian = bayar - perhitungan[4];
            if (bayar < perhitungan[4]) {
                kurang_bayar = perhitungan[4] - bayar;
                while (kurang_bayar > 0 || kurang_bayar == 0) {
                    System.out.println("Pembayaran Kurang : RP." + kurang_bayar);
                    System.out.println("Silahkan Anda Bayar Lagi");
                    System.out.println("----------------------------------------------");
                    System.out.print("Jumlah Bayar\t\t: RP.");
                    bayar_lagi = scan.nextInt();
                    System.out.println("----------------------------------------------");
                    kembalian = bayar_lagi - kurang_bayar;
                    if (kembalian > 0 || kembalian == 0) break;
                    kurang_bayar -= bayar_lagi;
                }
                if (kembalian == 0) {
                    System.out.println("Pembayaran Pas Tidak Ada Kembalian");
                    System.out.println("Kembalian\t\t: RP." + kembalian);
                } else {
                    System.out.println("Kembalian\t\t: RP." + kembalian);
                }
            } else if(kembalian == 0) {
                System.out.println("Pembayaran Pas Tidak Ada Kembalian");
                System.out.println("Kembalian\t\t: RP." + kembalian);
            } else {
                System.out.println("Kembalian\t\t: RP." + kembalian);
            }
            System.out.println("----------------------------------------------");
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        // coment line disini hanya menjelaskan tentang kondisi bagaimana cara program berjalan
        // tidak menjelaskan bagaimana cara (tipe data atau variabel) untuk melakukan perhitungan
        // semua program dimulai dari sini
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("x   - - - -  PROGRAM BY -> PINKLY  - - - -   x");
        System.out.println("x   -  Belajar Membuat -> Program Kasir  -   x");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.print("\n");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Apakah Anda Ingin Memulai Program [y/t] ?");
        System.out.println("Masukan Input [y] Untuk Memulai Program");
        System.out.println("Masukan Input [t] Untk Keluar Dari Program");
        // disini kita akan memasukan input untuk menentukan program berjalan (input if)
        System.out.print("Masuakn Input [y/t] ?\t: ");
        char mulai = scan.next().charAt(0);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.print("\n");
        // kondisi if akan dijalankan jika (input if) yang dimasukan berniali true
        if (mulai == 'y') {
            // pengulangan for hanya akan dijalankan ketika kondisi if bernilai true
            // dan pengulangan akan terus dilakukan ketika (input for) yang dimasukan bernilai true
            // dan pengulangan hanya akan dihentikan ketika kondisi (for) menjadi false
            for (String pilih_lagi = "y"; pilih_lagi.equals("y") || pilih_lagi.equals("y");) {
                // kemudian akan menjalankan struktur program dibawah ini
                // program dibawah ini akan berjalan secara berurutan (secara prosedural)
                System.out.println("----------------------------------------------");
                System.out.println("Berikut Adalah Pilihan Menu Yang Tersedia");
                System.out.println("----------------------------------------------");
                System.out.println("Akan Mendapatkan Diskon RP.50000");
                System.out.println("Jika Pembelian Lebih Dari RP.400000");
                System.out.println("----------------------------------------------");
                System.out.println("Akan Mendapatkan Diskon RP.20000");
                System.out.println("Jika Pembelian Lebih Dari RP.200000");
                System.out.println("Dan Pembelian Kurang Dari RP.400000");
                System.out.println("----------------------------------------------");
                System.out.println("Tapi Jika Pembelian Kurang Dari RP.200000");
                System.out.println("Tidak Akan Mendapatkan Diskon");
                System.out.println("----------------------------------------------");
                // fungsi ini akan di panggil untuk melihat daftar menu yang tersedia
                Melihat_Daftar_Menu();
                System.out.println("----------------------------------------------");
                System.out.print("\n");
                System.out.println("==============================================");
                System.out.println("Silahkan Pilih Barang Yang Ingin Anda Beli");
                // fungsi ini akan di panggil untuk melakukan pemilihan pada menu
                Memilih_Daftar_Menu();
                System.out.println("==============================================");
                System.out.println("Masih Ada Menu Yang Ingin Anda Pilih Lagi ?");
                System.out.println("Masukan Input [y] Untuk Memilih Menu Lagi");
                System.out.println("Masukan Input [t] Untk Keluar Dari Program");
                // disini kita akan memasukan input untuk menentukan program berjalan (input for)
                System.out.print("Masuakn Input [y/t] ?\t: ");
                pilih_lagi = input.nextLine();
                System.out.println("==============================================");
                System.out.print("\n");
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Anda Sudah Keluar Dari Program");
            System.out.println("Anda Tidak Bisa Melakukan Pemilihan Lagi");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        // kondisi else hanya akan dijalankan ketika kondisi if bernilai false
        } else {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Anda Sudah Keluar Dari Program");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }
}
