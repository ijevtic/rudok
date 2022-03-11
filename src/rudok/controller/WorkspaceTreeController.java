package rudok.controller;

import rudok.model.graphictree.MyTreeNode;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class WorkspaceTreeController implements TreeSelectionListener {

    public void valueChanged(TreeSelectionEvent e) {
        // TODO Auto-generated method stub

        TreePath path = e.getPath();
        for(int i=0; i<path.getPathCount(); i++){
            MyTreeNode p = (MyTreeNode) path.getPathComponent(i);
            if(p == null) break;
            System.out.println(p);
            System.out.println("getPath: "+e.getPath());
            System.out.println("getPath: "+e.getNewLeadSelectionPath());
            //if(p.getNode() instanceof Slajd) break;
        }
    }

}

