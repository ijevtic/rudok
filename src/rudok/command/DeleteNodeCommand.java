package rudok.command;


import rudok.model.graphictree.MyTreeNode;
import rudok.model.logictree.RuNodeComposite;
import rudok.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class DeleteNodeCommand implements AbstractCommand{

    private MyTreeNode node;
    private MyTreeNode parent;
    private RuNodeComposite otac;
    private int index;


    private List<MyTreeNode> parents;
    private List<MyTreeNode> nodes;
    private List<Integer> indexes;

    public DeleteNodeCommand(MyTreeNode node) {

        this.node = node;

        parents = new ArrayList<>();
        nodes = new ArrayList<>();
        indexes = new ArrayList<>();

    }

    @Override
    public void doCommand() {


        otac = node.getNode().getParent();
        index = otac.getChildren().indexOf(node.getNode());

        MyTreeNode workspace = (MyTreeNode) (MainFrame.getMainFrame().getMyTreeModel().getRoot());
//        workspace.napraviMyTreeNodeDecu();

        if(parents.size()==0){
            parents = workspace.findAll(otac);
            for(MyTreeNode p:parents){
                for(int i=0;i<p.getChildCount();i++)
                    if(((MyTreeNode)p.getChildAt(i)).getNode() == node.getNode())
                        nodes.add((MyTreeNode)p.getChildAt(i));
            }
        }

        List<MyTreeNode> presentations = workspace.findAll(node.getNode());
        for(MyTreeNode p:presentations){
            if(!parents.contains((MyTreeNode) p.getParent())){
                parents.add((MyTreeNode) p.getParent());
                nodes.add(p);
            }
        }

        for(int i=0;i<parents.size();i++)
            parents.get(i).remove(nodes.get(i));

        node.getNode().delete();
        parent = (MyTreeNode) node.getParent();
        parent.remove(node);
    }

    @Override
    public void undoCommand() {
        node.getNode().setObrisan(false);

//        for(int i=0;i<parents.size();i++)
//            parents.get(i).insert(nodes.get(i),index);
        parent.insert(node, index);
        node.getNode().setParent(otac);
        otac.addChild(node.getNode(), index);
    }
}
