package rudok.model.logictree.workspace.factory_method;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;
import rudok.model.logictree.workspace.Prezentacija;

public class PrezentacijaFactory extends RuNodeFactory {
    @Override
    public RuNode napraviCvor(RuNode parent) {
        RuNodeComposite par = (RuNodeComposite) parent;
        String name = par.getChildClassName() + " " + par.returnNextChildIndex();
        return new Prezentacija(name, parent);
    }
}
