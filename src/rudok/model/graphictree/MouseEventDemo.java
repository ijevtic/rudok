package rudok.model.graphictree;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.workspace.Project;
import rudok.view.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventDemo implements MouseListener {
    //where initialization occurs:
    MyTree tree;

    public MouseEventDemo(MyTree tree) {
        this.tree = tree;
    }


    @Override
    public void mouseClicked(MouseEvent e) {

        if(tree.selectedNode() == null) return;
        RuNode node = tree.selectedNode().getNode();
        if(node instanceof Project && MainFrame.getMainFrame().getSharePresentationDialog() != null)
            MainFrame.getMainFrame().getSharePresentationDialog().setProjekat((Project) node);
        if(e.getClickCount() == 2) {
            tree.openComponent();
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
