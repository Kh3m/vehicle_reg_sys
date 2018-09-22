package vdlrs.controllers;


import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.scene.control.cell.PropertyValueFactory;
import vdlrs.data.LicenseDAO;
import vdlrs.model.LicenseModel;


import java.sql.Date;
import java.time.LocalDate;

public class LicenseController {

    @FXML
    private TableColumn<String, LicenseModel> tcRegNo;
    @FXML
    private TableColumn<String, LicenseModel> tcApplicantName;
    @FXML
    private TableColumn<Date, LicenseModel> tcDateIssued;
    @FXML
    private TableColumn<Date, LicenseModel> tcExpiringDate;

    @FXML
    TableView<LicenseModel> tbvLicense;

    @FXML
    private TextField txtRegNo;
    @FXML
    private TextField txtApplicantName;
    @FXML
    private DatePicker dpDateIssued;
    @FXML
    private DatePicker dpExpiringDate;

    private LicenseDAO licenseDAO;

    public void initialize () {
        licenseDAO = new LicenseDAO();
        tbvLicense.setItems(
                FXCollections.observableArrayList(
                        licenseDAO.fetchAllLicense()
                )
        );

        tcRegNo.setCellValueFactory(
                new PropertyValueFactory<>("regNo")
        );

        tcApplicantName.setCellValueFactory(
                new PropertyValueFactory<>("applicantName")
        );

        tcDateIssued.setCellValueFactory(
                new PropertyValueFactory<>("dateIssued")
        );

        tcExpiringDate.setCellValueFactory(
                new PropertyValueFactory<>("expDate")
        );

    }

    public void licenseRegHandler() {


        String regNo = txtRegNo.getText();
        String applicantName = txtApplicantName.getText();
        Date dateIssued = Date.valueOf(dpDateIssued.getValue());
        Date expiringDate = Date.valueOf(dpExpiringDate.getValue());

        licenseDAO.insertLicense(regNo, expiringDate, applicantName, dateIssued);
    }
}
