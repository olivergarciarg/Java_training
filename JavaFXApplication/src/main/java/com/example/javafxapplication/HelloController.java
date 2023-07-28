package com.example.javafxapplication;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import java.awt.Desktop;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;

public class HelloController {
    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    public void initialize() {
        button4.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick() {
        FileChooser chooser = new FileChooser();
//        chooser.showOpenDialog(gridPane.getScene().getWindow());
//        DirectoryChooser chooser = new DirectoryChooser();
//        File file = chooser.showDialog(gridPane.getScene().getWindow());
        chooser.setTitle("my title");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text","*.txt"));
        File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
        if (file != null) {
            System.out.println(file.getPath());
        } else {
            System.out.println("cancelled");
        }
    }

    @FXML
    public void handleLinkClick() {
        try {
            Desktop.getDesktop().browse(new URI("http://www.yahoo.com"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}