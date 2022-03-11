package rudok.command;

import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;
import rudok.model.logictree.workspace.Slajd;
import rudok.model.logictree.workspace.factory_method.RuNodeFactory;
import rudok.model.logictree.workspace.factory_method.SimpleFactory;
import rudok.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class NewNodeCommand implements AbstractCommand{

    private MyTreeNode parent;
    private MyTreeNode newNode;

    private List<MyTreeNode> parents;
    private List<MyTreeNode> newNodes;


    public NewNodeCommand(MyTreeNode parent) {
        this.parent = parent;

        parents = new ArrayList<>();
        newNodes = new ArrayList<>();
    }

    @Override
    public void doCommand() {

        if(newNode == null) {

            RuNodeFactory fabrika = SimpleFactory.getFactory(parent.getNode());
            RuNode noviCvor = fabrika.vratiCvor(parent.getNode());
            ((RuNodeComposite)parent.getNode()).addChild(noviCvor);
            newNode = new MyTreeNode(noviCvor);


        }
        else{
            newNode.getNode().setParent( parent.getNode());
            ((RuNodeComposite) parent.getNode()).addChild(newNode.getNode());
        }
        if(newNode.getNode() instanceof Slajd) {
            if(parents.size()==0) {
                MyTreeNode workspace = (MainFrame.getMainFrame().getMyTreeModel().getRoot());
                List<MyTreeNode> presentations = workspace.findAll( parent.getNode());
                for (MyTreeNode p : presentations) {
                    parents.add(p);
                    newNodes.add(new MyTreeNode(newNode.getNode()));
                }
            }
            for(int i=0;i<parents.size();i++)
                parents.get(i).add(newNodes.get(i));
        }
        else
            parent.add(newNode);

    }

    @Override
    public void undoCommand() {

        newNode.getNode().getParent().removeChild(newNode.getNode());

        if(newNode.getNode() instanceof Slajd){
            for(int i=0;i<newNodes.size();i++)
                parents.get(i).remove(newNodes.get(i));
        }
        else
            parent.remove(newNode);

    }
}
