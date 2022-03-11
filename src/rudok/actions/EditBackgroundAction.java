package rudok.actions;

import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.view.MainFrame;
import rudok.view.popup.EditBackgroundPopup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditBackgroundAction extends AbstractRudokAction {
    public EditBackgroundAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/edit_background.png"));
        putValue(NAME, "Promeni Pozadinu");
        putValue(SHORT_DESCRIPTION, "Promeni Pozadinu");
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getMyTree().selectedNode();
        if(treeNode == null || !(treeNode.getNode() instanceof Prezentacija)) {
            ErrorFactory.getInstance().makeError(ErrorType.ILLEGAL_ACTION);
            System.out.println("Ne moze da se menja pozadina od ovoga!");
            return;
        }
        EditBackgroundPopup dialog = new EditBackgroundPopup((Prezentacija)(treeNode.getNode()));
        dialog.setVisible(true);
    }
}
