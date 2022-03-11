package rudok.observer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class APublisher implements IPublisher, Serializable {

    transient List<ISubscriber> subscribers;
    public APublisher() { }

    @Override
    public void notifySubscribers(Object notification) {
        if(subscribers == null) return;
        for(ISubscriber s: subscribers) {
            s.update(notification);
        }
    }

    public List<ISubscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<ISubscriber> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public void removeSubscriber(ISubscriber s){
        if(subscribers == null || subscribers.isEmpty() || !subscribers.contains(s)) return;
        subscribers.remove(s);
    }
    @Override
    public void addSubscriber(ISubscriber s) {
        if(subscribers == null) subscribers = new ArrayList<>();
        subscribers.add(s);
    }
}
