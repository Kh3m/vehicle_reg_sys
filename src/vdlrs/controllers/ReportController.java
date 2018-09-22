package vdlrs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ReportController {

    public VBox vbRoot;
    private GridPane pane;
    private Text title;
    private Label regNo;
    private Label from;
    private Label to;

    @FXML
    private void initialize () {
        pane = new GridPane();
        title = new Text();
        regNo = new Label();

        from = new Label();
        pane.add(from, 0, 1);

        to = new Label();
        pane.add(to, 2, 1);

        pane.add(title, 0, 0, 4, 1);
        pane.add(regNo, 0, 2);
    }

    @FXML
    private void reportHandler(ActionEvent event) {
        if (((Button)event.getTarget()).getText().toLowerCase().equals("registration report")) {
            vbRoot.getChildren().removeAll(pane);
            vbRoot.getChildren().add(1, customizeReportUI("Search by Reg Date"));
            regNo.setText("Reg No.");
            from.setText("From: ");
            to.setText("To: ");
        }

        if (((Button)event.getTarget()).getText().toLowerCase().equals("license report")) {
            vbRoot.getChildren().removeAll(pane);
            vbRoot.getChildren().add(1, customizeReportUI("Search by License Date"));
            regNo.setText("License No.");
            from.setText("From: ");
            to.setText("To: ");
        }

        if (((Button)event.getTarget()).getText().toLowerCase().equals("transact report")) {
            vbRoot.getChildren().removeAll(pane);
            vbRoot.getChildren().add(1, customizeReportUI("Search by Transact Date"));
            regNo.setText("Transact No.");
            from.setText("From: ");
            to.setText("To: ");
        }
    }

    private GridPane customizeReportUI (String titleName) {
//        vbRoot.getChildren().add(1, pane);
        pane.setVgap(20);
        pane.setHgap(20);
        pane.setAlignment(Pos.TOP_CENTER);
        pane.setPadding(new Insets(10));

        title.setText(titleName);


        DatePicker datePickerFrom = new DatePicker();
        pane.add(datePickerFrom, 1, 1);

        DatePicker datePickerTo = new DatePicker();
        pane.add(datePickerTo, 3, 1);

        TextField txtRegNo = new TextField();
        pane.add(txtRegNo, 1, 2);
        Button btnSearch = new Button("Search");
        pane.add(btnSearch, 2, 2);

        return  pane;
    }

}
