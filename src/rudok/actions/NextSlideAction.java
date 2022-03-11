package rudok.actions;

import rudok.view.prezentacija.PrezentacijaView;
import rudok.view.prezentacija.Slideshow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NextSlideAction extends AbstractRudokAction{
    public NextSlideAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/next.png"));
        putValue(NAME, "Next");
        putValue(SHORT_DESCRIPTION, "Next");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        PrezentacijaView p = getFocusPresentation();
        Slideshow s = p.getSlideshowPanel();
        s.getCardLayout().next(s.getPanel());
        System.out.println("napred");
    }
}
