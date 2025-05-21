package co.edu.uniquindio.poo.notificador.Model;

public abstract class NotificationFilter {
    protected NotificationFilter nextFilter;

    public void setNext(NotificationFilter next) {
        this.nextFilter = next;
    }

    public abstract boolean validate(NotificationStrategy notificacion, String message);
}
