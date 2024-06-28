module com.example.stick_hero {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires junit;


    opens com.example.stick_hero to javafx.fxml;
    exports com.example.stick_hero;
}