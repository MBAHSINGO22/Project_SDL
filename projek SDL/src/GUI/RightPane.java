package GUI;

import java.awt.*; // Mengimpor semua kelas dari paket java.awt untuk menggunakan komponen GUI dasar

import javax.swing.JButton; // Mengimpor kelas JButton dari paket javax.swing untuk membuat tombol
import javax.swing.JPanel; // Mengimpor kelas JPanel dari paket javax.swing untuk panel GUI

public class RightPane extends JPanel { // Deklarasi kelas RightPane yang merupakan turunan dari JPanel
    JPanel pane; // Deklarasi variabel instance pane bertipe JPanel
    JButton saveButton; // Deklarasi variabel instance saveButton bertipe JButton

    public RightPane() { // Konstruktor kelas RightPane
        setLayout(new GridBagLayout()); // Mengatur layout manager untuk RightPane menggunakan GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // Membuat instance GridBagConstraints untuk pengaturan tata letak
        gbc.anchor = GridBagConstraints.NORTH; // Mengatur anchor ke atas (utara)
        gbc.weighty = 1; // Mengatur bobot y agar komponen bisa diperluas secara vertikal
        gbc.gridy = 1; // Mengatur posisi grid y ke 1
        gbc.ipadx = 10; // Mengatur padding internal horizontal untuk komponen

        pane = new JPanel(); // Inisialisasi pane sebagai JPanel baru
        pane.setPreferredSize(new Dimension(40, 30)); // Mengatur ukuran preferensi pane

        add(pane, gbc); // Menambahkan pane ke RightPane dengan pengaturan tata letak GridBagConstraints

        saveButton = new JButton("Simpan"); // Inisialisasi saveButton sebagai JButton baru dengan label "Simpan"
        saveButton.setMargin(new Insets(0, 0, 0, 0)); // Mengatur margin saveButton
        saveButton.setPreferredSize(new Dimension(70, 30)); // Mengatur ukuran preferensi saveButton
        saveButton.setFocusable(false); // Mengatur agar saveButton tidak bisa difokuskan
        saveButton.setVisible(false); // Mengatur saveButton agar tidak terlihat

        gbc.gridy++; // Menaikkan posisi grid y untuk menempatkan saveButton di bawah pane
        gbc.anchor = GridBagConstraints.SOUTH; // Mengatur anchor ke bawah (selatan)
        gbc.ipadx = 0; // Mengatur padding internal horizontal kembali ke 0
        add(saveButton, gbc); // Menambahkan saveButton ke RightPane dengan pengaturan tata letak GridBagConstraints
    }

    public JButton getSaveButton() { // Method getter untuk mendapatkan saveButton
        return saveButton; // Mengembalikan saveButton
    }
}
