package rudok.observer;

public interface IPublisher {
    void addSubscriber(ISubscriber s);
    void removeSubscriber(ISubscriber s);
    void notifySubscribers(Object notification);
}
