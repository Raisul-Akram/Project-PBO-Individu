# Dokumentasi Project : Trans Koetaradja - Sistem Manajemen Bus
Proyek ini adalah simulasi perangkat lunak berbasis Java CLI  untuk mengelola operasional penumpang bus Trans Koetaradja di Kota Banda Aceh.
Proyek ini dikembangkan sebagai tugas Projek Individu untuk mendemonstrasikan pemahaman mendalam mengenai konsep Pemrograman Berorientasi Objek.

Proyek ini disusun untuk memenuhi tugas oleh:
Nama: Raisul Akram 
Npm: 2408107010107

# DESKRIPSI PROYEK Program ini mensimulasikan alur penumpang naik dan turun dengan aturan bisnis yang kompleks, meliputi:
1. Validasi Saldo: Penumpang hanya bisa naik jika saldo mencukupi.
2. Prioritas Kursi: Algoritma otomatis memisahkan penumpang prioritas (Lansia, Ibu Hamil, Anak-anak) dengan penumpang umum/remaja.
3. Manajemen Kapasitas: Mengelola kuota kursi Biasa (16), Prioritas (4), dan Berdiri (20).
Catatan Teknis: Berbeda dengan implementasi standar yang menggunakan ArrayList, proyek ini menggunakan Array Statis ([]) dengan manipulasi indeks manual. Pendekatan ini dipilih untuk mendemonstrasikan logika manajemen memori dan algoritma pencarian slot kosong yang lebih mendasar dan terkontrol.

# FITUR UNGGULAN
1.  Auto-Categorization: Sistem otomatis mendeteksi kategori penumpang berdasarkan input umur dan status fisik. (Lansia >60 thn, Anak <10 thn, Ibu Hamil -> Prioritas) (Remaja 10-19 thn -> Kategori Khusus/Masuk kursi biasa) (Umum -> Biasa)
2. Ticketing System: Setiap penumpang mendapatkan ID Tiket Unik (Auto-increment) saat berhasil naik.
3. Smart Seating: Jika kursi prioritas penuh, penumpang prioritas otomatis dialihkan ke kursi biasa (namun penumpang biasa tidak boleh duduk di kursi prioritas).
4. Error Handling: Input pengguna dilindungi oleh try-catch untuk mencegah crash saat kesalahan input tipe data.

# KONSEP OOP YANG DITERAPKAN Sesuai persyaratan tugas, proyek ini mengimplementasikan konsep-konsep berikut:
1. Class & Object: Class Pelanggan sebagai model data dan TransKoetaradja sebagai kontroler.
2. Encapsulation: Semua atribut private dan diakses melalui public getter/setter.
3. Interface: Interface Transportasi mendefinisikan kontrak method wajib (prosesNaik, prosesTurun).
4. Polymorphism: Override method prosesNaik dari interface dengan logika spesifik bus.
5. Enum: Enum Kategori untuk standarisasi tipe penumpang (LANSIA, REMAJA, dll).
6. Exception Handling: Menangani NumberFormatException pada input menu dan usia.
7. Array Logic: Algoritma manual untuk add, remove, dan search dalam array statis.

# STRUKTUR FILE

** Simulasi.java: Main Class. Menangani antarmuka menu (UI) dan input pengguna.
** TransKoetaradja.java: Core Logic. Mengatur array kursi, pendapatan, dan aturan prioritas.
**Pelanggan.java: Model. Menyimpan data nama, id, saldo, dan logika penentuan kategori.
**Transportasi.java: Interface. Blueprint fungsi dasar kendaraan.
**Kategori.java: Enum. Daftar konstanta kategori penumpang.

## CARA MENJALANKAN PROGRAM
1. Compile: javac *.java
2. Run    : java Simulasi
