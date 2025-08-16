package GUI;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CombinedPane extends JPanel {
    private TitlePane titlePane;
    private ActionPane actionPane;
    private DaftarPane daftarPane;
    private AddAkademikPane addAkademikPane;
    private AddNonAkademikPane addNonAkademikPane;
    private RightPane rightPane;
    private JPanel mainDisplayPane;
    private JPanel addPane;

    public CombinedPane(TitlePane titlePane, ActionPane actionPane, DaftarPane daftarPane,
            AddAkademikPane addAkademikPane, AddNonAkademikPane addNonAkademikPane, RightPane rightPane) {
        this.titlePane = titlePane;
        this.actionPane = actionPane;
        this.daftarPane = daftarPane;
        this.addAkademikPane = addAkademikPane;
        this.addNonAkademikPane = addNonAkademikPane;
        this.rightPane = rightPane;
        
        setLayout(new GridBagLayout());
        setBorder(new EmptyBorder(40, 35, 40, 35));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(4, 4, 4, 4);

        add(titlePane, gbc);
        gbc.gridy++;
        add(actionPane, gbc);

        mainDisplayPane = new JPanel();
        mainDisplayPane.setLayout(new BorderLayout());

        addPane = new JPanel();
        addPane.setLayout(new BorderLayout());
        addPane.add(addAkademikPane);

        gbc.gridy++;
        gbc.weightx = 1;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        add(mainDisplayPane, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.ipadx = 20;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(rightPane, gbc);
    }

    public TitlePane getTitlePane() {
        return titlePane;
    }

    public ActionPane getActionPane() {
        return actionPane;
    }

    public DaftarPane getDaftarPane() {
        return daftarPane;
    }

    public AddAkademikPane getAddAkademikPane() {
        return addAkademikPane;
    }

    public AddNonAkademikPane getAddNonAkademikPane() {
        return addNonAkademikPane;
    }

    public RightPane getRightPane() {
        return rightPane;
    }

    public JPanel getMainDisplayPane() {
        return mainDisplayPane;
    }

    public JPanel getAddPane() {
        return addPane;
    }

}