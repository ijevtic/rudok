package rudok.view.popup;

import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.logictree.workspace.Prezentacija;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class EditBackgroundPopup extends JDialog {

    List<String> nizEkstenzija = Arrays.asList("jpg", "png", "jpeg", "jiff", "img", "tiff", "psd", "raw");

    public EditBackgroundPopup(Prezentacija node)
    {
        setSize(500,500);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JPanel p = new JPanel();
        JFileChooser pozadina = new JFileChooser();
        pozadina.setMultiSelectionEnabled(false);
        pozadina.setControlButtonsAreShown(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Images", String.valueOf(nizEkstenzija));
        pozadina.setFileFilter(filter);


        setTitle("Promeni pozadinu prezentacije");
        JButton ok = new JButton("Potvrdi");
        JButton cancel = new JButton("Poništi");
        p.add(pozadina);
        p.add(ok);
        p.add(cancel);
        add(p);
        for(int i = 0; i < pozadina.getComponentCount(); i++) {
            System.out.println("JFileChooser " + pozadina.getComponents()[i]);
        }

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pozadina.getSelectedFile() == null)
                    ErrorFactory.getInstance().makeError(ErrorType.NOTHING_SELECTED);
                else{
                    String name = pozadina.getSelectedFile().getAbsolutePath();
                    int index = name.lastIndexOf('.');
                    String extension = "";
                    if(index > 0) extension = name.substring(index + 1);
                    if(!nizEkstenzija.contains(extension)) {
                        System.out.println(pozadina.getSelectedFile());
                        ErrorFactory.getInstance().makeError(ErrorType.INVALID_FILE_TYPE);
                    }
                    else {
                        node.setBackground(name);
                        System.out.println(name);
                        dispose();
                    }
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
