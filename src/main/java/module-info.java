module com.example.cakeservice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.cakeservice to javafx.fxml;
    exports com.example.cakeservice;
}