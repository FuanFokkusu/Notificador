package co.edu.uniquindio.poo.notificador.Model;

/**
 * Interfaz que define el contrato para los observadores de notificaciones (Patrón Observer).
 * Las clases concretas (Logger, Auditor, etc.) deben implementar update().
 */
public interface NotificationObserver {
    void update(Notification notification);
}
