package rudok.model.graphictree;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;
import rudok.model.logictree.workspace.Workspace;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class MyTreeNode extends DefaultMutableTreeNode {
    private RuNode node;
    public MyTreeNode(RuNode node){
        this.node = node;
        children = new Vector<>();
    }

    public void napraviMyTreeNodeDecu() {
        if(!(node instanceof RuNodeComposite)) return;
        RuNodeComposite cvor2 = (RuNodeComposite) node;
        for(RuNode dete: cvor2.getChildren()) {
            boolean nasao = false;
            for(TreeNode child: children) {
                if(((MyTreeNode)child).getNode() == dete) {
                    nasao = true;
                    break;
                }
            }
            if(!nasao) {
                MyTreeNode treeNodeCvor = new MyTreeNode(dete);
                this.add(treeNodeCvor);
                //treeNodeCvor.napraviMyTreeNodeDecu();
            }
        }
        List<MutableTreeNode> zaBrisanje = new ArrayList<>();
        for(TreeNode child: children) {
            boolean ima = false;
            for(RuNode dete: cvor2.getChildren())
                if(dete == ((MyTreeNode)child).getNode()) {
                    ima = true;
                    break;
                }
            if(!ima)
                zaBrisanje.add((MutableTreeNode) child);
        }
        for(MutableTreeNode mtn : zaBrisanje)
            this.remove(mtn);
        for(TreeNode node:this.children)
            ((MyTreeNode)node).napraviMyTreeNodeDecu();
    }

    public List<MyTreeNode> findAll(RuNode node){
        List<MyTreeNode> myTreeNodes = new ArrayList<>();

        Enumeration<TreeNode> enumeration = this.breadthFirstEnumeration();

        while (enumeration.hasMoreElements()){
            MyTreeNode curr = (MyTreeNode) enumeration.nextElement();
            if(curr.getNode().equals(node))
                myTreeNodes.add(curr);
        }

        return myTreeNodes;
    }


    @Override
    public boolean isLeaf() {
        if (node instanceof RuNodeComposite)
            return false;
        return true;
    }

    @Override
    public boolean getAllowsChildren() {
        if(node instanceof RuNodeComposite)
            return true;
        return false;
    }

    @Override
    public void insert(MutableTreeNode newChild, int childIndex) {
        if(!isLeaf())
        super.insert(newChild, childIndex);
    }

    @Override
    public void remove(int childIndex) {
        if(!isLeaf())
            super.remove(childIndex);
    }

    @Override
    public TreeNode getChildAt(int index) {
        if(!isLeaf())
            return super.getChildAt(index);
        return null;
    }

    @Override
    public int getChildCount() {
        if(!isLeaf())
            return super.getChildCount();
        return 0;
    }

    @Override
    public boolean isRoot() {
        if(node instanceof Workspace) return true;
        return false;
    }

    public void setParent(MyTreeNode parent) {
        this.parent = parent;
    }

    public RuNode getNode() {
        return node;
    }

    public void setNode(RuNode node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return node.getIme();
    }

    @Override
    public void remove(MutableTreeNode aChild) {
        if(!this.children.contains(aChild)) return;
        super.remove(aChild);
        aChild.setParent(null);
    }
}
