package rudok.actions;

import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TextSlotAction extends AbstractRudokAction {
    public TextSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/text_slot.png"));
        putValue(NAME, "TextSlot");
        putValue(SHORT_DESCRIPTION, "TextSlot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        if(p == null) return;
        p.startTextSlotState();

    }
}
