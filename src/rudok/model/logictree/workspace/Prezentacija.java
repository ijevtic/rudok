package rudok.model.logictree.workspace;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;

import java.io.Serializable;
import java.util.List;

public class Prezentacija extends RuNodeComposite implements Serializable {
    private String autor;
    private String background = "";

    public Prezentacija(String ime, String autor, RuNode parent){
        this.autor = autor;
        setIme(ime);
        setParent(parent);
    }
    public Prezentacija(String ime, RuNode parent) {
        this.autor = "autor";
        setIme(ime);
        if(parent instanceof Project)
            setParent(parent);
    }

    @Override
    public void addChild(RuNode child) {
        if(!(child instanceof Slajd)) return;
        super.addChild(child);
    }

    @Override
    public void setIme(String ime) {
        this.setImeMessage(ime,this);
    }

    @Override
    public void setChildren(List<RuNode> children) {
        if(children == null) return;
        for(RuNode c: children)
            if(!(c instanceof Slajd)) return;
        super.setChildren(children);
    }
    @Override
    public void removeChild(RuNode child) {
        if(!(child instanceof Slajd)) return;
        super.removeChild(child);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
        notifySubscribers(this);
    }



    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
        notifySubscribers(new Object());
    }

    @Override
    public String getChildClassName() {
        return "Slajd";
    }
}
