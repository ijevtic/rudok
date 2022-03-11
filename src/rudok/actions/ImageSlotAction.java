package rudok.actions;

import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ImageSlotAction extends AbstractRudokAction{
    public ImageSlotAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/image_slot.png"));
        putValue(NAME, "ImageSlot");
        putValue(SHORT_DESCRIPTION, "ImageSlot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        if(p == null) return;
        p.startImageSlotState();
    }
}
