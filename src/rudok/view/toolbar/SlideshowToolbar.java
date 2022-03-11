package rudok.view.toolbar;

import rudok.view.MainFrame;

import javax.swing.*;

public class SlideshowToolbar extends JToolBar{
    public SlideshowToolbar(){
        super(HORIZONTAL);
        setFloatable(false);
        add(MainFrame.getMainFrame().getActionManager().getPreviousSlideAction());
        add(MainFrame.getMainFrame().getActionManager().getNextSlideAction());
        add(MainFrame.getMainFrame().getActionManager().getEditPresentationModeAction());
    }
}
