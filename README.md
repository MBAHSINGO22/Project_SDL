# 📝 Sistem_Seleksi_SNBP

## Sistem Pengelolaan Peserta Seleksi SNBP dengan Java
Aplikasi GUI berbasis Java untuk mengelola data peserta **akademik** dan **non-akademik**: tambah peserta, pencarian cepat (binary search), dan cek kelulusan.

---

## 📖 Deskripsi Proyek
**Sistem_Seleksi_SNBP** menerapkan pola **MVC** dengan **Java Swing** dan **serialisasi objek** untuk penyimpanan data. Fitur utama:
- 📊 **Model Data**: Peserta akademik (nilai mata pelajaran), non-akademik (sertifikat), perhitungan rata-rata & bobot.
- 🔍 **GUI**: Form tambah peserta, daftar peserta (tabel), pencarian, dan dialog detail.
- 🛠️ **Controller**: Orkestrasi alur, validasi, binary search berdasarkan **nomor pendaftaran**, dan simpan/muat data.

---

## 🧠 Teknologi
- Java 8+
- Swing (GUI)
- Java Serialization (IO objek)

---

## 📂 Struktur Proyek
```
Sistem_Seleksi_SNBP/
├── src/Model/
│   ├── Peserta.java               # Kelas dasar peserta
│   ├── PesertaAkademik.java       # Peserta akademik (nilai mapel)
│   ├── PesertaNonAkademik.java    # Peserta non-akademik (sertifikat)
│   ├── Sertifikat.java            # Representasi sertifikat prestasi
├── src/GUI/
│   ├── AddAkademikPane.java       # Form tambah peserta akademik
│   ├── AddNonAkademikPane.java    # Form tambah peserta non-akademik
│   ├── ActionPane.java            # Menu, filter, dan pencarian
│   ├── DaftarPane.java            # Tabel daftar peserta
│   ├── RightPane.java             # Tombol & aksi utilitas (save/load)
│   ├── CombinedPane.java          # Susun panel-panel GUI
│   ├── TextPrompt.java            # Placeholder pada text field
│   ├── TitlePane.java             # Header dengan judul & ikon
│   ├── MainFrame.java             # Frame utama aplikasi
├── src/Control/
│   ├── DataHandle.java            # Manajemen data & perhitungan
│   ├── Controller.java            # Jembatan GUI-Model (event handler)
├── AppMain.java                   # Entry point aplikasi
├── assets/
│   └── DataPeserta.txt            # File data hasil serialisasi (otomatis)
```

> **Catatan:** Pastikan folder `assets/` tersedia dan memiliki izin tulis.

---

## 🟢 Aturan Kelulusan (Default)
- **Akademik**: LULUS jika **rata-rata nilai ≥ 82.5**.
- **Non-akademik**: LULUS jika **bobot sertifikat** memenuhi ambang yang ditentukan di `DataHandle`.

Ambang dapat diubah di kelas pengelola data sesuai kebutuhan.

---

## 🔎 Pencarian
- Menggunakan **binary search** berdasarkan **nomor pendaftaran** (pastikan data tersortir/diurutkan saat disimpan/ditampilkan).

---

## 💾 Penyimpanan
- Data disimpan/muat otomatis via **serialisasi** ke `assets/DataPeserta.txt`.
- File akan dibuat saat proses simpan pertama.

---

## 🧪 Alur Penggunaan (Contoh)
1. Buka aplikasi → menu **Tambah Peserta**.
2. Isi form **Akademik** atau **Non-Akademik** → **Simpan**.
3. Buka **Daftar Peserta** → gunakan kolom **Cari** untuk menemukan peserta.
4. Klik baris peserta untuk melihat detail dan status **LULUS/TIDAK**.

---

## 🖼️ Tampilan (Ringkas)
- Judul: **HASIL SELEKSI SNBP**
- Menu: *Home*, *Daftar Peserta*, *Tambah Peserta*
- Panel: Form input, tabel daftar, dialog detail

---

## ❗ Troubleshooting
- **File data tidak tersimpan** → pastikan folder `assets/` ada & dapat ditulis.
- **ClassNotFoundException** saat load → struktur paket harus konsisten dengan saat penyimpanan.
- **GUI tidak muncul** → pastikan `AppMain` memanggil `SwingUtilities.invokeLater(...)`.

---

## 👨‍💻 Pengembang
**MBAHSINGO22** — 🔗 GitHub
