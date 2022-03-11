package rudok.state.slot_state;

import rudok.view.SlajdView;
import rudok.view.slot.SlotView;

public class CursorState implements SlotState{
    @Override
    public void modify(int x, int y, SlajdView s) {
        SlotView selektovani = s.getSelektovaniSlot();
        if(selektovani == null) return;
        System.out.println("usao u cursor state");
        selektovani.getModel().setPosition(x*1.0/s.getWidth(),y*1.0/s.getHeight());
    }
}
