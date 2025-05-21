package co.edu.uniquindio.poo.notificador.Model;

/**
 * Observador concreto que registra notificaciones en un archivo de log
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger implements NotificationObserver {
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void update(Notification notification) {
        String logEntry = String.format(
                "[%s] NOTIFICATION EVENT - Status: %-8s | User: %-20s | Channel: %-6s | Message: %.30s%s",
                LocalDateTime.now().format(DATE_FORMAT),
                notification.getStatus(),
                notification.getUser().getClass().getSimpleName(),
                notification.getChannel(),
                notification.getFormattedMessage(),
                notification.getFormattedMessage().length() > 30 ? "..." : ""
        );

        writeToLog(logEntry);
    }

    private void writeToLog(String message) {
        // Implementación real podría escribir a archivo, consola, sistema de logging, etc.
        System.out.println(message);

        // Ejemplo adicional para escritura en archivo:
        // try (FileWriter fw = new FileWriter("notifications.log", true);
        //      BufferedWriter bw = new BufferedWriter(fw);
        //      PrintWriter out = new PrintWriter(bw)) {
        //     out.println(message);
        // } catch (IOException e) {
        //     System.err.println("Error writing to log file: " + e.getMessage());
        // }
    }

    // Método adicional para propósitos de prueba
    public String getCurrentLogEntry(Notification notification) {
        StringBuilder sb = new StringBuilder();
        sb.append("Notification to ")
                .append(notification.getUser().getClass().getSimpleName())
                .append(" via ")
                .append(notification.getChannel())
                .append(" changed to status: ")
                .append(notification.getStatus());
        return sb.toString();
    }
}
