module co.edu.uniquindio.poo.notificador {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires

    opens co.edu.uniquindio.poo.notificador to javafx.fxml;
    requires static lombok;
    opens co.edu.uniquindio.poo.notificador.controladores to javafx.fxml;
    opens co.edu.uniquindio.poo.notificador.modelos to javafx.fxml;

    exports co.edu.uniquindio.poo.notificador;
}