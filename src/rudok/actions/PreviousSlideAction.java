package rudok.actions;

import rudok.view.prezentacija.PrezentacijaView;
import rudok.view.prezentacija.Slideshow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PreviousSlideAction extends AbstractRudokAction{
    public PreviousSlideAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/back.png"));
        putValue(NAME, "Previous");
        putValue(SHORT_DESCRIPTION, "Previous");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        Slideshow s = p.getSlideshowPanel();
        s.getCardLayout().previous(s.getPanel());
        System.out.println("nazad");
    }


}
