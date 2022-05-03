module Calculator {

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    exports org.javastart to javafx.graphics, javafx.controls, javafx.fxml;
    opens org.javastart to javafx.fxml;
}