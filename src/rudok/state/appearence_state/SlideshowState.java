package rudok.state.appearence_state;

import rudok.view.prezentacija.PrezentacijaView;

import java.awt.*;

public class SlideshowState extends AppearenceState {
    @Override
    public void show(PrezentacijaView p) {
        removeAll(p);
        p.add(p.getSlideshowPanel(), BorderLayout.CENTER);
        p.repaint();
        System.out.println("slideshow state");
    }
}
