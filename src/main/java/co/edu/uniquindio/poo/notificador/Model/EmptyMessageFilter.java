package co.edu.uniquindio.poo.notificador.Model;

import java.util.List;

public class EmptyMessageFilter extends NotificationFilter {

    @Override
    public boolean validate(NotificationStrategy notificacion, String message) {


        User user = UserManager.getInstance().getUsers().isEmpty() ? null : UserManager.getInstance().getUsers().get(0); // Obtener el primer usuario de la lista
        // Lista simulada de usuarios bloqueados
        if (message.isEmpty()) {
            System.out.println("❌ Mensaje vacío detectado para el usuario: " + user.getName());
            return false; // No pasa el filtro
        } else {
            System.out.println("✅ Mensaje no vacío para el usuario: " + user.getName());
            try {
                notificacion.sendNotification(user, message);
            } catch (NotificationException e) {
                throw new RuntimeException(e);
            }
        }





        return true;
    }
}
