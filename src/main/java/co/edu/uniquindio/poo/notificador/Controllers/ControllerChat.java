package co.edu.uniquindio.poo.notificador.Controllers;

import co.edu.uniquindio.poo.notificador.Alert;
import co.edu.uniquindio.poo.notificador.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ControllerChat {
    public ComboBox<Object> serverComboBox;
    public TextField nicknameField;
    public Button connectButton;
    public Button refreshButton;
    public Label statusLabel;
    public TextField messageInput;
    public Button sendButton;
    public TextArea chatArea;
    public TextField MensajeField;
    public Button EnviarNotificaciónButton;


    public ControllerChat(ComboBox<Object> serverComboBox, TextField nicknameField, Button connectButton, Button refreshButton, Label statusLabel, TextField messageInput, Button sendButton, TextArea textArea) {
        this.serverComboBox = serverComboBox;
        this.nicknameField = nicknameField;
        this.connectButton = connectButton;
        this.refreshButton = refreshButton;
        this.statusLabel = statusLabel;
        this.messageInput = messageInput;
        this.sendButton = sendButton;
        this.chatArea = textArea;
    }


    public void handleRefreshButton(ActionEvent actionEvent) {
        serverComboBox.getItems().clear();
        inicializarCombobox();
        Alert.showAlert("Refrescar", "Lista de servidores actualizada");
    }

    public void handleSendButton(ActionEvent actionEvent) {
        String tipoDeNotificacion = serverComboBox.getSelectionModel().getSelectedItem().toString();
        String message = messageInput.getText();
        message = "Este mensaje sera enviado por: " + tipoDeNotificacion + " " + message;
        if (message.isEmpty()) {
            Alert.showAlert("Error", "No se puede enviar un mensaje vacío");
        } else {
            switch (tipoDeNotificacion) {
                case "email":
                    for (User user : UserManager.getInstance().getUsers()) {
                        EmailNotification emailNotification = new EmailNotification();
                        emailNotification.sendNotification(user, message);
                        chatArea.appendText(MensajeField.getText() + ": Estimado " + user.getName() + " El dia de hoy tiene usted una notificación que dice lo siguiente " + message + "\n");
                        messageInput.clear();
                    }
                    break;
                case "sms":

                for (User user : UserManager.getInstance().getUsers()) {
                    SMSNotification smsNotification = new SMSNotification();
                    smsNotification.sendNotification(user, message);
                    chatArea.appendText(MensajeField.getText() + ": Estimado " + user.getName() + " El dia de hoy tiene usted una notificación que dice lo siguiente " + message + "\n");
                    messageInput.clear();
                }
                break;
                case "push":
                    for (User user : UserManager.getInstance().getUsers()) {
                        PushNotification pushNotification = new PushNotification();
                    pushNotification.sendNotification(user, message);
                        chatArea.appendText(MensajeField.getText() + ": Estimado " + user.getName() + " El dia de hoy tiene usted una notificación que dice lo siguiente " + message + "\n");
                        messageInput.clear();
                    }
                    break;
            }
        }
    }

    public void EnviarNotificación(ActionEvent actionEvent) {

        String header = MensajeField.getText();

    }

    public void inicializarCombobox() {


        ObservableList<Object> observableList = FXCollections.observableArrayList("push", "email", "sms");
        serverComboBox.setItems(observableList);

    }


}



