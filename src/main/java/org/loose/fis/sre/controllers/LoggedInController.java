package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class LoogedInController {

    @FXML
    private Button button_logout;

    @FXML
    private Label label_hello;

    public void setUserInformation(String username){
        label_hello.setText("Hello " + username + "!");
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("hello.fxml"));

        Stage window = (Stage) button_logout.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }
}
