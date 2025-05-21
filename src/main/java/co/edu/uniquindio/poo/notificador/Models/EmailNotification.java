package co.edu.uniquindio.poo.notificador.Models;

/**
 * Estrategia concreta para enviar notificaciones por email
 */
public class EmailNotification implements NotificationStrategy {

    @Override
    public void sendNotification(User usuario, String mensaje) {
        String email = usuario.getContactInfo();

        System.out.println("=== ENVIANDO EMAIL ===");
        System.out.println("Para: " + email);
        System.out.println("Asunto: Notificación importante");
        System.out.println("Cuerpo: " + mensaje);
        System.out.println("¡Email enviado a " + email + "!\n");

        // En realidad aquí se conectaría a un servicio de email
    }
}