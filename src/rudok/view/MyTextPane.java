package rudok.view;

import rudok.view.slot.SlotView;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MyTextPane extends JTextPane {
    SlotView slotView;
    public MyTextPane(SlotView slotView) {
        this.slotView = slotView;
    }

    public void formatString() {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        boolean bold = false;
        boolean italic = false;
        boolean underline = false;
        promeni(attributeSet, false, false, false);
        String s = slotView.getModel().getContent().getS();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '*') bold = !bold;
            else if(s.charAt(i) == '~') italic = !italic;
            else if(s.charAt(i) == '_') underline = !underline;
            else {
                promeni(attributeSet, bold, italic, underline);
                dodajSlovo(this, attributeSet, s.charAt(i));
            }
        }
    }


    private void dodajSlovo(JTextPane pane, SimpleAttributeSet attributeSet, char c) {
        Document doc = pane.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), String.valueOf(c), attributeSet);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    private void promeni(SimpleAttributeSet attributeSet, boolean bold, boolean italic, boolean underline) {
        StyleConstants.setBold(attributeSet, bold);
        StyleConstants.setItalic(attributeSet, italic);
        StyleConstants.setUnderline(attributeSet, underline);
    }
}
