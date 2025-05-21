package co.edu.uniquindio.poo.notificador.Models;

public class PushNotification implements NotificationStrategy {

    @Override
    public void sendNotification(User usuario, String mensaje) {
        // Simulamos el envío de notificación push
        String dispositivoId = usuario.getContactInfo();

        System.out.println("=== ENVIANDO PUSH ===");
        System.out.println("Dispositivo: " + dispositivoId);
        System.out.println("Notificación: " + mensaje);
        System.out.println("Push entregado al dispositivo\n");

        // En una app real aquí se conectaría con Firebase o similar
    }
}
