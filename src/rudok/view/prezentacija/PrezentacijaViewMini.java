package rudok.view.prezentacija;
import rudok.view.VelicinaSlajda;

import javax.swing.*;

public class PrezentacijaViewMini extends APrezentacijaView{

    public PrezentacijaViewMini() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setContainer(this);
    }

    @Override
    public void update(Object notification) {
        System.out.println("Prezentacija View Mini");
        updateView(VelicinaSlajda.SMALL);
    }
}
