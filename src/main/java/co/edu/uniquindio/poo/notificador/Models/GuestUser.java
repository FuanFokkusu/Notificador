package co.edu.uniquindio.poo.notificador.Models;

/**
 * Implementación para usuarios invitados (sin cuenta registrada)
 */
public class GuestUser extends User {
    // ==================== CONSTANTES ====================
    private static final String GUEST_PREFIX = "Notificación para invitado:";
    private static final String DEFAULT_CONTACT = "no-contact";

    // ==================== CONSTRUCTOR ====================
    public GuestUser(String tempId) {
        super("GUEST_" + tempId, "Invitado", DEFAULT_CONTACT);
    }

    // ==================== IMPLEMENTACIÓN PLANTILLA ====================
    @Override
    protected String applyFormatting(String message) {
        // Formato simple para invitados
        return String.format("%s %s", GUEST_PREFIX, message);
    }

    // ==================== SOBREESCRITURAS ====================
    @Override
    public void updateContactInfo(String newInfo) {
        // Los invitados no pueden actualizar su info de contacto
        throw new UnsupportedOperationException("Los usuarios invitados no pueden actualizar su contacto");
    }

    @Override
    public String toString() {
        return "GuestUser{" + getUserId() + "}";
    }
}
