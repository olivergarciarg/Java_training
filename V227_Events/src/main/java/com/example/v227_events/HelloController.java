package com.example.v227_events;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField nameField;

    @FXML
    private Button helloButton;

    @FXML
    private Button byeButton;

    @FXML
    private CheckBox ourCheckBox;

    @FXML
    private Label ourLabel;

    @FXML
    protected void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if(e.getSource().equals(helloButton)){
            System.out.println("Hello, " + nameField.getText());
        } else if(e.getSource().equals(byeButton)){
            System.out.println("Bye, " + nameField.getText());
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread()? "UI Thread":"Background Thread";
                    System.out.println("going to sleep " + s);
                    Thread.sleep(3000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            ourLabel.setText("we did something");
                            String s = Platform.isFxApplicationThread()? "UI Thread":"Background Thread";
                            System.out.println("updating label " + s);
                        }
                    });
                } catch (InterruptedException event) {
                    //
                }
            }
        };

        new Thread(task).start();
        if (ourCheckBox.isSelected()) {
            nameField.clear();
        }
    }

    @FXML
    public void handleKeyRelease() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() | text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    @FXML
    public void handleChange() {
        System.out.println("checkbox is " + (ourCheckBox.isSelected()? "checked":"not checked"));
    }
}