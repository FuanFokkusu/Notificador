package co.edu.uniquindio.poo.notificador.Models;

/**
 * Interfaz que define la estrategia para enviar notificaciones (Patrón Strategy).
 * Las implementaciones concretas definen los distintos canales de envío.
 */
public interface NotificationStrategy {
    // ==================== MÉTODO PRINCIPAL ====================
    /**
     * Envía una notificación al usuario por el canal específico
     * @param user Usuario destinatario
     * @param message Mensaje a enviar (ya formateado según el tipo de usuario)
     * @throws NotificationException Si ocurre un error en el envío
     */
    void sendNotification(User user, String message) throws NotificationException;

    // ==================== MÉTODO DEFAULT ====================
    /**
     * Verifica si el canal está disponible
     * @return true si el canal está operativo
     */
    default boolean isChannelAvailable() {
        return true; // Implementación básica para canales que siempre están disponibles
    }
}
