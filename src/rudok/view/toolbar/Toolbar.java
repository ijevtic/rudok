package rudok.view.toolbar;

import rudok.view.MainFrame;

import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar(){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getMainFrame().getActionManager().getNewComponentAction());
        add(MainFrame.getMainFrame().getActionManager().getInfoAction());
        add(MainFrame.getMainFrame().getActionManager().getEditAutorAction());
        add(MainFrame.getMainFrame().getActionManager().getEditBackgroundAction());
        add(MainFrame.getMainFrame().getActionManager().getSaveProjectAction());
        add(MainFrame.getMainFrame().getActionManager().getDeleteComponentAction());
        add(MainFrame.getMainFrame().getActionManager().getOpenProjectAction());
        add(MainFrame.getMainFrame().getActionManager().getSaveWorkspaceAction());
        add(MainFrame.getMainFrame().getActionManager().getUndoAction());
        add(MainFrame.getMainFrame().getActionManager().getRedoAction());
        add(MainFrame.getMainFrame().getActionManager().getShowSharedDialogAction());



        //add(MainFrame.getMainFrame().getActionManager().getExitAction());
    }

}
