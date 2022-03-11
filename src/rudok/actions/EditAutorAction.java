package rudok.actions;

import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.view.MainFrame;
import rudok.view.popup.EditAutorPopup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAutorAction extends AbstractRudokAction {
    public EditAutorAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/edit_autor.png"));
        putValue(NAME, "Promeni Autora");
        putValue(SHORT_DESCRIPTION, "Promeni Autora");
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getMyTree().selectedNode();
        if(treeNode == null || !(treeNode.getNode() instanceof Prezentacija)) {
            ErrorFactory.getInstance().makeError(ErrorType.ILLEGAL_ACTION);
            System.out.println("Ne moze da se menja autor od ovoga!");
            return;
        }
        EditAutorPopup dialog = new EditAutorPopup((Prezentacija)(treeNode.getNode()));
        dialog.setVisible(true);
    }
}
