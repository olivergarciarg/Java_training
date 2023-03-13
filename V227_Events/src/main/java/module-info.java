module com.example.v227_events {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.v227_events to javafx.fxml;
    exports com.example.v227_events;
}