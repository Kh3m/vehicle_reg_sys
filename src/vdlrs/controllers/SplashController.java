package vdlrs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashController {
    @FXML
    Button btnProceed;

    public void proceedHandler() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("../res/layouts/mainscreen.fxml"));
            Stage stage = (Stage) btnProceed.getScene().getWindow();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
