# Latihan GUI Java (Swing)

Aplikasi sederhana "Aplikasi Sapa": pengguna mengisi nama, lalu menekan tombol **Sapa** untuk menampilkan ucapan halo.

NIM : F1D02510046
Nama: Cogok Evandra Putra

## Cara Menjalankan

```
javac AplikasiSapa.java
java AplikasiSapa
```

## 5 Komponen Utama GUI

1. Top-level Container
   - `JFrame` : Jendela utama aplikasi

2. Intermediate Container
   - `JPanel` : Wadah untuk mengelompokkan label, kolom nama, dan tombol

3. Atomic Component
   - `JLabel` : Menampilkan teks "Nama:" dan hasil sapaan
   - `JTextField` : Kolom untuk mengisi nama
   - `JButton` : Tombol Sapa dan Reset

4. Layout Classes
   - `BorderLayout` : Mengatur tata letak frame (atas dan tengah)
   - `FlowLayout` : Menyusun isi panel secara berurutan

5. Event Listener
   - `ActionListener` : Override `actionPerformed` untuk menangani klik tombol
   - `MouseAdapter` : Override `mouseEntered` dan `mouseExited` untuk mengubah warna tombol saat kursor lewat

## Screenshot
<img width="249" height="141" alt="Screenshot 2026-11-24 063012" src="https://github.com/user-attachments/assets/7f7ad557-e7f8-4a23-b6df-5f15193bfe9d" />
<img width="249" height="141" alt="Screenshot 2026-11-24 063024" src="https://github.com/user-attachments/assets/5a98e6a3-c60c-4314-a199-68c10b5eff79" />
