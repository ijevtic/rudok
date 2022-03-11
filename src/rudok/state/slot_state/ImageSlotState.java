package rudok.state.slot_state;

import rudok.model.ImageSlot;
import rudok.model.Slot;
import rudok.view.MainFrame;
import rudok.view.SlajdView;

public class ImageSlotState extends AddState{

    @Override
    public void modify(int x, int y, SlajdView s) {
        Slot slot = new ImageSlot(x*1.0/s.getWidth(), y*1.0/s.getHeight(), 50.0/s.getWidth(), 50.0/s.getHeight(),
                getR(),getG(),getB(), getStroke());
        s.getModel().addChild(slot);
        System.out.println("image slot state");
    }
}
