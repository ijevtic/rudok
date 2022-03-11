package rudok.actions;

import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ColorChooserAction extends AbstractRudokAction{
    public ColorChooserAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/color.png"));
        putValue(NAME, "Change color");
        putValue(SHORT_DESCRIPTION, "Change color");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        if(p == null) return;
        Color c = JColorChooser.showDialog(null, "Choose a color", Color.RED);
        if(c == null) return;
        p.setColor(c);
    }
}
