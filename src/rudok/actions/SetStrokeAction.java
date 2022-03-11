package rudok.actions;

import rudok.view.popup.SetStrokePopup;
import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SetStrokeAction extends AbstractRudokAction {

    public SetStrokeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/stroke.png"));
        putValue(NAME, "Set Stroke");
        putValue(SHORT_DESCRIPTION, "Set Stroke");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        if(p == null) return;
        System.out.println("stroke");
        SetStrokePopup s = new SetStrokePopup(p);
        s.setVisible(true);
    }
}
