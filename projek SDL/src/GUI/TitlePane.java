package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePane extends JPanel {
    private JLabel titleLabel;
    private ImageIcon lblIcon;
    private BufferedImage img;

    public TitlePane() {
        try {
            img = ImageIO.read(new File("C:\\Users\\MSI Prestige\\VSProject\\Projek SDL\\assets\\mbahSingo.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;

        titleLabel = new JLabel("HASIL SELEKSI SNBP");
        titleLabel.setOpaque(true);
        titleLabel.setFont(new Font("Aerial", Font.BOLD, 25));
        titleLabel.setAlignmentX(LEFT_ALIGNMENT);

        Image dimg = img.getScaledInstance(55, 55,
                Image.SCALE_SMOOTH);

        lblIcon = new ImageIcon(dimg);

        titleLabel.setIcon(lblIcon);
        titleLabel.setIconTextGap(15);

        add(titleLabel, gbc);
    }
}