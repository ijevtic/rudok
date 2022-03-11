package rudok.state.appearence_state;

import rudok.view.prezentacija.PrezentacijaView;

public class EditModeState extends AppearenceState {
    @Override
    public void show(PrezentacijaView p) {
        removeAll(p);
        p.add(p.getEditSplit());
        p.repaint();
        System.out.println("edit state");
    }
}