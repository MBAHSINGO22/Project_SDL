package GUI;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

public class AddNonAkademikPane extends JPanel {
    private JLabel nameLabel;
    private JLabel prestasiLabel;
    private JLabel tingkatLabel;
    private JLabel rankLabel;

    private JTextField nameField;
    private JTextField prestasiField;

    private JComboBox tingkatBox;
    private JComboBox rankBox;

    private JScrollPane scrollPane;
    private JTable table;
    private JButton tambahButton;

    private final Object[] HEADER = { "No.", "Prestasi", "Tingkat", "Rank" };
    private final String[] TINGKAT = {"Internasional", "Nasional", "Provinsi", "Kota"};
    private final String[] RANK = {"1", "2", "3"};

    public AddNonAkademikPane() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(6, 6, 6, 6);

        nameLabel = new JLabel("Nama:");
        nameLabel.setFont(new Font("Aerial", Font.BOLD, 13));

        prestasiLabel = new JLabel("Prestasi:");
        prestasiLabel.setFont(new Font("Aerial", Font.BOLD, 13));

        tingkatLabel = new JLabel("Tingkat:");
        tingkatLabel.setFont(new Font("Aerial", Font.BOLD, 13));

        rankLabel = new JLabel("Ranking:");
        rankLabel.setFont(new Font("Aerial", Font.BOLD, 13));

        nameField = new JTextField(20);
        nameField.setFont(new Font("Aerial", Font.PLAIN, 13));
        TextPrompt namePrompt = new TextPrompt("Nama Peserta", nameField);
        namePrompt.setFont(new Font("Aerial", Font.ITALIC, 9));
        namePrompt.changeAlpha(0.5f);

        prestasiField = new JTextField(13);
        prestasiField.setFont(new Font("Aerial", Font.PLAIN, 13));
        TextPrompt prestasiPrompt = new TextPrompt("Nama Prestasi", prestasiField);
        prestasiPrompt.setFont(new Font("Aerial", Font.ITALIC, 9));
        prestasiPrompt.changeAlpha(0.5f);

        tingkatBox = new JComboBox<>(TINGKAT);
        tingkatBox.setFocusable(false);
        tingkatBox.setFont(new Font("Aerial", Font.BOLD, 11));

        rankBox = new JComboBox<>(RANK);
        rankBox.setFocusable(false);
        rankBox.setFont(new Font("Aerial", Font.BOLD, 11));

        table = new JTable(new DefaultTableModel(HEADER, 0)){
            private static final long serialVersionUID = 1L;
    
            public boolean isCellEditable(int row, int column) {                
                    return false;               
            };
        };
        table.setFont(new Font("Aerial", Font.PLAIN, 12));
        table.getColumnModel().getColumn(0).setMaxWidth(35);
        table.getColumnModel().getColumn(3).setMaxWidth(70);
        table.getTableHeader().setFont(new Font("Aerial", Font.BOLD, 13));
        table.setRowHeight(25);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);

        scrollPane = new JScrollPane(table);
        scrollPane.setColumnHeader(new JViewport());

        tambahButton = new JButton("Tambah Prestasi");
        tambahButton.setFont(new Font("Aerial", Font.BOLD, 10));
        tambahButton.setFocusable(false);

        add(nameLabel, gbc);
        gbc.gridy++;
        add(prestasiLabel, gbc);
        gbc.gridy++;
        add(tingkatLabel, gbc);
        gbc.gridy++;
        add(rankLabel, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.ipadx = 250;
        add(nameField, gbc);
        gbc.gridy++;
        gbc.ipadx = 210;
        add(prestasiField, gbc);
        gbc.ipadx = 10;
        gbc.gridy++;
        add(tingkatBox, gbc);
        gbc.ipadx = 71;
        gbc.gridy++;
        add(rankBox, gbc);

        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.ipadx = 0;
        gbc.weightx = 1;
        add(tambahButton, gbc);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = 3;
        add(scrollPane, gbc);
    }

    public JTextField getNameText() {
        return nameField;
    }

    public JTextField getPrestasiText() {
        return prestasiField;
    }

    public String getTingkatText() {
        return tingkatBox.getSelectedItem().toString();
    }

    public String getRankText() {
        return rankBox.getSelectedItem().toString();
    }

    public JButton getTambahButton() {
        return tambahButton;
    }

    public JTable getTable() {
        return table;
    }
}
