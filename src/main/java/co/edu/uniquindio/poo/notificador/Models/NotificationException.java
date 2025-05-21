package co.edu.uniquindio.poo.notificador.Models;

/**
 * Excepción para errores específicos de notificaciones
 */
public class NotificationException extends Exception {
    public NotificationException(String message) {
        super(message);
    }

    public NotificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
