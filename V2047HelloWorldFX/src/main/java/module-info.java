module com.example.v2047helloworldfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.v2047helloworldfx to javafx.fxml;
    exports com.example.v2047helloworldfx;
}