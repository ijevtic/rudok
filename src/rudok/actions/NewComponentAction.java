package rudok.actions;

import rudok.command.NewNodeCommand;
import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;
import rudok.model.logictree.workspace.factory_method.RuNodeFactory;
import rudok.model.logictree.workspace.factory_method.SimpleFactory;
import rudok.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewComponentAction extends AbstractRudokAction {
    public NewComponentAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/add.png"));
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "New");
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getMyTree().selectedNode();
        if(treeNode == null || !(treeNode.getNode() instanceof RuNodeComposite)) {
            ErrorFactory.getInstance().makeError(ErrorType.ILLEGAL_ACTION);
            return;
        }

        RuNode parent = treeNode.getNode();
//        RuNodeFactory fabrika = SimpleFactory.getFactory(parent);
//        RuNode newNode = fabrika.vratiCvor(parent);
//        MyTreeNode newTreeNode = new MyTreeNode(newNode);
//
//        ((RuNodeComposite) treeNode.getNode()).addChild(newNode);
//        treeNode.add(newTreeNode);
        MainFrame.getMainFrame().getCommandManager().addCommand(new NewNodeCommand(treeNode));

        MainFrame.getMainFrame().getMyTree().updateTree();
        MainFrame.getMainFrame().getMyTree().expandPath(MainFrame.getMainFrame().getMyTree().getSelectionPath());
    }
}
