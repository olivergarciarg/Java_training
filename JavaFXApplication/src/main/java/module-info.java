module com.example.javafxapplication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
//    requires javafx.media;
//    requires javafx.web;


    opens com.example.javafxapplication to javafx.fxml;
    exports com.example.javafxapplication;
}