package rudok.command;


import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.model.logictree.workspace.Project;
import rudok.view.MainFrame;

public class ShareNodeCommand implements AbstractCommand{

    private Prezentacija prezentacija;
    private Project projekat;
    private MyTreeNode parentNode;
    private MyTreeNode newNode;

    public ShareNodeCommand(Prezentacija prezentacija, Project projekat) {
        this.prezentacija = prezentacija;
        this.projekat = projekat;
    }

    @Override
    public void doCommand() {

        MyTreeNode workspace=(MyTreeNode)(MainFrame.getMainFrame().getMyTreeModel().getRoot());
        for(int i=0;i<workspace.getChildCount();i++) {
            MyTreeNode project = ((MyTreeNode) workspace.getChildAt(i));
            if (project.getNode() == projekat) {
                parentNode = project;
                projekat.getSharedPresentations().add(prezentacija);
                workspace.napraviMyTreeNodeDecu();

            }
        }

    }

    @Override
    public void undoCommand() {
//        parentNode.remove(newNode);
        projekat.getSharedPresentations().remove(prezentacija);
    }
}
