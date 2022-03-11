package rudok.state.appearence_state;

import rudok.view.prezentacija.PrezentacijaView;

public abstract class AppearenceState {
     public abstract void show(PrezentacijaView p);
     public void removeAll(PrezentacijaView p) {
          p.removeAll();
          p.revalidate();
     }
}
