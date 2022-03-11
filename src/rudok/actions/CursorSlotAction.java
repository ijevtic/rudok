package rudok.actions;

import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CursorSlotAction extends AbstractRudokAction{
    public CursorSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/cursor_slot.png"));
        putValue(NAME, "Cursor slot");
        putValue(SHORT_DESCRIPTION, "Cursor slot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        if(p == null) return;
        p.startCursorState();
    }
}
