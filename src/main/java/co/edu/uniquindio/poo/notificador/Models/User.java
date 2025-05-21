package co.edu.uniquindio.poo.notificador.Models;
    import java.util.Objects;

    /**
     * Clase abstracta que representa un usuario en el sistema (Patrón Template Method).
     * Define la estructura base para todos los tipos de usuarios.
     */
    public abstract class User {
        // ==================== ATRIBUTOS BASE ====================
        private String userId;
        private String name;
        private String contactInfo;
        private boolean isBlocked = false;  // Justificación: Para filtros de notificación

        // ==================== CONSTRUCTOR ====================
        protected User(String userId, String name, String contactInfo) {
            this.userId = Objects.requireNonNull(userId);
            this.name = Objects.requireNonNull(name);
            this.contactInfo = validateContactInfo(contactInfo);
        }

        // ==================== MÉTODO PLANTILLA (TEMPLATE METHOD) ====================
        /**
         * Formatea un mensaje según las reglas del tipo de usuario.
         * @param rawMessage Mensaje sin formatear
         * @return Mensaje formateado
         */
        public final String formatMessage(String rawMessage) {
            String sanitized = sanitizeMessage(rawMessage);
            return applyFormatting(sanitized);  // Paso variable delegado a subclases
        }

        // ==================== PASOS IMPLEMENTADOS ====================
        private String sanitizeMessage(String message) {
            // Paso común: eliminar caracteres peligrosos
            return message.replaceAll("[<>]", "");
        }

        // ==================== PASO ABSTRACTO ====================
        protected abstract String applyFormatting(String message);

        // ==================== MÉTODOS COMUNES ====================
        public String getContactInfo() {
            return contactInfo;
        }

        public void updateContactInfo(String newInfo) {
            this.contactInfo = validateContactInfo(newInfo);
        }

        private String validateContactInfo(String info) {
            if (info == null || info.isBlank()) {
                throw new IllegalArgumentException("Información de contacto inválida");
            }
            return info;
        }

        // ==================== GETTERS & SETTERS ====================
        public String getUserId() {
            return userId;
        }

        public String getName() {
            return name;
        }

        public boolean isBlocked() {
            return isBlocked;
        }

        public void setBlocked(boolean blocked) {
            isBlocked = blocked;
        }

        // ==================== MÉTODO IDENTIFICACIÓN ====================
        @Override
        public String toString() {
            return String.format("User[%s: %s]", userId, name);
        }
    }

