package co.edu.uniquindio.poo.notificador.Model;

public class SMSNotification implements NotificationStrategy {

    @Override
    public void sendNotification(User usuario, String mensaje) {
        // Simulamos el envío de un SMS
        String telefono = usuario.getContactInfo();

        System.out.println("=== ENVIANDO SMS ===");
        System.out.println("Para: " + telefono);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("¡SMS enviado con éxito!\n");

        // En una app real aquí iría el código para enviar el SMS real
    }
}
