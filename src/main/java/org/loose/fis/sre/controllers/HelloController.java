package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class LogInController {
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;
    @FXML
    private Button button_sign_up;
    @FXML
    private Button button_log_in;



    @FXML
    public void initialize() {
        role.getItems().addAll("Client/Anticariat", "Seller");
    }

    @FXML
    private void handleSignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sign-up.fxml"));

        Stage window = (Stage) button_sign_up.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }

    @FXML
    public void handleLogin(ActionEvent event) throws IOException  {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            //registrationMessage.setText("Account created successfully!");
        } catch (UsernameAlreadyExistsException e) {
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("logged-in.fxml"));

            Stage window = (Stage) button_log_in.getScene().getWindow();
            window.setScene(new Scene(root,600,400));
        }
    }
}
