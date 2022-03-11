package rudok.model.error;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ErrorDialog extends JDialog {
    public ErrorDialog(ErrorClass error) {
        setSize(300,220);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0;
        c.gridx = 0;
        c.gridy = 0;
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JTextArea errorMessage = new JTextArea(error.getMessage());
        errorMessage.setEditable(false);
        errorMessage.setLineWrap(true);
        errorMessage.setWrapStyleWord(true);

        JLabel icon = new JLabel();
        icon.setIcon(loadIcon(error.getIcon()));

        setTitle("Greška");
        JButton ok = new JButton("OK");
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        add(errorMessage, c);
        c.weightx = 1;
        c.gridx = 0;
        add(icon, c);
        c.gridx = 1;
        c.weightx = 0.5;
        c.gridy = 2;
        add(ok, c);
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public Icon loadIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if(imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.out.println("Resource not found: " + fileName);
        }
        return icon;
    }

}
