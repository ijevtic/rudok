package rudok.view.popup;

import rudok.model.SlotContent;
import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.view.slot.SlotView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class EditImageSlotPopup extends JDialog {
    private List<String> nizEkstenzija = Arrays.asList("jpg", "png", "jpeg", "jiff", "img", "tiff", "psd", "raw");
    private String pozadina;
    private JButton open, save;
    private SlotView slotView;
    private SlikaPanel panelSlika;
    public EditImageSlotPopup(SlotView slotView)
    {
        setSize(500,400);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        this.slotView = slotView;

        configureButtons();

        GridLayout layout = new GridLayout(1,2);
        layout.setHgap(80);
        buttonPanel.setLayout(layout);
        buttonPanel.add(save);
        buttonPanel.add(open);
        p.add(buttonPanel, BorderLayout.NORTH);

        panelSlika = new SlikaPanel(slotView.getModel().getContent().getS());

        p.add(panelSlika, BorderLayout.CENTER);

        add(p);
        setTitle("Edit image slot popup");


    }

    private void configureButtons() {
        save = new JButton("save");
        open = new JButton("open");

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser pozadina = new JFileChooser();
                pozadina.setMultiSelectionEnabled(false);
                pozadina.setControlButtonsAreShown(false);
                int res = pozadina.showOpenDialog(null);
                if(res == JFileChooser.APPROVE_OPTION)
                    if (pozadina.getSelectedFile() == null)
                        ErrorFactory.getInstance().makeError(ErrorType.NOTHING_SELECTED);
                    else{
                        String path = pozadina.getSelectedFile().getAbsolutePath();
                        int index = path.lastIndexOf('.');
                        String extension = "";
                        if(index > 0) extension = path.substring(index + 1);
                        if(!nizEkstenzija.contains(extension)) {
                            System.out.println(pozadina.getSelectedFile());
                            ErrorFactory.getInstance().makeError(ErrorType.INVALID_FILE_TYPE);
                        }
                        else {
                            panelSlika.setPath(path);
                        }
                    }
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panelSlika.getPath().equals(""))
                    ErrorFactory.getInstance().makeError(ErrorType.NOTHING_SELECTED);
                else{
                    slotView.getModel().setContent(new SlotContent(panelSlika.getPath()));
                }
            }
        });
    }

}
