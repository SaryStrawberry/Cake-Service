module com.example.cakeservice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.cakeservice to javafx.fxml;
    exports com.cakeservice;
}