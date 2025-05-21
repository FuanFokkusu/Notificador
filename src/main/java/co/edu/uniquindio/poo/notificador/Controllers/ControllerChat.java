package co.edu.uniquindio.poo.notificador.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class ControllerChat {
    public ComboBox<String> serverComboBox;
    public TextField nicknameField;
    public Button connectButton;
    public Button refreshButton;
    public Label statusLabel;
    public TextField messageInput;
    public Button sendButton;


    public ControllerChat(ComboBox<String> serverComboBox, TextField nicknameField, Button connectButton, Button refreshButton, Label statusLabel, TextField messageInput, Button sendButton) {
        this.serverComboBox = serverComboBox;
        this.nicknameField = nicknameField;
        this.connectButton = connectButton;
        this.refreshButton = refreshButton;
        this.statusLabel = statusLabel;
        this.messageInput = messageInput;
        this.sendButton = sendButton;
    }

    public ComboBox<String> getServerComboBox() {
        return serverComboBox;
    }

    public void setServerComboBox(ComboBox<String> serverComboBox) {
        this.serverComboBox = serverComboBox;
    }

    public TextField getNicknameField() {
        return nicknameField;
    }

    public void setNicknameField(TextField nicknameField) {
        this.nicknameField = nicknameField;
    }

    public Button getConnectButton() {
        return connectButton;
    }

    public void setConnectButton(Button connectButton) {
        this.connectButton = connectButton;
    }

    public Button getRefreshButton() {
        return refreshButton;
    }

    public void setRefreshButton(Button refreshButton) {
        this.refreshButton = refreshButton;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(Label statusLabel) {
        this.statusLabel = statusLabel;
    }

    public TextField getMessageInput() {
        return messageInput;
    }

    public void setMessageInput(TextField messageInput) {
        this.messageInput = messageInput;
    }

    public Button getSendButton() {
        return sendButton;
    }

    public void setSendButton(Button sendButton) {
        this.sendButton = sendButton;
    }

    public void handleConnectButton(ActionEvent actionEvent) {
    }

    public void handleRefreshButton(ActionEvent actionEvent) {
    }

    public void handleSendButton(ActionEvent actionEvent) {
    }
}
