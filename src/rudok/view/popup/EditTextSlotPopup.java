package rudok.view.popup;

import rudok.view.MyTextPane;
import rudok.view.slot.SlotView;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditTextSlotPopup extends JDialog {
    private JButton bold, italic, underline, save;
    private MyTextPane pane;
    private JPanel north;
    private SlotView slotView;
    public EditTextSlotPopup(SlotView slotView)
    {
        setSize(500,400);
        setLocationRelativeTo(null);
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        JPanel p = new JPanel(new BorderLayout());
        north = new JPanel();
        GridLayout layout = new GridLayout(1,4);
        layout.setHgap(30);
        north.setLayout(layout);
        this.slotView = slotView;
        configureButtons();
        north.add(bold);
        north.add(italic);
        north.add(underline);
        north.add(save);
        p.add(north, BorderLayout.NORTH);
        pane = new MyTextPane(slotView);
        pane.setBackground(Color.GRAY);
        pane.setMinimumSize(new Dimension(500,300));
        pane.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));
        pane.formatString();
        p.add(pane, BorderLayout.CENTER);
        add(p);

        setTitle("Edit text slot popup");
    }

    private void configureButtons() {
        bold = new JButton("Bold");
        italic = new JButton("Italic");
        underline = new JButton("Underline");
        save = new JButton("Save");

        bold.addActionListener(new StyledEditorKit.BoldAction());
        italic.addActionListener(new StyledEditorKit.ItalicAction());
        underline.addActionListener(new StyledEditorKit.UnderlineAction());

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                String s = pane.getText();
                StringBuilder rez = new StringBuilder();
                boolean bBold = false;
                boolean bItalic = false;
                boolean bUnderline = false;
                for(int i = 0; i < s.length(); i++) {
                    Element element = doc.getCharacterElement(i);
                    AttributeSet as = element.getAttributes();
                    if(bBold != StyleConstants.isBold(as)) {
                        rez.append("*");
                        bBold = !bBold;
                    }
                    if(bItalic != StyleConstants.isItalic(as)) {
                        rez.append("~");
                        bItalic = !bItalic;
                    }
                    if(bUnderline != StyleConstants.isUnderline(as)) {
                        rez.append("_");
                        bUnderline = !bUnderline;
                    }
                    rez.append(s.charAt(i));
                }
                slotView.getModel().getContent().setS(rez.toString());
            }
        });
    }
}
