package rudok.model.logictree.workspace;

import rudok.model.logictree.RuNode;
import rudok.model.logictree.RuNodeComposite;
import rudok.observer.ISubscriber;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project extends RuNodeComposite implements ISubscriber, Serializable {

    private File projectFile;
    private boolean changed;
    List<Prezentacija> sharedPresentations = new ArrayList<>();

    public Project(String ime,RuNode parent){
        setIme(ime);
        this.changed = true;
        this.projectFile = null;
        if(parent instanceof Workspace)
            this.setParent(parent);
    }

    public List<Prezentacija> getSharedPresentations() {
        return sharedPresentations;
    }

    public void setSharedPresentations(List<Prezentacija> sharedPresentations) {
        this.sharedPresentations = sharedPresentations;
    }

    @Override
    public void addChild(RuNode child) {
        if(!(child instanceof Prezentacija)) return;
        super.addChild(child);
        child.addSubscriber(this);
    }
    @Override
    public void setChildren(List<RuNode> children) {
        if(children == null) return;
        for(RuNode c: children)
            if(!(c instanceof Prezentacija)) return;
        super.setChildren(children);
    }
    @Override
    public void removeChild(RuNode child) {
        if(!(child instanceof Prezentacija)) return;
        super.removeChild(child);
        child.removeSubscriber(this);
    }

    @Override
    public String getChildClassName() {
        return "Prezentacija";
    }

    @Override
    public void update(Object notification) {
        if(notification instanceof Prezentacija)
            this.notifySubscribers(new Object());
    }

    public File getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(File projectFile) {
        this.projectFile = projectFile;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public void makePresentations() {

    }

    @Override
    public List<RuNode> getChildren() {
        List<RuNode> children2 = super.getChildren();
        if(children2 == null) children2 = new ArrayList<>();
        children2.addAll(sharedPresentations);
        return children2;
    }
}
