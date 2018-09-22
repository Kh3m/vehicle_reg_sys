package vdlrs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vdlrs.util.ConnectionUtil;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("res/layouts/sample.fxml"));
        primaryStage.setTitle("Vehicle Driving License Registry System");
        primaryStage.setScene(new Scene(root, 500, 375));
        primaryStage.show();

    }
}
