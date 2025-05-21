package co.edu.uniquindio.poo.notificador.Models;

/**
 * Implementación para usuarios administradores
 */
public class AdminUser extends User {
    // ==================== CONSTANTES ====================
    private static final String ADMIN_PREFIX = "[ADMIN PRIORITY]";

    // ==================== CONSTRUCTOR ====================
    public AdminUser(String userId, String name, String email) {
        super(userId, name, email);
    }

    // ==================== IMPLEMENTACIÓN PLANTILLA ====================
    @Override
    protected String applyFormatting(String message) {
        // Formato específico para admin: mensaje en mayúsculas con prefijo
        return String.format("%s %s", ADMIN_PREFIX, message.toUpperCase());
    }

    // ==================== MÉTODOS ESPECÍFICOS ====================
    public void broadcastAlert(String message) {
        System.out.printf("Broadcasting alert: %s%n", formatMessage(message));
    }
}
