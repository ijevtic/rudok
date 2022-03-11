package rudok.actions;

import rudok.view.popup.InfoPopup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class InfoAction extends AbstractRudokAction {
    public InfoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_I, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/information.png"));
        putValue(NAME, "Info");
        putValue(SHORT_DESCRIPTION, "Info");
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        InfoPopup dialog = new InfoPopup();
        dialog.setVisible(true);
    }
}
