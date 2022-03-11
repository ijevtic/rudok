package rudok.view.popup;

import rudok.model.logictree.workspace.Workspace;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class WorkspacePopup extends JDialog {
    public WorkspacePopup()
    {
        setSize(400,400);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JPanel p = new JPanel();
        JButton novi = new JButton("napravi novi workspace");
        JButton ucitaj = new JButton("učitaj workspace");

        p.add(novi);
        p.add(ucitaj);

        novi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        ucitaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                if(jfc.showSaveDialog(MainFrame.getMainFrame())==JFileChooser.APPROVE_OPTION) {
                    File f = jfc.getSelectedFile();
                    MainFrame.getMainFrame().setWorkspaceFile(f);
                    dispose();
                }
                else return;
            }
        });

        add(p);

    }
}
