package co.edu.uniquindio.poo.notificador;


import co.edu.uniquindio.poo.notificador.Model.UserManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        UserManager.initialize();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ChatRoom.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}