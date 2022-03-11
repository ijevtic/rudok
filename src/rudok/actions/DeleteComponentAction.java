package rudok.actions;

import rudok.command.DeleteNodeCommand;
import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;
import rudok.model.logictree.workspace.Workspace;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class DeleteComponentAction extends AbstractRudokAction {

    public DeleteComponentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/exit.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getMyTree().selectedNode();
        if(treeNode == null || treeNode.getNode() == null) {
            ErrorFactory.getInstance().makeError(ErrorType.ILLEGAL_ACTION);
            return;
        }

        if(treeNode.getNode() instanceof Workspace || treeNode.getParent() == null) return;
//        RuNode ruNode = treeNode.getNode();
        MyTreeNode treeParent = (MyTreeNode) treeNode.getParent();
//        RuNodeComposite ruParent = (RuNodeComposite) ruNode.getParent();
//        ruParent.removeChild(ruNode);
//        treeParent.remove(treeNode);

        MainFrame.getMainFrame().getCommandManager().addCommand(new DeleteNodeCommand(treeNode));

        MainFrame.getMainFrame().getMyTree().updateTree();
    }
}
