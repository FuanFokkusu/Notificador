package co.edu.uniquindio.poo.notificador.Model;

import java.util.List;

public class BlockedUserFilter extends NotificationFilter {

    @Override
    public boolean validate(NotificationStrategy notificacion, String message) {
        // Lista simulada de usuarios bloqueados
        List<String> usuariosBloqueados = List.of("spammer@mail.com", "usuario123");

        for (String usuario2 : usuariosBloqueados) {
            String usuario = UserManager.getInstance().getUsers().toString();
            if (usuario.equals(usuario2)) {
                System.out.println("❌ Usuario bloqueado detectado: " + usuario);
                return false; // No pasa el filtro
            }

        }
        return false;
    }
}