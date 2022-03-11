package rudok.model.logictree;

import rudok.observer.APublisher;

import java.io.Serializable;

public abstract class RuNode extends APublisher  implements Serializable {

    private String ime;
    private RuNode parent = null;
    private boolean obrisan = false;
    public RuNode(){ }

    public RuNodeComposite getParent() {
        return (RuNodeComposite) parent;
    }

    public void setParent(RuNode parent) {
        this.parent = parent;
        notifySubscribers(new Object());
    }

    public void delete() {
        this.getParent().removeChild(this);
        setParent(null);
        this.obrisan = true;
//        notifySubscribers(this);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
        this.notifySubscribers(new Object());
    }

    public void setImeMessage(String ime, Object message) {
        this.ime = ime;
        this.notifySubscribers(message);
    }

    public boolean isObrisan() {
        return obrisan;
    }

    public void setObrisan(boolean obrisan) {
        this.obrisan = obrisan;
    }
}
