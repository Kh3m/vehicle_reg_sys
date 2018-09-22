package vdlrs.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    Button btnLogin;

    @FXML
    Text txtErrorMsg;

    @FXML
    TextField txtUserName;
    @FXML
    PasswordField pwdPassword;

    private final String password = "ahmedmoore";
    private final String username = "ahmedmoore";


    public void loginHandler() {

        if (!txtUserName.getText().trim().toLowerCase().equals(username) ||
                !pwdPassword.getText().trim().toLowerCase().equals(password)) {
            txtErrorMsg.setStyle("-fx-fill: red;");
            txtErrorMsg.setText("Wrong Username/Password");

            return;
        }
        try {
            Parent splash = FXMLLoader.load(getClass().getResource("../res/layouts/splash.fxml"));
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            Scene scene = new Scene(splash);
            stage.setScene(scene);
        } catch (IOException io) {
            System.out.println("There was an error");
        }

    }
}
