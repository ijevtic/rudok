package rudok.state.appearence_state;

public class AppearenceStateManager {

    private AppearenceState currentState;
    private EditModeState editState;
    private SlideshowState slideshowState;

    public AppearenceStateManager() {initStates();}

    private void initStates(){
        editState = new EditModeState();
        slideshowState = new SlideshowState();
        currentState = editState;
    }

    public AppearenceState getCurrentState() {return currentState;}

    public void setEditState() {currentState = editState;}
    public void setSlideshowState() {currentState = slideshowState;}

}
