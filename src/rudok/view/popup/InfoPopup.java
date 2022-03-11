package rudok.view.popup;

import javax.swing.*;

public class InfoPopup extends JDialog {
    public InfoPopup()
    {
        setSize(400,400);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JPanel p = new JPanel();
        ImageIcon slika = new ImageIcon(getClass().getResource("../../actions/images/information.png"));
        JLabel l = new JLabel("Ivan Jevtić 4/20RN", slika, JLabel.CENTER);
        p.add(l);
        add(p);

    }
}
