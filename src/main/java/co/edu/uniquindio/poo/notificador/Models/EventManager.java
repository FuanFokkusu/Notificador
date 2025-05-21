package co.edu.uniquindio.poo.notificador.Models;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<NotificationObserver> observers;

    public EventManager() {
        this.observers = new ArrayList<>();
    }

    public void attach(NotificationObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void detach(NotificationObserver observer) {
        observers.remove(observer);
    }

    public void notify(Notification notification) {
        for (NotificationObserver observer : new ArrayList<>(observers)) {
            observer.update(notification);
        }
    }

    public int countObservers() {
        return observers.size();
    }

    public void clearObservers() {
        observers.clear();
    }
}
