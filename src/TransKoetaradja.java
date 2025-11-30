public class TransKoetaradja implements Transportasi {
    // Struktur Data Array (Manual)
    private Pelanggan[] kursiBiasa = new Pelanggan[16];
    private Pelanggan[] kursiPrioritas = new Pelanggan[4];
    private Pelanggan[] areaBerdiri = new Pelanggan[20];

    // Konstanta
    private static final int TARIF = 2000;
    private int totalPendapatan = 0;

    @Override
    public boolean prosesNaik(Pelanggan p) {
        // Cek Saldo
        if (p.getSaldo() < TARIF) {
            System.out.println("Maaf, saldo " + p.getNama() + " tidak cukup.");
            return false;
        }

        boolean berhasil = false;
        Kategori k = p.getKategori();

        // LOGIKA PRIORITAS (Lansia, Anak, Ibu Hamil)
        if (k == Kategori.LANSIA || k == Kategori.ANAK_ANAK || k == Kategori.IBU_HAMIL) {
            if (masukkanKeArray(kursiPrioritas, p)) berhasil = true;
            else if (masukkanKeArray(kursiBiasa, p)) berhasil = true;
            else if (masukkanKeArray(areaBerdiri, p)) berhasil = true;
        } 
        // LOGIKA NON-PRIORITAS (Umum & Remaja)
        else {
            if (masukkanKeArray(kursiBiasa, p)) berhasil = true;
            else if (masukkanKeArray(areaBerdiri, p)) berhasil = true;
        }

        // Transaksi berhasil
        if (berhasil) {
            p.bayarTiket(TARIF);
            totalPendapatan += TARIF;
            return true;
        } else {
            System.out.println("Bus penuh total untuk kategori ini!");
            return false;
        }
    }

    private boolean masukkanKeArray(Pelanggan[] arr, Pelanggan p) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                arr[i] = p;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean prosesTurun(String nama) {
        if (hapusDariArray(kursiPrioritas, nama)) return true;
        if (hapusDariArray(kursiBiasa, nama)) return true;
        if (hapusDariArray(areaBerdiri, nama)) return true;
        return false;
    }

    private boolean hapusDariArray(Pelanggan[] arr, String nama) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getNama().equalsIgnoreCase(nama)) {
                arr[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("\n=== LAPORAN TRANS KOETARADJA ===");
        System.out.println("Total Pendapatan: Rp " + totalPendapatan);
        
        cetakBaris("Penumpang Prioritas", kursiPrioritas);
        cetakBaris("Penumpang Biasa", kursiBiasa);
        cetakBaris("Penumpang Berdiri", areaBerdiri);
        
        System.out.println("Total Penumpang Saat Ini: " + hitungTotal());
    }

    private void cetakBaris(String label, Pelanggan[] arr) {
        System.out.print(label + ": ");
        boolean ada = false;
        for (Pelanggan p : arr) {
            if (p != null) {
                // Format: [ID: Nama (KATEGORI)]
                System.out.print("[" + p.getId() + ": " + p.getNama() + " (" + p.getKategori() + ")] ");
                ada = true;
            }
        }
        if (!ada) System.out.print("<KOSONG>");
        System.out.println();
    }

    private int hitungTotal() {
        int count = 0;
        for(Pelanggan p : kursiBiasa) if(p!=null) count++;
        for(Pelanggan p : kursiPrioritas) if(p!=null) count++;
        for(Pelanggan p : areaBerdiri) if(p!=null) count++;
        return count;
    }
}
