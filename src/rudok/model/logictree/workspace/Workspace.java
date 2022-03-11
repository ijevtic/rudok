package rudok.model.logictree.workspace;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class Workspace extends RuNodeComposite implements Serializable {

    private File workspaceFile;
    public Workspace(String ime){
        setIme(ime);
        workspaceFile = null;
    }
    @Override
    public void addChild(RuNode child) {
        if(!(child instanceof Project)) return;
        super.addChild(child);
        child.setIme("Project - Grafički editor"+getChildren().size());
    }
    @Override
    public void setChildren(List<RuNode> children) {
        if(children == null) return;
        for(RuNode c: children)
            if(!(c instanceof Project)) return;
        super.setChildren(children);
    }

    @Override
    public void removeChild(RuNode child) {
        if(!(child instanceof Project)) return;
        super.removeChild(child);
    }

    @Override
    public RuNodeComposite getParent() {
        return null;
    }

    @Override
    public String getChildClassName() {
        return "Project";
    }

    public File getWorkspaceFile() {
        return workspaceFile;
    }

    public void setWorkspaceFile(File workspaceFile) {
        this.workspaceFile = workspaceFile;
    }
}
