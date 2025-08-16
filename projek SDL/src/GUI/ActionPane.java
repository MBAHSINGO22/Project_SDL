package GUI;

import java.awt.*;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ActionPane extends JPanel {
    private JComboBox menuBox;
    private JComboBox categoryBox;
    private JComboBox categoryBoxAdd;
    private JTextField searchField;
    private TextPrompt searchPrompt;
    private JButton searchButton;

    private int categoryBoxState;
    private final String[] MENU = { "Home", "Daftar Peserta", "Tambah Peserta" };
    private final String[] CATEGORY = { "Semua", "Akademik", "Non Akademik" };
    private final String[] CATEGORY_ADD = { "Akademik", "Non Akademik" };

    public ActionPane() {
        setLayout(new GridBagLayout());
        setBorder(new CompoundBorder(new TitledBorder("Menu"), new EmptyBorder(12, 0, 0, 0)));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 20, 20);

        menuBox = new JComboBox(MENU);
        menuBox.setFont(new Font("Aerial", Font.BOLD, 18));
        menuBox.setFocusable(false);

        categoryBox = new JComboBox(CATEGORY);
        categoryBox.setFont(new Font("Aerial", Font.BOLD, 15));
        categoryBox.setFocusable(false);

        categoryBoxAdd = new JComboBox<>(CATEGORY_ADD);
        categoryBoxAdd.setFont(new Font("Aerial", Font.BOLD, 15));
        categoryBoxAdd.setFocusable(false);

        searchField = new JTextField(4);
        searchField.setFont(new Font("Aerial", Font.BOLD, 15));

        searchPrompt = new TextPrompt("Cari No. Peserta", searchField);
        searchPrompt.setFont(new Font("Aerial", Font.ITALIC, 12));
        searchPrompt.changeAlpha(0.5f);

        searchButton = new JButton();
        searchButton.setText("Cari");
        searchButton.setFont(new Font("Aerial", Font.BOLD, 10));
        searchButton.setFocusable(false);

        add(menuBox, gbc);

        gbc.gridx++;
        add(categoryBox, gbc);
        categoryBoxState = 0;

        gbc.weightx = 0;
        gbc.gridx++;
        gbc.ipadx = 80;
        add(searchField, gbc);

        gbc.gridx++;
        gbc.ipadx = 20;
        add(searchButton, gbc);

        categoryBox.setVisible(false);
        searchField.setVisible(false);
        searchButton.setVisible(false);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx++;
        gbc.ipadx = 0;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(0, 0, 0, 0);

        add(new JPanel(null), gbc);
    }

    public void changeCategoryBox() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 20, 20);
        if (categoryBoxState == 0) {
            remove(categoryBox);
            gbc.gridy = 0;
            gbc.gridx = 1;
            add(categoryBoxAdd, gbc);
            categoryBoxState = 1;
        } else {
            remove(categoryBoxAdd);
            gbc.gridy = 0;
            gbc.gridx = 1;
            add(categoryBox, gbc);
            categoryBoxState = 0;
        }
    }

    public JComboBox getMenuBox() {
        return menuBox;
    }

    public JComboBox getCategoryBox() {
        return categoryBox;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public JComboBox getCategoryBoxAdd() {
        return categoryBoxAdd;
    }

    public JButton getSearchButton() {
        return searchButton;
    }
}