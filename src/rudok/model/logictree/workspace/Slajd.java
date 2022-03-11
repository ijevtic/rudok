package rudok.model.logictree.workspace;

import rudok.model.Slot;
import rudok.model.logictree.RuNode;
import rudok.observer.ISubscriber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Slajd extends RuNode implements ISubscriber, Serializable {
    private int redniBroj;
    private List<Slot> listaSlotova;
    public Slajd(int redniBroj, RuNode parent){
        listaSlotova = new ArrayList<>();
        this.redniBroj = redniBroj;
        if(parent instanceof Prezentacija)
            setParent(parent);
        setIme("Slajd "+ redniBroj);
    }

    public void addChild(Slot child){
        listaSlotova.add(child);
        child.addSubscriber(this);
        notifySubscribers(new Object());
    }

    public void removeChild(Slot child){
        if(!listaSlotova.contains(child)) return;
        listaSlotova.remove(child);
        child.removeSubscriber(this);
        notifySubscribers(new Object());
    }

    public int getChildCount(){
        return listaSlotova.size();
    }

    public List<Slot> getChildren(){
        return listaSlotova;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
        notifySubscribers(new Object());
    }

    @Override
    public void update(Object notification) {
        notifySubscribers(new Object());
    }
}
