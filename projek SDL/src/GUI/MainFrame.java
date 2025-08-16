package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class MainFrame extends JFrame {

    private ImageIcon icon;

    private CombinedPane combinedPane;

    public MainFrame(CombinedPane combinedPane) {
        this.combinedPane = combinedPane;

        icon = new ImageIcon("C:\\Users\\MSI Prestige\\VSProject\\Projek SDL\\assets\\mbahSingo.jpeg");

        setTitle("Hasil Seleksi SNBP");
        setIconImage(icon.getImage());
        setMinimumSize(new Dimension(770, 525));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(combinedPane);
    }

    public void setVisible() {
        setVisible(true);
    }

    private void revalid() {
        combinedPane.getAddPane().revalidate();
        combinedPane.getMainDisplayPane().revalidate();
        combinedPane.repaint();
        combinedPane.revalidate();
        revalidate();
    }

    public void displayHome(int state) {
        GridBagConstraints gbc = new GridBagConstraints();
        switch (state) {
            case 0:
                break;
            case 1:
                combinedPane.getActionPane().getCategoryBox().setVisible(false);
                combinedPane.getActionPane().getSearchField().setVisible(false);
                combinedPane.getDaftarPane().getScrollPane().setVisible(false);
                combinedPane.getActionPane().getSearchButton().setVisible(false);
                break;
            case 2:
                combinedPane.getActionPane().getCategoryBox().setVisible(false);
                combinedPane.getActionPane().getSearchField().setVisible(false);
                combinedPane.getDaftarPane().getScrollPane().setVisible(false);
                combinedPane.getActionPane().getSearchButton().setVisible(false);
                combinedPane.remove(combinedPane.getAddAkademikPane());
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(4, 4, 4, 4);
                combinedPane.getActionPane().changeCategoryBox();
                // combinedPane.add(daftarPane, gbc);
                combinedPane.getMainDisplayPane().remove(combinedPane.getAddPane());
                combinedPane.getRightPane().getSaveButton().setVisible(false);
                break;
            default:
                break;
        }
        revalid();
    }

    public void displayDaftar(int state) {
        GridBagConstraints gbc = new GridBagConstraints();
        switch (state) {
            case 0:
                combinedPane.getActionPane().getCategoryBox().setVisible(true);
                combinedPane.getActionPane().getSearchField().setVisible(true);
                combinedPane.getDaftarPane().getScrollPane().setVisible(true);
                combinedPane.getActionPane().getSearchButton().setVisible(true);
                combinedPane.getMainDisplayPane().add(combinedPane.getDaftarPane());
                break;
            case 1:
                break;
            case 2:
                combinedPane.getActionPane().getCategoryBox().setVisible(true);
                combinedPane.getActionPane().getSearchField().setVisible(true);
                combinedPane.getDaftarPane().getScrollPane().setVisible(true);
                combinedPane.getActionPane().getSearchButton().setVisible(true);
                combinedPane.getMainDisplayPane().remove(combinedPane.getAddPane());
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(4, 4, 4, 4);
                combinedPane.getActionPane().changeCategoryBox();
                combinedPane.getRightPane().getSaveButton().setVisible(false);
                combinedPane.getMainDisplayPane().add(combinedPane.getDaftarPane());
                break;
            default:
                break;
        }
        revalid();
    }

    public void displayAdd(int state) {
        GridBagConstraints gbc = new GridBagConstraints();
        switch (state) {
            case 0:
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(4, 4, 4, 4);
                combinedPane.getActionPane().changeCategoryBox();
                combinedPane.getMainDisplayPane().add(combinedPane.getAddPane());
                combinedPane.getRightPane().getSaveButton().setVisible(true);
                combinedPane.getActionPane().getSearchField().setVisible(false);
                break;
            case 1:
                combinedPane.getActionPane().getSearchButton().setVisible(false);
                combinedPane.getMainDisplayPane().remove(combinedPane.getDaftarPane());
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.anchor = GridBagConstraints.WEST;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(4, 4, 4, 4);
                combinedPane.getMainDisplayPane().add(combinedPane.getAddPane());
                combinedPane.getActionPane().changeCategoryBox();
                combinedPane.getActionPane().getSearchField().setVisible(false);
                combinedPane.getRightPane().getSaveButton().setVisible(true);
                break;
            case 2:

                break;
            default:
                break;
        }
        revalid();
    }

    public void addAkademik(int addState) {
        if (addState == 1) {
            combinedPane.getAddPane().remove(combinedPane.getAddNonAkademikPane());
            combinedPane.getAddPane().add(combinedPane.getAddAkademikPane());
        }
        revalid();
    }

    public void addNonAkademik(int addState) {
        if (addState == 0) {
            combinedPane.getAddPane().remove(combinedPane.getAddAkademikPane());
            combinedPane.getAddPane().add(combinedPane.getAddNonAkademikPane());
        }
        revalid();
    }

    public void showInfoPesertaAkademik(String[] data) {
        JDialog infoDialog = new JDialog(this);
        infoDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        infoDialog.setTitle("Data Peserta SNBP");

        infoDialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        infoDialog.add(new JLabel("No. Pendaftaran"), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel("Nama"), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel("Nilai Matematika"), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel("Nilai IPA"), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel("Nilai Bahasa Indonesia"), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel("Nilai Bahasa Inggris"), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel("Rata-rata"), gbc);

        gbc.gridx++;
        gbc.gridy = 0;

        infoDialog.add(new JLabel(String.format(": %s", data[0])), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel(String.format(": %s", data[1])), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel(String.format(": %s", data[2])), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel(String.format(": %s", data[3])), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel(String.format(": %s", data[4])), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel(String.format(": %s", data[5])), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel(String.format(": %s", data[6])), gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        JLabel statusLabel = new JLabel(String.format("%s", data[7]));
        statusLabel.setFont(new Font("Aerial", Font.BOLD, 20));

        JLabel pesan;
        if (data[data.length - 1].equals("Lolos")) {
            pesan = new JLabel("Selamat Anda Lolos!! Jangan lupa di up story");
            statusLabel.setForeground(new Color(52, 235, 94));
        } else {
            pesan = new JLabel("Sudah daftar Sadhar aja!!");
            statusLabel.setForeground(Color.red);
        }

        pesan.setFont(new Font("Aerial", Font.PLAIN, 14));

        infoDialog.add(statusLabel, gbc);
        gbc.gridy++;
        infoDialog.add(pesan, gbc);

        infoDialog.pack();
        infoDialog.setResizable(false);
        infoDialog.setLocationRelativeTo(this);
        infoDialog.setVisible(true);
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 15; // Min width
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            if (width > 300)
                width = 300;
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    public void delTableRow(DefaultTableModel model) {
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public void showInfoPesertaNonAkademik(String[] data) {
        JDialog infoDialog = new JDialog(this);
        infoDialog.setLayout(new GridBagLayout());
        infoDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        infoDialog.setTitle("Data Peserta SNBP");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;

        JTable presTable = new JTable(new DefaultTableModel(new Object[] { "No.", "Prestasi", "Tingkat", "Rank" }, 0)) {
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        DefaultTableModel model = (DefaultTableModel) presTable.getModel();
        for (int i = 2; i < data.length - 3; i += 3) {
            model.addRow(new Object[] { (model.getRowCount() + 1) + ".", data[i], data[1 + i], data[2 + i] });
        }

        resizeColumnWidth(presTable);

        presTable.getColumnModel().getColumn(0).setPreferredWidth(25);
        presTable.getColumnModel().getColumn(3).setPreferredWidth(40);
        presTable.getTableHeader().setResizingAllowed(false);
        presTable.getTableHeader().setReorderingAllowed(false);
        presTable.setPreferredScrollableViewportSize(presTable.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane(presTable);
        scrollPane.setColumnHeader(new JViewport());

        infoDialog.add(new JLabel("No. Pendaftaran"), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel("Nama"), gbc);

        gbc.gridx++;
        gbc.gridy = 0;

        infoDialog.add(new JLabel(String.format(": %s", data[0])), gbc);
        gbc.gridy++;
        infoDialog.add(new JLabel(String.format(": %s", data[1])), gbc);
        gbc.gridy++;

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 2;

        infoDialog.add(scrollPane, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel statusLabel = new JLabel(String.format("%s", data[data.length - 1]));
        statusLabel.setFont(new Font("Aerial", Font.BOLD, 20));

        JLabel pesan;
        if (data[data.length - 1].equals("Lolos")) {
            pesan = new JLabel("Selamat Anda Lolos!! Jangan lupa di up story");
            statusLabel.setForeground(new Color(52, 235, 94));
        } else {
            pesan = new JLabel("Sudah daftar Sadhar aja!!");
            statusLabel.setForeground(Color.red);
        }

        pesan.setFont(new Font("Aerial", Font.PLAIN, 14));

        infoDialog.add(statusLabel, gbc);
        gbc.gridy++;
        infoDialog.add(pesan, gbc);

        infoDialog.pack();
        infoDialog.setResizable(false);
        infoDialog.setLocationRelativeTo(this);
        infoDialog.setVisible(true);
    }

    public CombinedPane getCombinedPane() {
        return combinedPane;
    }
}
