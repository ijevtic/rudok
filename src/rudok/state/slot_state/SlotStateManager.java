package rudok.state.slot_state;

import rudok.view.StrokeType;
import java.awt.*;

public class SlotStateManager {
    private SlotState currentState;
    CursorState cursorState;
    DeleteSlotState deleteSlotState;
    AddState imageSlotState;
    AddState textSlotState;
    EditSlotState editSlotState;

    public SlotStateManager() {initStates();}

    private void initStates(){
        cursorState = new CursorState();
        deleteSlotState = new DeleteSlotState();
        imageSlotState = new ImageSlotState();
        textSlotState = new TextSlotState();
        editSlotState = new EditSlotState();
        currentState = cursorState;
    }

    public SlotState getCurrentState() {return currentState;}

    public void setCursorState() {currentState = cursorState;}
    public void setDeleteSlotState() {currentState = deleteSlotState;}
    public void setImageSlotState() {currentState = imageSlotState;}
    public void setTextSlotState() {currentState = textSlotState;}
    public void setEditSlotState() {currentState = editSlotState;}
    public void setColor(Color c){
        textSlotState.setColor(c);
        imageSlotState.setColor(c);
    }
    public void setStroke(StrokeType type) {
        textSlotState.setStroke(type);
        imageSlotState.setStroke(type);
    }
}
