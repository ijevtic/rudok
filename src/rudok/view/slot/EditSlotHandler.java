package rudok.view.slot;

import rudok.model.Slot;

import java.awt.*;

public class EditSlotHandler implements ISlotHandler{
    @Override
    public void draw(Graphics2D g, SlotView slotView, int w, int h) {
        Slot model = slotView.getModel();
        g.fillRect((int)(model.getStartX()*w), (int)(model.getStartY()*h), (int)(model.getW()*w), (int)(model.getH()*h));
    }
}
