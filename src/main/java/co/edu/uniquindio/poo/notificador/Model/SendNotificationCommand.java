package co.edu.uniquindio.poo.notificador.Model;

import java.util.ArrayList;
import java.util.List;

public class SendNotificationCommand implements NotificationCommand {
    private Notification notification;
    private List<NotificationFilter> filters;
    private NotificationStatus       previousStatus;
    private EventManager             eventManager;

    public SendNotificationCommand(Notification notification, EventManager eventManager) {
        this.notification = notification;
        this.eventManager = eventManager;
        this.filters = new ArrayList<>();
        initializeFilters(); // Cadena de responsabilidad
    }

    private void initializeFilters() {
        // Configurar la cadena de filtros (Chain of Responsibility)
        NotificationFilter emptyMessageFilter = new EmptyMessageFilter();
        NotificationFilter blockedUserFilter = new EmptyMessageFilter();

        emptyMessageFilter.setNext(blockedUserFilter);
        this.filters.add(emptyMessageFilter);
    }

    @Override
    public void execute() {
        // Guardar estado para posible undo
        previousStatus = notification.getStatus();

        // Validar con la cadena de filtros
        for (NotificationFilter filter : filters) {
            if (!filter.validate((NotificationStrategy) notification, notification.getRawMessage())) {
                notification.setStatus(NotificationStatus.FAILED_VALIDATION);
                eventManager.notify(notification);
                return;
            }
        }

        // Enviar la notificación usando la estrategia
        try {
            notification.send();
            notification.setStatus(NotificationStatus.SENT);
        } catch (Exception e) {
            notification.setStatus(NotificationStatus.FAILED);
        }

        // Notificar a los observadores
        eventManager.notify(notification);
    }

    @Override
    public void undo() {
        if (previousStatus != null) {
            notification.setStatus(previousStatus);
            eventManager.notify(notification);
        }
    }

    // Métodos adicionales para gestión de filtros
    public void addFilter(NotificationFilter filter) {
        this.filters.add(filter);
    }

    public void clearFilters() {
        this.filters.clear();
    }

    // Getters
    public Notification getNotification() {
        return notification;
    }

    public List<NotificationFilter> getFilters() {
        return new ArrayList<>(filters); // Devolver copia para encapsulamiento
    }
}