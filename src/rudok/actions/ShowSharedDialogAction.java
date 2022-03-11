package rudok.actions;

import rudok.model.error.ErrorFactory;
import rudok.model.error.ErrorType;
import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.model.logictree.workspace.Project;
import rudok.view.MainFrame;
import rudok.view.popup.SetStrokePopup;
import rudok.view.popup.SharePresentationDialog;
import rudok.view.prezentacija.PrezentacijaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ShowSharedDialogAction extends AbstractRudokAction{
    public ShowSharedDialogAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("images/lol.png"));
        putValue(NAME, "Share pres");
        putValue(SHORT_DESCRIPTION, "Share ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyTreeNode treeNode = MainFrame.getMainFrame().getMyTree().selectedNode();
        if(treeNode == null || treeNode.getNode() == null) {
            ErrorFactory.getInstance().makeError(ErrorType.ILLEGAL_ACTION);
            return;
        }
        if(!(treeNode.getNode() instanceof Prezentacija)) return;
        SharePresentationDialog dialog = new SharePresentationDialog((Prezentacija) treeNode.getNode());
        dialog.setVisible(true);
    }
}
