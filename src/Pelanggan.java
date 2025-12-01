public class Pelanggan {
    private int idTiket
    private String namaLengkap;
    private int usia;
    private boolean isHamil;
    private int sisaSaldo;
    private Kategori kategori;

    public Pelanggan(int id, String nama, int usia, boolean hamil) {
        this.idTiket = id;
        this.namaLengkap = nama;
        this.usia = usia;
        this.isHamil = hamil;
        this.sisaSaldo = 10000; 
        this.kategori = tentukanKategori();
    }

    private Kategori tentukanKategori() {
        if (usia > 60) return Kategori.LANSIA;
        if (usia < 10) return Kategori.ANAK_ANAK;
        if (isHamil) return Kategori.IBU_HAMIL;
        
        // Logika Remaja (10 - 19 tahun)
        if (usia >= 10 && usia <= 20) return Kategori.REMAJA; 
        
        return Kategori.UMUM;
    }
    public int getId() { return idTiket; }
    
    public String getNama() { return namaLengkap; }
    public int getSaldo() { return sisaSaldo; }
    public Kategori getKategori() { return kategori; }

    public void bayarTiket(int harga) {
        this.sisaSaldo -= harga;
    }
}
