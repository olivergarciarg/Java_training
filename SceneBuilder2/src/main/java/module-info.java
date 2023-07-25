module com.example.scenebuilder2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.scenebuilder2 to javafx.fxml;
    exports com.example.scenebuilder2;
}