package rudok.state.slot_state;

import rudok.view.SlajdView;
import rudok.view.slot.SlotView;

public class EditSlotState implements SlotState{
    @Override
    public void modify(int x, int y, SlajdView s) {
        SlotView selektovani = s.getSelektovaniSlot();
        if(selektovani == null) return;
        selektovani.getDialogAction().openDialog(selektovani);
    }
}
