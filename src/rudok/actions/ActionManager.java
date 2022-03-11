package rudok.actions;

public class ActionManager {

    DeleteComponentAction deleteComponentAction;
    NewComponentAction newComponentAction;
    InfoAction infoAction;
    EditAutorAction editAutorAction;
    EditBackgroundAction editBackgroundAction;
    SlideshowModeAction slideshowModeAction;
    EditPresentationModeAction editPresentationModeAction;
    PreviousSlideAction previousSlideAction;
    NextSlideAction nextSlideAction;
    ImageSlotAction imageSlotAction;
    TextSlotAction textSlotAction;
    DeleteSlotAction deleteSlotAction;
    CursorSlotAction cursorSlotAction;
    ColorChooserAction colorChooserAction;
    SetStrokeAction setStrokeAction;
    EditSlotAction editSlotAction;
    SaveProjectAction saveProjectAction;
    OpenProjectAction openProjectAction;
    SaveWorkspaceAction saveWorkspaceAction;
    RedoAction redoAction;
    UndoAction undoAction;
    ShowSharedDialogAction showSharedDialogAction;

    public ActionManager() { initialize(); }

    private void initialize() {
        deleteComponentAction = new DeleteComponentAction();
        newComponentAction = new NewComponentAction();
        infoAction = new InfoAction();
        editAutorAction = new EditAutorAction();
        editBackgroundAction = new EditBackgroundAction();
        slideshowModeAction = new SlideshowModeAction();
        editPresentationModeAction = new EditPresentationModeAction();
        previousSlideAction = new PreviousSlideAction();
        nextSlideAction = new NextSlideAction();
        imageSlotAction = new ImageSlotAction();
        textSlotAction = new TextSlotAction();
        deleteSlotAction = new DeleteSlotAction();
        cursorSlotAction = new CursorSlotAction();
        colorChooserAction = new ColorChooserAction();
        setStrokeAction = new SetStrokeAction();
        editSlotAction = new EditSlotAction();
        saveProjectAction = new SaveProjectAction();
        openProjectAction = new OpenProjectAction();
        saveWorkspaceAction = new SaveWorkspaceAction();
        redoAction = new RedoAction();
        undoAction = new UndoAction();
        showSharedDialogAction = new ShowSharedDialogAction();
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public DeleteComponentAction getDeleteComponentAction() {
        return deleteComponentAction;
    }

    public void setDeleteComponentAction(DeleteComponentAction deleteComponentAction) {
        this.deleteComponentAction = deleteComponentAction;
    }

    public NewComponentAction getNewComponentAction() {
        return newComponentAction;
    }

    public void setNewComponentAction(NewComponentAction newComponentAction) {
        this.newComponentAction = newComponentAction;
    }

    public EditAutorAction getEditAutorAction() {
        return editAutorAction;
    }

    public void setEditAutorAction(EditAutorAction editAutorAction) {
        this.editAutorAction = editAutorAction;
    }

    public EditBackgroundAction getEditBackgroundAction() {
        return editBackgroundAction;
    }

    public void setEditBackgroundAction(EditBackgroundAction editBackgroundAction) {
        this.editBackgroundAction = editBackgroundAction;
    }

    public SlideshowModeAction getSlideshowModeAction() {
        return slideshowModeAction;
    }

    public void setSlideshowModeAction(SlideshowModeAction slideshowModeAction) {
        this.slideshowModeAction = slideshowModeAction;
    }

    public EditPresentationModeAction getEditPresentationModeAction() {
        return editPresentationModeAction;
    }

    public void setEditPresentationModeAction(EditPresentationModeAction editPresentationModeAction) {
        this.editPresentationModeAction = editPresentationModeAction;
    }

    public PreviousSlideAction getPreviousSlideAction() {
        return previousSlideAction;
    }

    public void setPreviousSlideAction(PreviousSlideAction previousSlideAction) {
        this.previousSlideAction = previousSlideAction;
    }

    public NextSlideAction getNextSlideAction() {
        return nextSlideAction;
    }

    public void setNextSlideAction(NextSlideAction nextSlideAction) {
        this.nextSlideAction = nextSlideAction;
    }

    public ImageSlotAction getImageSlotAction() {
        return imageSlotAction;
    }

    public void setImageSlotAction(ImageSlotAction imageSlotAction) {
        this.imageSlotAction = imageSlotAction;
    }

    public TextSlotAction getTextSlotAction() {
        return textSlotAction;
    }

    public void setTextSlotAction(TextSlotAction textSlotAction) {
        this.textSlotAction = textSlotAction;
    }

    public DeleteSlotAction getDeleteSlotAction() {
        return deleteSlotAction;
    }

    public void setDeleteSlotAction(DeleteSlotAction deleteSlotAction) {
        this.deleteSlotAction = deleteSlotAction;
    }

    public CursorSlotAction getCursorSlotAction() {
        return cursorSlotAction;
    }

    public void setCursorSlotAction(CursorSlotAction cursorSlotAction) {
        this.cursorSlotAction = cursorSlotAction;
    }

    public ColorChooserAction getColorChooserAction() {
        return colorChooserAction;
    }

    public void setColorChooserAction(ColorChooserAction colorChooserAction) {
        this.colorChooserAction = colorChooserAction;
    }

    public SetStrokeAction getSetStrokeAction() {
        return setStrokeAction;
    }

    public void setSetStrokeAction(SetStrokeAction setStrokeAction) {
        this.setStrokeAction = setStrokeAction;
    }

    public EditSlotAction getEditSlotAction() {
        return editSlotAction;
    }

    public void setEditSlotAction(EditSlotAction editSlotAction) {
        this.editSlotAction = editSlotAction;
    }

    public SaveProjectAction getSaveProjectAction() {
        return saveProjectAction;
    }

    public void setSaveProjectAction(SaveProjectAction saveProjectAction) {
        this.saveProjectAction = saveProjectAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public void setOpenProjectAction(OpenProjectAction openProjectAction) {
        this.openProjectAction = openProjectAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public SaveWorkspaceAction getSaveWorkspaceAction() {
        return saveWorkspaceAction;
    }

    public void setSaveWorkspaceAction(SaveWorkspaceAction saveWorkspaceAction) {
        this.saveWorkspaceAction = saveWorkspaceAction;
    }

    public ShowSharedDialogAction getShowSharedDialogAction() {
        return showSharedDialogAction;
    }

    public void setShowSharedDialogAction(ShowSharedDialogAction showSharedDialogAction) {
        this.showSharedDialogAction = showSharedDialogAction;
    }
}
