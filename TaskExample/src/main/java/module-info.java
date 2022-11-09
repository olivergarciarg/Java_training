module com.example.taskexample {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taskexample to javafx.fxml;
    exports com.example.taskexample;
}