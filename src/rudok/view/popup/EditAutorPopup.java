package rudok.view.popup;

import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.logictree.workspace.Prezentacija;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditAutorPopup extends JDialog {
    public EditAutorPopup(Prezentacija node)
    {
        setSize(200,150);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JPanel p = new JPanel();
        JTextField imeAutora = new JTextField(10);

        setTitle("Promeni ime autora");
        JButton ok = new JButton("Potvrdi");
        JButton cancel = new JButton("Poništi");
        p.add(imeAutora);
        p.add(ok);
        p.add(cancel);
        add(p);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = imeAutora.getText();
                if(text.isBlank())
                    ErrorFactory.getInstance().makeError(ErrorType.EMPTY_FIELD);
                else {
                    node.setAutor(text);
                    dispose();
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
