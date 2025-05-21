package co.edu.uniquindio.poo.notificador.Model;

/**
 * Implementación para usuarios clientes regulares
 */
public class ClientUser extends User {
    // ==================== CONSTANTES ====================
    private static final String CLIENT_PREFIX = "Estimado cliente:";
    private static final int MAX_MESSAGE_LENGTH = 120;

    // ==================== CONSTRUCTOR ====================
    public ClientUser(String userId, String name, String contactInfo) {
        super(userId, name, contactInfo);
    }

    // ==================== IMPLEMENTACIÓN PLANTILLA ====================
    @Override
    protected String applyFormatting(String message) {
        // Formato para clientes: mensaje cortado si es muy largo + prefijo formal
        String truncated = message.length() > MAX_MESSAGE_LENGTH
                ? message.substring(0, MAX_MESSAGE_LENGTH - 3) + "..."
                : message;

        return String.format("%s %s", CLIENT_PREFIX, truncated);
    }

    // ==================== MÉTODOS ESPECÍFICOS ====================
    /**
     * Genera un mensaje personalizado con el número de cliente
     */
    public String getPersonalizedMessage(String baseMessage) {
        return String.format("%s (Cliente #%s)", baseMessage, getUserId());
    }
}
