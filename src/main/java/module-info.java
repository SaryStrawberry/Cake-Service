module com.cakeservice {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    exports com.cakeservice.model;
    opens com.cakeservice.model to javafx.fxml;
    exports com.cakeservice.service;
    opens com.cakeservice.service to javafx.fxml;
    exports com.cakeservice.db;
    opens com.cakeservice.db to javafx.fxml;
    exports com.cakeservice.util;
    opens com.cakeservice.util to javafx.fxml;
    exports com.cakeservice.app;
    opens com.cakeservice.app to javafx.fxml;
}