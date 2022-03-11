package rudok.model.logictree.workspace.factory_method;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.workspace.Prezentacija;
import rudok.model.logictree.workspace.Project;
import rudok.model.logictree.workspace.Workspace;

public class SimpleFactory {

    public static RuNodeFactory getFactory(RuNode parent){
        if(parent instanceof Workspace)
            return new ProjectFactory();
        if(parent instanceof Project)
            return new PrezentacijaFactory();
        if(parent instanceof Prezentacija)
            return new SlajdFactory();
        return null;
    }

}
