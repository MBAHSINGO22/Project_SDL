package Control;

import java.util.ArrayList;

import Model.*;
import GUI.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Controller {
    private ArrayList<Peserta> peserta;
    private DataHandle handle;
    private MainFrame mainFrame;
    private DefaultTableModel model;
    private int windowState;
    private int addState;
    private int tableState;
    private Peserta pst;

    public Controller(MainFrame mainFrame, DataHandle handle, ArrayList<Peserta> peserta) {
        this.peserta = peserta;
        this.handle = handle;
        this.mainFrame = mainFrame;
        initView();
    }

    public void initView() {
        model = (DefaultTableModel) mainFrame.getCombinedPane().getDaftarPane().getPesertaTable()
                .getModel();
        for (int i = 0; i < peserta.size(); i++) {
            addPesertaRow(peserta.get(i));
        }
        mainFrame.setVisible();
        windowState = 0;
        addState = 0;
        tableState = 0;
    }

    public void initController() {
        mainFrame.getCombinedPane().getActionPane().getMenuBox().addActionListener(e -> menuBoxAction());
        mainFrame.getCombinedPane().getActionPane().getCategoryBoxAdd().addActionListener(e -> menuCategoryBox());
        mainFrame.getCombinedPane().getDaftarPane().getPesertaTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    JTable target = (JTable) me.getSource();
                    int row = target.getSelectedRow();
                    String noPen = (String) model.getValueAt(row, 1);
                    infoPopUp(handle.sequentialSearch(peserta, noPen));
                }
            }
        });

        mainFrame.getCombinedPane().getAddNonAkademikPane().getTambahButton().addActionListener(e -> addSertif());
        mainFrame.getCombinedPane().getActionPane().getCategoryBox().addActionListener(e -> filterPeserta());
        mainFrame.getCombinedPane().getActionPane().getSearchButton().addActionListener(e -> cariPeserta());
        mainFrame.getCombinedPane().getRightPane().getSaveButton().addActionListener(e -> simpanPeserta());
    }

    private void menuBoxAction() {
        switch (mainFrame.getCombinedPane().getActionPane().getMenuBox().getSelectedIndex()) {
            case 0:
                mainFrame.displayHome(windowState);
                windowState = 0;
                break;
            case 1:
                mainFrame.displayDaftar(windowState);
                windowState = 1;
                break;

            case 2:
                mainFrame.displayAdd(windowState);
                windowState = 2;
                break;
            default:
                break;
        }
    }

    private void menuCategoryBox() { // Method private untuk menangani pemilihan kategori dari CategoryBox
        switch (mainFrame.getCombinedPane().getActionPane().getCategoryBoxAdd().getSelectedIndex()) { // Mengambil index yang dipilih dari CategoryBox
            case 0: // Jika index yang dipilih adalah 0 (kategori pertama)
                mainFrame.addAkademik(addState); // Memanggil method addAkademik pada mainFrame dengan parameter addState
                addState = 0; // Mengatur nilai addState menjadi 0
                break; // Keluar dari switch-case
            case 1: // Jika index yang dipilih adalah 1 (kategori kedua)
                mainFrame.addNonAkademik(addState); // Memanggil method addNonAkademik pada mainFrame dengan parameter addState
                addState = 1; // Mengatur nilai addState menjadi 1
                break; // Keluar dari switch-case
        }
    }
    

    private void filterPeserta() { // Method private untuk memfilter peserta berdasarkan kategori yang dipilih
        switch (mainFrame.getCombinedPane().getActionPane().getCategoryBox().getSelectedIndex()) { // Mengambil index yang dipilih dari CategoryBox
            case 0: // Jika index yang dipilih adalah 0
                if (tableState != 0) { // Jika tableState tidak sama dengan 0
                    mainFrame.delTableRow(model); // Menghapus semua baris dari tabel model
                    for (int i = 0; i < peserta.size(); i++) { // Iterasi melalui list peserta
                        model.addRow(new Object[] { (i + 1) + ".", peserta.get(i).getNoPendaftaran(), // Menambahkan baris baru ke tabel model
                                peserta.get(i).getNama() }); // dengan nomor urut, No Pendaftaran, dan Nama peserta
                    }
                    tableState = 0; // Mengatur nilai tableState menjadi 0
                }
                break; // Keluar dari switch-case
            case 1: // Jika index yang dipilih adalah 1
                if (tableState != 1) { // Jika tableState tidak sama dengan 1
                    mainFrame.delTableRow(model); // Menghapus semua baris dari tabel model
                    for (int i = 0; i < peserta.size(); i++) { // Iterasi melalui list peserta
                        if (peserta.get(i) instanceof PesertaAkademik) { // Memeriksa apakah peserta adalah instance dari PesertaAkademik
                            model.addRow(
                                    new Object[] { (model.getRowCount() + 1) + ".", peserta.get(i).getNoPendaftaran(), // Menambahkan baris baru ke tabel model
                                            peserta.get(i).getNama() }); // dengan nomor urut, No Pendaftaran, dan Nama peserta
                        }
                    }
                    tableState = 1; // Mengatur nilai tableState menjadi 1
                }
                break; // Keluar dari switch-case
    
            case 2: // Jika index yang dipilih adalah 2
                if (tableState != 2) { // Jika tableState tidak sama dengan 2
                    mainFrame.delTableRow(model); // Menghapus semua baris dari tabel model
                    for (int i = 0; i < peserta.size(); i++) { // Iterasi melalui list peserta
                        if (peserta.get(i) instanceof PesertaNonAkademik) { // Memeriksa apakah peserta adalah instance dari PesertaNonAkademik
                            model.addRow(
                                    new Object[] { (model.getRowCount() + 1) + ".", peserta.get(i).getNoPendaftaran(), // Menambahkan baris baru ke tabel model
                                            peserta.get(i).getNama() }); // dengan nomor urut, No Pendaftaran, dan Nama peserta
                        }
                    }
                    tableState = 2; // Mengatur nilai tableState menjadi 2
                }
                break; // Keluar dari switch-case
        }
    }
    

    private void cariPeserta() {
        String key = mainFrame.getCombinedPane().getActionPane().getSearchField().getText();
        if (key != "") {
            int idxKey = handle.binarySearch(peserta, key);
            mainFrame.delTableRow(model);
            if (idxKey != -1) {
                if (tableState == 1 && peserta.get(idxKey) instanceof PesertaAkademik) {
                    addPesertaRow(peserta.get(idxKey));
                } else if (tableState == 2 && peserta.get(idxKey) instanceof PesertaNonAkademik) {
                    addPesertaRow(peserta.get(idxKey));
                } else if (tableState == 0) {
                    addPesertaRow(peserta.get(idxKey));
                }

            }
        }
    }

    private void addPesertaRow(Peserta peserta) {
        model.addRow(new Object[] { (model.getRowCount() + 1) + ".", peserta.getNoPendaftaran(),
                peserta.getNama() });
    }

    private void addSertif() {
        DefaultTableModel sertifModel = (DefaultTableModel) mainFrame.getCombinedPane().getAddNonAkademikPane()
                .getTable()
                .getModel();
        if (!mainFrame.getCombinedPane().getAddNonAkademikPane().getPrestasiText().getText().isEmpty()) {
            sertifModel.addRow(
                    new Object[] { (sertifModel.getRowCount() + 1) + ".",
                            mainFrame.getCombinedPane().getAddNonAkademikPane().getPrestasiText().getText(),
                            mainFrame.getCombinedPane().getAddNonAkademikPane().getTingkatText(),
                            mainFrame.getCombinedPane().getAddNonAkademikPane().getRankText() });
            mainFrame.getCombinedPane().getAddNonAkademikPane().getPrestasiText().setText("");

        } else {
            dataKosong("Nama Sertifikat tidak boleh kosong!");
        }
    }

    private void simpanPeserta() {
        if (addState == 0) {
            if (!mainFrame.getCombinedPane().getAddAkademikPane().getNameText().getText().isEmpty()) {
                if (!mainFrame.getCombinedPane().getAddAkademikPane().getIpaText().getText().isEmpty()) {
                    if (!mainFrame.getCombinedPane().getAddAkademikPane().getMtkText().getText().isEmpty()) {
                        if (!mainFrame.getCombinedPane().getAddAkademikPane().getIndText().getText().isEmpty()) {
                            if (!mainFrame.getCombinedPane().getAddAkademikPane().getIngText().getText().isEmpty()) {
                                if (JOptionPane.showConfirmDialog(mainFrame, "Apakah data ini sudah benar?", "Perhatian",
                                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                                    String nama = mainFrame.getCombinedPane().getAddAkademikPane().getNameText()
                                            .getText();
                                    double mtk = Double.parseDouble(
                                            mainFrame.getCombinedPane().getAddAkademikPane().getMtkText().getText());
                                    double ipa = Double.parseDouble(
                                            mainFrame.getCombinedPane().getAddAkademikPane().getIpaText().getText());
                                    double ind = Double.parseDouble(
                                            mainFrame.getCombinedPane().getAddAkademikPane().getIndText().getText());
                                    double ing = Double.parseDouble(
                                            mainFrame.getCombinedPane().getAddAkademikPane().getIngText().getText());

                                    PesertaAkademik akdm = new PesertaAkademik(nama,
                                            String.valueOf(2024001 + peserta.size()));
                                    akdm.setNilaiBahasaIndonesia(ind);
                                    akdm.setNilaiBahasaInggris(ing);
                                    akdm.setNilaiIpa(ipa);
                                    akdm.setNilaiMatematika(mtk);

                                    peserta.add(akdm);
                                    addPesertaRow(akdm);

                                    mainFrame.getCombinedPane().getAddAkademikPane().getNameText().setText("");
                                    mainFrame.getCombinedPane().getAddAkademikPane().getMtkText().setText("");
                                    mainFrame.getCombinedPane().getAddAkademikPane().getIpaText().setText("");
                                    mainFrame.getCombinedPane().getAddAkademikPane().getIndText().setText("");
                                    mainFrame.getCombinedPane().getAddAkademikPane().getIngText().setText("");

                                    saveData();

                                    JOptionPane.showMessageDialog(mainFrame, "Peserta telah ditambahkan", "Info",
                                            JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                dataKosong("Nilai Bahasa Ingrris tidak boleh kosong!");
                            }
                        } else {
                            dataKosong("Nilai Bahasa Indonesia tidak boleh kosong!");
                        }
                    } else {
                        dataKosong("Nilai Matematika tidak boleh kosong!");
                    }
                } else {
                    dataKosong("Nilai IPA tidak boleh kosong!");
                }
            } else {
                dataKosong("Nama tidak boleh kosong!");
            }
        } else {
            DefaultTableModel sertifModel = (DefaultTableModel) mainFrame.getCombinedPane()
                    .getAddNonAkademikPane().getTable().getModel();
            if (!mainFrame.getCombinedPane().getAddNonAkademikPane().getNameText().getText().isEmpty()) {
                if (sertifModel.getRowCount() != 0) {
                    if (JOptionPane.showConfirmDialog(mainFrame, "Apakah data ini sudah benar?", "Perhatian",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                        String nama = mainFrame.getCombinedPane().getAddNonAkademikPane().getNameText().getText();
                        PesertaNonAkademik nonAkdm = new PesertaNonAkademik(nama,
                                String.valueOf(2024001 + peserta.size()));

                        ArrayList<Sertifikat> sertifikat = new ArrayList<Sertifikat>();

                        for (int i = 0; i < sertifModel.getRowCount(); i++) {
                            String prestasi = sertifModel.getValueAt(i, 1).toString();
                            String tingkat = sertifModel.getValueAt(i, 2).toString();
                            String rank = sertifModel.getValueAt(i, 3).toString();

                            Sertifikat sertif = new Sertifikat(nama);
                            sertif.setTingkat(tingkat);
                            sertif.setJuara(Integer.parseInt(rank));

                            sertifikat.add(sertif);
                        }

                        nonAkdm.setSertifikat(sertifikat);
                        mainFrame.delTableRow(sertifModel);
                        peserta.add(nonAkdm);
                        addPesertaRow(nonAkdm);
                        mainFrame.getCombinedPane().getAddNonAkademikPane().getNameText().setText("");

                        saveData();

                        JOptionPane.showMessageDialog(mainFrame, "Peserta telah ditambahkan", "Info",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                } else {
                    dataKosong("Sertifikat tidak boleh kosong!");
                }
            } else {
                dataKosong("Nama tidak boleh kosong!");
            }
        }
    }

    private void dataKosong(String message) { // Method private untuk menampilkan dialog pesan kesalahan ketika data kosong
        JOptionPane.showMessageDialog(mainFrame, message, "Peringatan", JOptionPane.ERROR_MESSAGE); // Menampilkan dialog pesan kesalahan dengan parent component mainFrame, pesan dari parameter message, judul "Peringatan", dan ikon pesan kesalahan
    }
    

    private void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream("assets/DataPeserta.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(peserta);

            System.out.println("Write Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Write Failed!!");
        }
    }

    private void infoPopUp(int row) {
        if (peserta.get(row) instanceof PesertaAkademik) {
            mainFrame.showInfoPesertaAkademik(handle.getDataPeserta(peserta.get(row)));

        } else {
            mainFrame.showInfoPesertaNonAkademik(handle.getDataPeserta(peserta.get(row)));
        }
    }
}
