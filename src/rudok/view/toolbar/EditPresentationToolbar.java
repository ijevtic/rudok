package rudok.view.toolbar;

import rudok.view.MainFrame;

import javax.swing.*;

public class EditPresentationToolbar extends JToolBar {

    public EditPresentationToolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getMainFrame().getActionManager().getSlideshowModeAction());
        add(MainFrame.getMainFrame().getActionManager().getCursorSlotAction());
        add(MainFrame.getMainFrame().getActionManager().getEditSlotAction());
        add(MainFrame.getMainFrame().getActionManager().getTextSlotAction());
        add(MainFrame.getMainFrame().getActionManager().getImageSlotAction());
        add(MainFrame.getMainFrame().getActionManager().getDeleteSlotAction());
        add(MainFrame.getMainFrame().getActionManager().getColorChooserAction());
        add(MainFrame.getMainFrame().getActionManager().getSetStrokeAction());
    }
}
