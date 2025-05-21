package co.edu.uniquindio.poo.notificador.Model;

import java.util.ArrayList;
import java.util.List;

public class Auditor implements NotificationObserver {
    // Lista para guardar los registros de auditoría
    private List<String> registros = new ArrayList<>();

    // Método que se ejecuta cuando llega una notificación
    @Override
    public void update(Notification notificacion) {
        String registro = crearRegistro(notificacion);
        registros.add(registro);
        mostrarEnConsola(registro);
    }

    // Crea un texto con la información importante
    private String crearRegistro(Notification notificacion) {
        return String.format(
                "Auditoría - Usuario: %s | Canal: %s | Estado: %s | Mensaje: %s",
                notificacion.getUser().getContactInfo(),
                notificacion.getChannel(),
                notificacion.getStatus(),
                acortarMensaje(notificacion.getFormattedMessage(), 20)
        );
    }

    // Acorta mensajes muy largos
    private String acortarMensaje(String mensaje, int maxLength) {
        if (mensaje.length() > maxLength) {
            return mensaje.substring(0, maxLength) + "...";
        }
        return mensaje;
    }

    // Muestra el registro en la consola
    private void mostrarEnConsola(String registro) {
        System.out.println(registro);
    }

    // Método para ver todos los registros guardados
    public void mostrarRegistros() {
        System.out.println("\n=== HISTORIAL DE AUDITORÍA ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}