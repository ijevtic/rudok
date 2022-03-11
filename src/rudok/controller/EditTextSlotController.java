package rudok.controller;

import rudok.view.slot.SlotView;
import rudok.view.popup.EditTextSlotPopup;

public class EditTextSlotController implements IEditSlotController{
    @Override
    public void openDialog(SlotView slotView) {
        System.out.println("otvorio edit text slot dialog");
        EditTextSlotPopup p = new EditTextSlotPopup(slotView);
        p.setVisible(true);
    }
}
