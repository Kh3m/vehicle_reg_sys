package vdlrs.controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import vdlrs.data.RegisterDAO;
import vdlrs.model.RegisterModel;


import java.sql.Date;
import java.time.LocalDate;

public class RegisterController {

    @FXML
    TableView<RegisterModel> tbvRegView;
    @FXML
    private TableColumn nameOfApplicant;
    @FXML
    private TableColumn regNo;
    @FXML
    private TableColumn modelNo;
    @FXML
    private TableColumn chassisNo;
    @FXML
    private TableColumn engineNo;
    @FXML
    private TableColumn noOfCylinder;
    @FXML
    private TableColumn dateOfReg;
    @FXML
    private TableColumn bodyType;
    @FXML
    private TableColumn yom;
    @FXML
    private TableColumn netWeight;

    @FXML
    private TextField txtNameOfApplicant;
    @FXML
    private TextField txtRegNo;
    @FXML
    private TextField txtModelNo;
    @FXML
    private TextField txtChassisNo;
    @FXML
    private TextField txtEngineNo;
    @FXML
    private TextField txtNoOfCylinder;
    @FXML
    private TextField txtHorsePower;
    @FXML
    private TextField txtBodyType;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtNetWeight;
    @FXML
    private ChoiceBox chbApplicantSex;
    @FXML
    private TextField txtApplicationAddress;
    @FXML
    private TextField txtStateOfOperation;
    @FXML
    private TextField txtYearOfManufacturer;
    @FXML
    private DatePicker dpDateOfPurchase;
    @FXML
    private DatePicker dpDateOfReg;

    @FXML
    private Button btnRegister;

    private RegisterDAO registerDAO;

    @FXML
    private void initialize () {

        registerDAO = new RegisterDAO();

        tbvRegView.setItems(
                FXCollections.observableArrayList(registerDAO.fetchAllVehicle())
        );

        nameOfApplicant.setCellValueFactory(new PropertyValueFactory<>("nameOfApplicant"));
        regNo.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        modelNo.setCellValueFactory(new PropertyValueFactory<>("modelNo"));
        chassisNo.setCellValueFactory(new PropertyValueFactory<>("chassisNo"));
        engineNo.setCellValueFactory(new PropertyValueFactory<>("engineNo"));
        noOfCylinder.setCellValueFactory(new PropertyValueFactory<>("numberOfCylinder"));
        dateOfReg.setCellValueFactory(new PropertyValueFactory<>("dateOfReg"));
        bodyType.setCellValueFactory(new PropertyValueFactory<>("bodyType"));
        yom.setCellValueFactory(new PropertyValueFactory<>("yom"));
        netWeight.setCellValueFactory(new PropertyValueFactory<>("netWeight"));

        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String nameOfApplicant = txtNameOfApplicant.getText();

                String regNo = txtRegNo.getText();

                String modelNo = txtModelNo.getText();

                String chassisNo = txtChassisNo.getText();

                String engineNo = txtEngineNo.getText();

                int numberOfCylinder = Integer.valueOf(txtNoOfCylinder.getText());

                int horsePower = Integer.valueOf(txtHorsePower.getText());

                String bodyType = txtBodyType.getText();

                double price = Double.valueOf(txtPrice.getText());

                double netWeight = Double.valueOf(txtNetWeight.getText());

                String applicantSex = chbApplicantSex.getValue().toString();

                String applicationAddress = txtApplicationAddress.getText();

                String stateOfOperation = txtStateOfOperation.getText();

                String yearOfManufacturer = txtYearOfManufacturer.getText();

                Date dateOfPurchase = Date.valueOf(dpDateOfPurchase.getValue());

                Date dateOfReg = Date.valueOf(dpDateOfReg.getValue());


                registerDAO.insertVehicle(nameOfApplicant, stateOfOperation, yearOfManufacturer, netWeight, horsePower,
                        price, applicantSex, regNo, dateOfPurchase, modelNo, numberOfCylinder, applicationAddress,
                        bodyType, dateOfReg, chassisNo, engineNo);
            }
        });
    }
}
