package vdlrs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.scene.shape.Rectangle;

import vdlrs.MenuFactory;

import java.io.IOException;


public class MainScreenController {
    public ListView<MenuFactory> lvMainMenu;
    @FXML
    private BorderPane root;

    public void initialize () {

        lvMainMenu.setItems(
                FXCollections.observableArrayList(
            new MenuFactory("REGISTER", new Image(getClass().getResourceAsStream("../res/images/ayas.jpg"))),
                    new MenuFactory("LICENSE", new Image(getClass().getResourceAsStream("../res/images/ayas.jpg"))),
                    new MenuFactory("TRANSACT", new Image(getClass().getResourceAsStream("../res/images/ayas.jpg"))),
                    new MenuFactory("REPORT", new Image(getClass().getResourceAsStream("../res/images/ayas.jpg")))
        ));

        lvMainMenu.setCellFactory(new Callback<ListView<MenuFactory>, ListCell<MenuFactory>>() {
            @Override
            public ListCell call(ListView<MenuFactory> param) {
                return new ListCell<MenuFactory>() {
                    @Override
                    public void updateItem(MenuFactory item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty || item == null) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            setGraphic(configureMenu(item));
                            setTextFill(Color.RED);
                        }
                    }
                };
            }
        });


        lvMainMenu.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<MenuFactory>() {
                    @Override
                    public void changed(ObservableValue<? extends MenuFactory> observable, MenuFactory oldValue, MenuFactory newValue) {
                        try {
                            Parent parent = FXMLLoader.load(getClass().getResource("../res/layouts/" + newValue.getTitle().toLowerCase() + ".fxml"));
                            root.setCenter(parent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }
        );
    }

    private HBox configureMenu (MenuFactory menu) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER_LEFT);
//        hBox.setPadding(new Insets(10));
        hBox.setSpacing(20);
        Text text = new Text(menu.getTitle());
        ImageView image = new ImageView(menu.getIcon());
        image.setFitHeight(42);
        image.setFitWidth(42);
        image.setPreserveRatio(true);
        Rectangle clip = new Rectangle(image.getFitWidth(), image.getFitHeight());
        clip.setArcHeight(image.getFitHeight());
        clip.setArcWidth(image.getFitWidth());
        image.setClip(clip);

        hBox.getChildren().addAll(image, text);

        return hBox;
    }
}
