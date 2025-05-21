package co.edu.uniquindio.poo.notificador.Model;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Clase que gestiona la ejecución de comandos de notificación (Patrón Command).
 * Permite encolar, ejecutar y deshacer operaciones de notificación.
 */
public class NotificationInvoker {
    // ==================== ATRIBUTOS ====================
    private final Deque<NotificationCommand> commandStack = new ArrayDeque<>();
    private final Deque<NotificationCommand> redoStack = new ArrayDeque<>();
    private int maxUndoSteps = 10; // Justificación: Limitar memoria usada

    // ==================== MÉTODOS PRINCIPALES ====================
    /**
     * Ejecuta un comando inmediatamente y lo guarda en el historial
     * @param command Comando a ejecutar
     */
    public void executeCommand(NotificationCommand command) {
        command.execute();
        commandStack.push(command);
        redoStack.clear(); // Limpiar redo al ejecutar nueva acción
        ensureMaxUndoSteps();
    }

    /**
     * Deshace el último comando ejecutado
     * @return true si se pudo deshacer
     */
    public boolean undo() {
        if (commandStack.isEmpty()) return false;

        NotificationCommand command = commandStack.pop();
        command.undo();
        redoStack.push(command);
        return true;
    }

    /**
     * Rehace el último comando deshecho
     * @return true si se pudo rehacer
     */
    public boolean redo() {
        if (redoStack.isEmpty()) return false;

        NotificationCommand command = redoStack.pop();
        command.execute();
        commandStack.push(command);
        return true;
    }

    // ==================== GESTIÓN DE COLA ====================
    /**
     * Agrega un comando a la cola para ejecución diferida
     */
    public void queueCommand(NotificationCommand command) {
        commandStack.addLast(command); // Usamos addLast para FIFO
    }

    /**
     * Ejecuta todos los comandos en cola
     * @return Número de comandos ejecutados
     */
    public int executeQueuedCommands() {
        int executed = 0;
        while (!commandStack.isEmpty()) {
            NotificationCommand cmd = commandStack.removeFirst();
            executeCommand(cmd);
            executed++;
        }
        return executed;
    }

    // ==================== VALIDACIÓN ====================
    private void ensureMaxUndoSteps() {
        while (commandStack.size() > maxUndoSteps) {
            commandStack.removeLast(); // Elimina el comando más antiguo
        }
    }

    // ==================== GETTERS & SETTERS ====================
    public void setMaxUndoSteps(int steps) {
        this.maxUndoSteps = Math.max(1, steps); // Mínimo 1 paso
    }

    public int getPendingCommandsCount() {
        return commandStack.size();
    }
}
