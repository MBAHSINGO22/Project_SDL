package GUI;

import java.awt.*; // Mengimpor semua kelas dari paket java.awt untuk menggunakan komponen GUI dasar

import javax.swing.JPanel; // Mengimpor kelas JPanel dari paket javax.swing untuk panel GUI
import javax.swing.JScrollPane; // Mengimpor kelas JScrollPane dari paket javax.swing untuk menambahkan scroll pada tabel
import javax.swing.JTable; // Mengimpor kelas JTable dari paket javax.swing untuk membuat tabel
import javax.swing.JViewport; // Mengimpor kelas JViewport dari paket javax.swing untuk mengatur tampilan scroll pane
import javax.swing.table.DefaultTableModel; // Mengimpor kelas DefaultTableModel dari paket javax.swing.table untuk model data tabel

public class DaftarPane extends JPanel { // Deklarasi kelas DaftarPane yang merupakan turunan dari JPanel
    private JScrollPane scrollPane; // Deklarasi variabel instance scrollPane bertipe JScrollPane
    private JTable pesertaTable; // Deklarasi variabel instance pesertaTable bertipe JTable

    private final String[] TABLE_HEADER = { "No.", "No. Pendaftaran", "Nama Peserta" }; // Deklarasi array string untuk header tabel

    public DaftarPane() { // Konstruktor kelas DaftarPane
        setLayout(new GridBagLayout()); // Mengatur layout manager untuk DaftarPane menggunakan GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints(); // Membuat instance GridBagConstraints untuk pengaturan tata letak
        gbc.gridx = 0; // Mengatur posisi grid x ke 0
        gbc.gridy = 0; // Mengatur posisi grid y ke 0
        gbc.weightx = 1; // Mengatur bobot x agar kolom bisa diperluas
        gbc.weighty = 1; // Mengatur bobot y agar baris bisa diperluas
        gbc.fill = GridBagConstraints.BOTH; // Mengatur agar komponen mengisi seluruh area grid
        gbc.insets = new Insets(0, 0, 0, 0); // Mengatur margin insets menjadi 0

        // Inisialisasi pesertaTable dengan model tabel yang tidak bisa diedit
        pesertaTable = new JTable(new DefaultTableModel(TABLE_HEADER, 0)) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) { // Override method editCellAt untuk mencegah pengeditan sel tabel
                return false; // Mengembalikan false agar sel tidak bisa diedit
            }
        };
        pesertaTable.setFocusable(false); // Mengatur tabel agar tidak bisa difokuskan

        // Mengatur lebar kolom pertama (No.) maksimal 50 piksel
        pesertaTable.getColumnModel().getColumn(0).setMaxWidth(50);
        // Mengatur lebar kolom kedua (No. Pendaftaran) maksimal 200 piksel
        pesertaTable.getColumnModel().getColumn(1).setMaxWidth(200);
        // Mengatur lebar preferensi kolom kedua (No. Pendaftaran) 200 piksel
        pesertaTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        // Mengatur font tabel ke Arial, ukuran 20, dan plain
        pesertaTable.setFont(new Font("Arial", Font.PLAIN, 20));
        // Mengatur font header tabel ke Arial, ukuran 20, dan bold
        pesertaTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        // Mengatur tinggi baris tabel menjadi 25 piksel
        pesertaTable.setRowHeight(25);
        // Mengatur agar header tabel tidak bisa diubah ukurannya
        pesertaTable.getTableHeader().setResizingAllowed(false);
        // Mengatur agar header tabel tidak bisa diubah urutannya
        pesertaTable.getTableHeader().setReorderingAllowed(false);

        scrollPane = new JScrollPane(pesertaTable); // Inisialisasi scrollPane dengan pesertaTable sebagai konten
        scrollPane.setColumnHeader(new JViewport()); // Mengatur header kolom untuk scrollPane
        scrollPane.setVisible(false); // Mengatur scrollPane agar tidak terlihat

        add(scrollPane, gbc); // Menambahkan scrollPane ke DaftarPane dengan pengaturan tata letak GridBagConstraints
    }

    public JScrollPane getScrollPane() { // Method getter untuk mendapatkan scrollPane
        return scrollPane; // Mengembalikan scrollPane
    }

    public JTable getPesertaTable() { // Method getter untuk mendapatkan pesertaTable
        return pesertaTable; // Mengembalikan pesertaTable
    }
}
