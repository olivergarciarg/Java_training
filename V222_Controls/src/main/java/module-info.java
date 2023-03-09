module com.example.v222_controls {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.v222_controls to javafx.fxml;
    exports com.example.v222_controls;
}