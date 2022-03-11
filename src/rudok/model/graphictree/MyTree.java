package rudok.model.graphictree;

import rudok.controller.WorkspaceTreeController;
import rudok.controller.WorkspaceTreeCellRendered;
import rudok.controller.WorkspaceTreeEditor;
import rudok.model.MyTreeModel;
import rudok.model.logictree.RuNode;
import rudok.model.logictree.workspace.Project;
import rudok.model.logictree.workspace.Workspace;
import rudok.view.MainFrame;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.util.List;

public class MyTree extends JTree {

    public MyTree() {
        addTreeSelectionListener(new WorkspaceTreeController());
        setCellEditor(new WorkspaceTreeEditor(this,new DefaultTreeCellRenderer()));
        setCellRenderer(new WorkspaceTreeCellRendered());
        setEditable(true);
        addMouseListener(new MouseEventDemo(this));
    }
    public void updateTree() {
        SwingUtilities.updateComponentTreeUI(this);
    }

    public MyTreeNode selectedNode() {
        Object obj = this.getLastSelectedPathComponent();
        if(!(obj instanceof MyTreeNode))
            return null;
        RuNode node = ((MyTreeNode)obj).getNode();
        if(node.getParent() == null && !(node instanceof Workspace))
            return null;
        return (MyTreeNode)obj;
    }

    public void openComponent() {
        MyTreeNode currentNode = selectedNode();
        if(currentNode == null) return;
        RuNode node = ((MyTreeNode)this.getLastSelectedPathComponent()).getNode();
        if(node instanceof Project)
            MainFrame.getMainFrame().getProjectView().setModel((Project)node);
        //if(node instanceof Prezentacija)

    }
    public void addProject(Project project){
//        MyTreeNode

        ((MyTreeModel)getModel()).addProject(project);
//        SwingUtilities.updateComponentTreeUI(this);
    }

    public List<Project> getProjects() {
        return ((MyTreeModel)getModel()).getProjects();
    }


}
