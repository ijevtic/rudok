package rudok.state.slot_state;

import rudok.model.logictree.workspace.Slajd;
import rudok.view.SlajdView;
import rudok.view.slot.SlotView;

import java.util.List;

public class DeleteSlotState implements SlotState{
    @Override
    public void modify(int x, int y, SlajdView s) {
        List<SlotView> listaSlotova = s.getListaSlotova();
        Slajd slajd = s.getModel();
        for(int i = listaSlotova.size()-1; i >= 0; i--) {
            if(listaSlotova.get(i).slotElementAt(x,y)) {
                slajd.removeChild(listaSlotova.get(i).getModel());
                return;
            }
        }
    }
}
