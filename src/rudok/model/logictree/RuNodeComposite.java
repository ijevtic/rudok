package rudok.model.logictree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RuNodeComposite extends RuNode  implements Serializable {

    private List<RuNode> children = new ArrayList<>();

    public RuNodeComposite(){}

    public RuNode getChildAt(int childIndex) {
        if(childIndex < 0 || childIndex >= children.size()) return null;
        return children.get(childIndex);
    }

    public int getChildCount() {
        if(children == null) return 0;
        return children.size();
    }


    public void addChild(RuNode child){
        if(child == null) return;
        if(this.children == null)
            this.children = new ArrayList<>();
        if(this.children.contains(child))
            return;
        this.children.add(child);
        this.notifySubscribers(new Object());
    }

    public void addChild(RuNode child, int index){
        if(child == null) return;
        if(this.children == null)
            this.children = new ArrayList<>();
        if(this.children.contains(child))
            return;
        this.children.add(index,child);
        this.notifySubscribers(new Object());
    }

    public void removeChild(RuNode child){
        if(child == null || this.children == null || this.children.isEmpty() || !this.children.contains(child)) return;
        child.setParent(null);
        this.children.remove(child);
        this.notifySubscribers(new Object());
    }

    public List<RuNode> getChildren() {
        return this.children;
    }

    public void setChildren(List<RuNode> children) {
        this.children = children;
    }

    public abstract String getChildClassName();

    public int returnNextChildIndex() {
        String s = this.getChildClassName();
        int maxC = 0;
        if(children == null) return 1;
        for(RuNode child: children) {

            String rem = child.getIme().replace(getChildClassName() + " ", "");
            //rem = rem.replaceAll("\\s", ""); //visak razmaka
            int b = vratiBroj(rem);
            if(b > maxC)
                maxC = b;
        }
        return maxC+1;
    }

    private int vratiBroj(String s) {
        try {
            int vr = Integer.parseInt(s);
            return vr;
        }
        catch (Exception e) {
            return 0;
        }
    }
}
