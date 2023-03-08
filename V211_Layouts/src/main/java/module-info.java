module com.example.v211_layouts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.v211_layouts to javafx.fxml;
    exports com.example.v211_layouts;
}