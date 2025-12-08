========================================================================
TRANS KOETARADJA - PROYEK PEMROGRAMAN BERORIENTASI OBJEK JAVA
========================================================================

DESKRIPSI PROYEK
Proyek ini adalah simulasi sistem manajemen penumpang untuk bus Trans Koetaradja
di Kota Banda Aceh. Program ini dibuat untuk memenuhi tugas Projek Individu
mata kuliah Pemrograman Berorientasi Objek.
Proyek ini disusun oleh : Raisul Akram (2408107010107)

Program ini berfungsi untuk mengatur alur penumpang naik dan turun bus dengan
memperhatikan aturan kapasitas dan prioritas penumpang (Lansia, Ibu Hamil,
dan Anak-anak) serta validasi saldo tiket.

FITUR UTAMA & PERBEDAAN 
Untuk memastikan keaslian kode dan performa yang terkontrol, proyek ini
menggunakan pendekatan manual (Low-Level Logic):

1. Array Statis vs ArrayList:
   Program ini tidak menggunakan ArrayList. Sebagai gantinya, saya menggunakan
   Array Statis biasa (Fixed Size) dan memanipulasi indeks array secara manual
   untuk proses penambahan (add) dan penghapusan (remove) data. Ini menunjukkan
   pemahaman logika algoritma dasar.

2. Fitur Tambahan (Kategori Remaja):
   Selain kategori wajib (Lansia, Anak, Ibu Hamil, Umum), program ini
   menambahkan kategori "Remaja" (usia 10-19 tahun) yang secara otomatis
   dideteksi oleh sistem.

3. ID Tiket Otomatis:
   Setiap penumpang yang berhasil naik akan mendapatkan ID Tiket unik yang
   dibuat secara otomatis (Auto-Increment), memudahkan pelacakan data.

4. Validasi Saldo:
   Sistem mengecek saldo penumpang sebelum mengizinkan naik. Jika saldo
   kurang dari Rp 2.000, penumpang ditolak.

IMPLEMENTASI KONSEP OOP
Proyek ini menerapkan minimal 6 konsep OOP sesuai syarat tugas:

1. Class & Object:
   Implementasi pada class Pelanggan (sebagai model data) dan
   TransKoetaradja (sebagai kontroler sistem).

2. Encapsulation:
   Seluruh atribut bersifat private dan diakses menggunakan method
   public (Getter/Setter) untuk keamanan data.

3. Interface:
   Menggunakan interface 'Transportasi' sebagai kontrak metode dasar
   yang harus dimiliki oleh kendaraan (prosesNaik, prosesTurun).

4. Polymorphism:
   Menggunakan konsep Override pada method yang diwarisi dari interface
   untuk menyesuaikan logika khusus bus Trans Koetaradja.

5. Enum:
   Menggunakan Enum 'Kategori' untuk standarisasi tipe penumpang guna
   menghindari kesalahan input string (LANSIA, REMAJA, dll).

6. Exception Handling:
   Menggunakan blok try-catch untuk menangani kesalahan input pengguna,
   misalnya jika pengguna memasukkan huruf pada kolom usia atau menu.

STRUKTUR FILE

1. Simulasi.java
   File utama (Main Class). Berfungsi sebagai antarmuka pengguna (UI)
   untuk input data dan menampilkan menu.

2. TransKoetaradja.java
   Berisi logika inti bus, seperti pengaturan array kursi, perhitungan
   pendapatan, dan logika prioritas penumpang.

3. Pelanggan.java
   Merepresentasikan data penumpang (Nama, ID, Usia, Saldo, Kategori).

4. Transportasi.java
   Interface yang berisi definisi method wajib.

5. Kategori.java
   Enum yang berisi daftar tipe penumpang.

CARA MENJALANKAN PROGRAM
Menggunakan Command Line / Terminal
1. Buka terminal/CMD dan arahkan ke direktori folder proyek.
2. Compile semua file dengan perintah:
   javac *.java
3. Jalankan program dengan perintah:
   java Simulasi

