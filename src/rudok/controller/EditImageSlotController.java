package rudok.controller;

import rudok.view.slot.SlotView;
import rudok.view.popup.EditImageSlotPopup;

public class EditImageSlotController implements IEditSlotController{
    @Override
    public void openDialog(SlotView slotView) {
        System.out.println("otvorio edit image slot dialog");
        EditImageSlotPopup p = new EditImageSlotPopup(slotView);
        p.setVisible(true);
    }
}
