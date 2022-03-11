package rudok.view.popup;

import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.view.StrokeType;
import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SetStrokePopup extends JDialog {
    public SetStrokePopup(PrezentacijaView prezentacijaView){
        setSize(200,150);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JPanel p = new JPanel();

        ButtonGroup buttonGroup = new ButtonGroup();
        JButton ok = new JButton("Potvrdi");
        JButton cancel = new JButton("Poništi");
        JToggleButton fill = new JToggleButton(loadIcon("images/fill_stroke.png"));
        JToggleButton dash = new JToggleButton(loadIcon("images/dashed_stroke.png"));
        buttonGroup.add(fill);
        buttonGroup.add(dash);
        p.add(fill);
        p.add(dash);
        p.add(ok);
        p.add(cancel);

        add(p);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!fill.isSelected() && !dash.isSelected())
                    ErrorFactory.getInstance().makeError(ErrorType.EMPTY_FIELD);
                else {
                    if(fill.isSelected())
                        prezentacijaView.setStroke(StrokeType.FULL);
                    else
                        prezentacijaView.setStroke(StrokeType.DASHED);
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
