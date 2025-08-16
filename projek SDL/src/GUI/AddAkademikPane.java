package GUI;

import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddAkademikPane extends JPanel {
    private JLabel nameLabel;
    private JLabel ipaLabel;
    private JLabel mtkLabel;
    private JLabel indLabel;
    private JLabel ingLabel;

    private JTextField nameField;
    private JTextField ipaField;
    private JTextField mtkField;
    private JTextField indField;
    private JTextField ingField;

    public AddAkademikPane() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.insets = new Insets(8, 8, 8, 8);

        nameLabel = new JLabel("Nama:");
        nameLabel.setFont(new Font("Aerial", Font.BOLD, 15));

        ipaLabel = new JLabel("Nilai IPA:");
        ipaLabel.setFont(new Font("Aerial", Font.BOLD, 15));

        mtkLabel = new JLabel("Nilai Matematika:");
        mtkLabel.setFont(new Font("Aerial", Font.BOLD, 15));

        indLabel = new JLabel("Nilai Bahasa Indonesia:");
        indLabel.setFont(new Font("Aerial", Font.BOLD, 15));

        ingLabel = new JLabel("Nilai Bahasa Inggris:");
        ingLabel.setFont(new Font("Aerial", Font.BOLD, 15));

        nameField = new JTextField(20);
        nameField.setFont(new Font("Aerial", Font.PLAIN, 15));
        TextPrompt namePrompt = new TextPrompt("Nama Peserta", nameField);
        namePrompt.setFont(new Font("Aerial", Font.ITALIC, 10));
        namePrompt.changeAlpha(0.5f);

        ipaField = new JTextField(15);
        ipaField.setFont(new Font("Aerial", Font.PLAIN, 15));
        TextPrompt ipaPrompt = new TextPrompt("Masukkan nilai", ipaField);
        ipaPrompt.setFont(new Font("Aerial", Font.ITALIC, 10));
        ipaPrompt.changeAlpha(0.5f);

        mtkField = new JTextField(15);
        mtkField.setFont(new Font("Aerial", Font.PLAIN, 15));
        TextPrompt mtkPrompt = new TextPrompt("Masukkan nilai", mtkField);
        mtkPrompt.setFont(new Font("Aerial", Font.ITALIC, 10));
        mtkPrompt.changeAlpha(0.5f);

        indField = new JTextField(15);
        indField.setFont(new Font("Aerial", Font.PLAIN, 15));
        TextPrompt indPrompt = new TextPrompt("Masukkan nilai", indField);
        indPrompt.setFont(new Font("Aerial", Font.ITALIC, 10));
        indPrompt.changeAlpha(0.5f);

        ingField = new JTextField(15);
        ingField.setFont(new Font("Aerial", Font.PLAIN, 15));
        TextPrompt ingPrompt = new TextPrompt("Masukkan nilai", ingField);
        ingPrompt.setFont(new Font("Aerial", Font.ITALIC, 10));
        ingPrompt.changeAlpha(0.5f);

        add(nameLabel, gbc);
        gbc.gridy++;
        add(mtkLabel, gbc);
        gbc.gridy++;
        add(ipaLabel, gbc);
        gbc.gridy++;
        add(indLabel, gbc);
        gbc.gridy++;
        add(ingLabel, gbc);

        gbc.gridy = 0;
        gbc.gridx = 1;
        gbc.weightx = 1;
        add(nameField, gbc);
        gbc.gridy++;
        add(mtkField, gbc);
        gbc.gridy++;
        add(ipaField, gbc);
        gbc.gridy++;
        add(indField, gbc);
        gbc.gridy++;
        add(ingField, gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridy++;
        gbc.weighty = 1;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(new JPanel(), gbc);
    }

    public JTextField getNameText() {
        return nameField;
    }

    public JTextField getIpaText() {
        return ipaField;
    }

    public JTextField getMtkText() {
        return mtkField;
    }

    public JTextField getIndText() {
        return indField;
    }

    public JTextField getIngText() {
        return ingField;
    }
}