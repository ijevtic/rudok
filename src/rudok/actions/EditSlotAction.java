package rudok.actions;

import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditSlotAction extends AbstractRudokAction {
    public EditSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/edit_slot.png"));
        putValue(NAME, "Edit slot");
        putValue(SHORT_DESCRIPTION, "Edit slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        if(p == null) return;
        p.startEditSlotState();
    }
}
