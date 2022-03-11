package rudok.model.logictree.workspace.factory_method;

import rudok.model.logictree.RuNode;

public abstract class RuNodeFactory {

    public RuNode vratiCvor(RuNode parent){
        return napraviCvor(parent);
    }
    abstract RuNode napraviCvor(RuNode parent);
}
