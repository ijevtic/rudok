package rudok.actions;

import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.RuNode;
import rudok.model.logictree.workspace.Project;
import rudok.model.logictree.workspace.Workspace;
import rudok.utils.ProjectFileFilter;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;

public class SaveProjectAction extends AbstractRudokAction{


    public SaveProjectAction() {

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/filesave.png"));
        putValue(NAME, "Save project");
        putValue(SHORT_DESCRIPTION, "Save project");
    }

    public void actionPerformed(ActionEvent arg0) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getMyTree().selectedNode();
        if(treeNode == null || treeNode.getNode() == null) {
            ErrorFactory.getInstance().makeError(ErrorType.ILLEGAL_ACTION);
            return;
        }
        if(!(treeNode.getNode() instanceof Project)) {
            System.out.println("nesto jako lose");
            return;
        }
        saveProject((Project) treeNode.getNode(),null);
    }

}
