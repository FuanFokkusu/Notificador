package co.edu.uniquindio.poo.notificador.Model;

import java.util.List;

public class BlockedUserFilter extends NotificationFilter {

    @Override
    public boolean validate(Notification notificacion) {
        // Lista simulada de usuarios bloqueados
        List<String> usuariosBloqueados = List.of("spammer@mail.com", "usuario123");

        String usuario = notificacion.getUser().getContactInfo();

        if (usuariosBloqueados.contains(usuario)) {
            System.out.println("❌ Usuario bloqueado detectado: " + usuario);
            return false; // No pasa el filtro
        }

        return true; // Pasa el filtro
    }
}
