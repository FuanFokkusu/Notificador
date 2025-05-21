package co.edu.uniquindio.poo.notificador.Model;

public class Alert {
    private String title;
    private String message;
    private static String type;

    public Alert(String title, String message, String type) {
        this.title = title;
        this.message = message;
        Alert.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        Alert.type = type;
    }

    public static void showAlert(String title, String message) {

        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(type.equals("error") ? javafx.scene.control.Alert.AlertType.ERROR : javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText("Notificador");
        alert.setContentText(message);
        alert.setResizable(false);
        alert.showAndWait();

    }
}
