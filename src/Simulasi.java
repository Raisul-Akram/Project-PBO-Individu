import java.util.Scanner

public class Simulasi {
    public static void main(String[] args) {
        
        TransKoetaradja busKota = new TransKoetaradja(); 
       
        
        Scanner scan = new Scanner(System.in);
        int menu = 0;
        int idGenerator = 100; 

        while (true) {
            System.out.println("\n--- SISTEM TRANS KOETARADJA ---");
            System.out.println("[1] Tambah Penumpang");
            System.out.println("[2] Penumpang Turun");
            System.out.println("[3] Cek Status Bus");
            System.out.println("[4] Selesai");
            System.out.print("Input: ");

            try {
                String inputStr = scan.nextLine(); 
                menu = Integer.parseInt(inputStr);
            } catch (NumberFormatException e) {
                System.out.println("Error: Masukkan angka saja!");
                continue;
            }

            if (menu == 4) {
                System.out.println("Sistem dimatikan.");
                break;
            }

            switch (menu) {
                case 1:
                    System.out.print("Nama Penumpang: ");
                    String nama = scan.nextLine();
                    
                    System.out.print("Usia: ");
                    int usia = 0;
                    try {
                        usia = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Usia tidak valid, set ke 20.");
                        usia = 20;
                    }

                    System.out.print("Sedang Hamil? (y/t): ");
                    String hamilInput = scan.nextLine();
                    boolean hamil = hamilInput.equalsIgnoreCase("y");

                    Pelanggan pBaru = new Pelanggan(idGenerator++, nama, usia, hamil);
                    
                    if (busKota.prosesNaik(pBaru)) {
                        System.out.println(">> Sukses: " + pBaru.getNama() + " (" + pBaru.getKategori() + ") berhasil naik.");
                    } else {
                        System.out.println(">> Gagal: Tidak bisa naik.");
                    }
                    break;

                case 2:
                    System.out.print("Nama yang turun: ");
                    String namaTurun = scan.nextLine();
                    if (busKota.prosesTurun(namaTurun)) {
                        System.out.println(">> Sukses: Penumpang turun.");
                    } else {
                        System.out.println(">> Gagal: Nama tidak ditemukan.");
                    }
                    break;

                case 3:
                    busKota.tampilkanInfo();
                    break;

                default:
                    System.out.println("Menu tidak dikenal.");
            }
        }
        scan.close();
    }
}
