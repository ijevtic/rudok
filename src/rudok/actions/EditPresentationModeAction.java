package rudok.actions;

import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditPresentationModeAction extends AbstractRudokAction{

    public EditPresentationModeAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/edit_presentation.png"));
        putValue(NAME, "Slideshow");
        putValue(SHORT_DESCRIPTION, "Slideshow");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        if(p == null) return;
        p.startEditState();
    }
}
