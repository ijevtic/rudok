package rudok.model.logictree.workspace.factory_method;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;
import rudok.model.logictree.workspace.Slajd;

public class SlajdFactory extends RuNodeFactory {
    @Override
    public RuNode napraviCvor(RuNode parent) {
        RuNodeComposite par = (RuNodeComposite)parent;
        return new Slajd(par.returnNextChildIndex(), par);
    }
}

