package co.edu.uniquindio.poo.notificador.Model;

/**
 * Clase que representa una notificación en el sistema.
 * Encapsula toda la información necesaria para enviar una notificación a un usuario.
 */

import java.util.ArrayList;
import java.util.List;

public class  Notification {
    private User user;
    private String rawMessage;
    private String formattedMessage;
    private String channel;
    private NotificationStatus status;
    private NotificationStrategy strategy;
    private EventManager eventManager;
    private List<NotificationFilter> filters;

    public Notification(User user, String message, String channel) {
        this.user = user;
        this.rawMessage = message;
        this.channel = channel;
        this.status = NotificationStatus.CREATED;
        this.eventManager = new EventManager();
        this.filters = new ArrayList<>();
        initializeDefaultFilters();
        setStrategyBasedOnChannel();
    }

    private void initializeDefaultFilters() {
        NotificationFilter emptyFilter = new EmptyMessageFilter();
        NotificationFilter blockedFilter = new EmptyMessageFilter();
        emptyFilter.setNext(blockedFilter);
        this.filters.add(emptyFilter);
    }

    private void setStrategyBasedOnChannel() {
        switch (this.channel.toLowerCase()) {
            case "email":
                this.strategy = new EmailNotification();
                break;
            case "sms":
                this.strategy = new SMSNotification();
                break;
            case "push":
                this.strategy = new PushNotification();
                break;
            default:
                throw new IllegalArgumentException("Unsupported channel: " + channel);
        }
    }

    public void send() {
        // Validar primero
        String message = this.rawMessage;
        for (NotificationFilter filter : filters) {
            if (!filter.validate((NotificationStrategy) this, message) ) {
                this.status = NotificationStatus.FAILED_VALIDATION;
                eventManager.notify(this);
                return;
            }
        }

        // Formatear mensaje según el usuario
        this.formattedMessage = user.formatMessage(rawMessage);

        try {
            // Enviar usando la estrategia
            strategy.sendNotification(user, formattedMessage);
            this.status = NotificationStatus.SENT;
        } catch (Exception e) {
            this.status = NotificationStatus.FAILED;
        }

        // Notificar a los observadores
        eventManager.notify(this);
    }

    public void attachObserver(NotificationObserver observer) {
        eventManager.attach(observer);
    }

    public void detachObserver(NotificationObserver observer) {
        eventManager.detach(observer);
    }

    public void addFilter(NotificationFilter filter) {
        this.filters.add(filter);
    }

    // Getters y Setters
    public User getUser() {
        return user;
    }

    public String getRawMessage() {
        return rawMessage;
    }

    public String getFormattedMessage() {
        return formattedMessage;
    }

    public String getChannel() {
        return channel;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    public NotificationStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    // Método para crear el Command asociado
    public NotificationCommand createCommand() {
        return new SendNotificationCommand(this, eventManager);
    }
}