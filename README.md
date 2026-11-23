# Latihan/Eksplorasi GUI Java (Swing)

Aplikasi sederhana **Form Data Mahasiswa** untuk mengeksplorasi komponen utama GUI pada Java menggunakan Swing/AWT.

- **NIM**: F1D02510046
- **Nama**: Cogok Evandra Putra

## Cara Menjalankan

```bash
javac FormMahasiswaGUI.java
java FormMahasiswaGUI
```

## 5 Komponen Utama GUI yang Digunakan

### 1. Top-level Container
Container tingkat paling atas yang menjadi wadah seluruh komponen lain.
- **`JFrame`** — jendela utama aplikasi (`javax.swing.JFrame`).

### 2. Intermediate Container
Container perantara yang berada di dalam top-level container untuk mengelompokkan komponen.
- **`JPanel`** — `panelJudul`, `panelForm`, `panelTombol`, `panelBawah`.
- **`JScrollPane`** — membungkus `JTextArea` agar dapat di-scroll.

### 3. Atomic Component
Komponen paling dasar yang berinteraksi langsung dengan pengguna.
- `JLabel`, `JTextField`, `JComboBox`, `JCheckBox`, `JButton`, `JTextArea`.

### 4. Layout Classes
Mengatur posisi dan ukuran komponen di dalam container.
- **`BorderLayout`** — `JFrame` dibagi menjadi NORTH (judul), CENTER (form), SOUTH (tombol + hasil).
- **`GridLayout`** — form isian 5 baris x 2 kolom (label dan input).
- **`FlowLayout`** — panel judul dan panel tombol disusun berurutan secara horizontal.

### 5. Event Listener
Menangani aksi pengguna.
- **`ActionListener`** (Event Listener Interface) — override `actionPerformed()` pada tombol Simpan, Reset, dan Keluar.
- **`MouseAdapter`** (Event Adapter Class) — override `mouseEntered()` dan `mouseExited()` untuk efek hover tombol Simpan.
- **`WindowAdapter`** (Event Adapter Class) — override `windowClosing()` untuk dialog konfirmasi saat keluar.

## Screenshot

> Ganti dengan screenshot hasil run di laptop kamu.

| Tampilan Awal | Setelah Simpan | Konfirmasi Keluar |
|---|---|---|
| ![awal](screenshots/awal.png) | ![simpan](screenshots/simpan.png) | ![keluar](screenshots/keluar.png) |
