package rudok.view.popup;
import rudok.command.ShareNodeCommand;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.model.logictree.workspace.Project;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SharePresentationDialog extends JDialog {

    private Prezentacija prezentacija;
    private Project projekat;
    private JLabel lblProjekat;
    private JButton btnShare;

    public SharePresentationDialog(Prezentacija prezentacija) {
        super(MainFrame.getMainFrame(), false);
        setLocationRelativeTo(null);
        this.prezentacija = prezentacija;

        JPanel dialogPanel=new JPanel();
        GridLayout g = new GridLayout(3,1);
        g.setHgap(20);
        g.setVgap(20);
        dialogPanel.setLayout(g);

        JLabel lbl = new JLabel("Izaberite projekat sa kojim želite da podelite prezentaciju");
        lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        dialogPanel.add(lbl);

        lblProjekat = new JLabel(" - ");
        lblProjekat.setAlignmentX(Component.CENTER_ALIGNMENT);


        dialogPanel.add(lblProjekat);

        btnShare = new JButton("Podeli");
        dialogPanel.add(btnShare);


        SharePresentationDialog self = this;
        btnShare.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getMainFrame().getCommandManager().addCommand(
                        new ShareNodeCommand(MainFrame.getMainFrame().getSharePresentationDialog().getPrezentacija(),
                                MainFrame.getMainFrame().getSharePresentationDialog().getProjekat()));
                self.setVisible(false);
            }
        });
        btnShare.setEnabled(false);
        btnShare.setText("Podeli");

        this.add(dialogPanel);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(300, 200);
        this.setVisible(true);

        MainFrame.getMainFrame().setSharePresentationDialog(this);
    }

    public void setProjekat(Project projekat) {
        this.projekat = projekat;
        this.lblProjekat.setText(projekat.getIme());
        this.btnShare.setEnabled(true);
    }

    public Prezentacija getPrezentacija() {
        return prezentacija;
    }

    public Project getProjekat() {
        return projekat;
    }
}
