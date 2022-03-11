package rudok.controller;

import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.model.logictree.workspace.Project;
import rudok.model.logictree.workspace.Workspace;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class WorkspaceTreeCellRendered extends DefaultTreeCellRenderer {

    public WorkspaceTreeCellRendered() {

        // TODO Auto-generated constructor stub
    }

    public Component getTreeCellRendererComponent(
            JTree tree,
            Object value,
            boolean sel,
            boolean expanded,
            boolean leaf,
            int row,
            boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        if(value instanceof MyTreeNode) {
            MyTreeNode n = (MyTreeNode) value;
            ImageIcon icon = null;
            if (n.getNode() instanceof Workspace)
                icon = new ImageIcon("E:\\rudok\\rudok-ijevtic\\src\\rudok\\actions\\images\\workspace.png");
            if (n.getNode() instanceof Project)
                icon = new ImageIcon("E:\\rudok\\rudok-ijevtic\\src\\rudok\\actions\\images\\project.png");
            if (n.getNode() instanceof Prezentacija)
                icon = new ImageIcon("E:\\rudok\\rudok-ijevtic\\src\\rudok\\actions\\images\\presentation.png");
            if(icon != null)
                setIcon(icon);
        }
//
//        } else if (value instanceof Project ) {
//            URL imageURL = getClass().getResource("images/tproject.gif");
//            Icon icon = null;
//            if (imageURL != null)
//                icon = new ImageIcon(imageURL);
//            setIcon(icon);
//


        return this;
    }

}

