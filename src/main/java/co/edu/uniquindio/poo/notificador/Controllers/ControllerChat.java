package co.edu.uniquindio.poo.notificador.Controllers;

import co.edu.uniquindio.poo.notificador.Model.Alert;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ControllerChat {
    public ComboBox<String> serverComboBox;
    public TextField nicknameField;
    public Button connectButton;
    public Button refreshButton;
    public Label statusLabel;
    public TextField messageInput;
    public Button sendButton;
    public TextArea chatArea;


    public ControllerChat(ComboBox<String> serverComboBox, TextField nicknameField, Button connectButton, Button refreshButton, Label statusLabel, TextField messageInput, Button sendButton, TextArea textArea) {
        this.serverComboBox = serverComboBox;
        this.nicknameField = nicknameField;
        this.connectButton = connectButton;
        this.refreshButton = refreshButton;
        this.statusLabel = statusLabel;
        this.messageInput = messageInput;
        this.sendButton = sendButton;
        this.chatArea = textArea;
    }


    public void handleConnectButton(ActionEvent actionEvent) {
        switch (serverComboBox.getSelectionModel().getSelectedItem()) {
            case "Servidor 1":
                statusLabel.setText("Conectado a Servidor 1");
                break;
            case "Servidor 2":
                statusLabel.setText("Conectado a Servidor 2");
                break;
            case "Servidor 3":
                statusLabel.setText("Conectado a Servidor 3");
                break;
            case "Servidor 4":
                statusLabel.setText("Conectado a Servidor 4");
                break;
            case "Servidor 5":
                statusLabel.setText("Conectado a Servidor 5");
                break;
            default:
                Alert.showAlert("Error", "No se ha seleccionado un servidor");
        }
    }

    public void handleRefreshButton(ActionEvent actionEvent) {
    }

    public void handleSendButton(ActionEvent actionEvent) {
    }

    public void inicializarCombobox(){

        serverComboBox.getItems().add("Servidor 1");
        serverComboBox.getItems().add("Servidor 2");
        serverComboBox.getItems().add("Servidor 3");
        serverComboBox.getItems().add("Servidor 4");
        serverComboBox.getItems().add("Servidor 5");
    }
}
