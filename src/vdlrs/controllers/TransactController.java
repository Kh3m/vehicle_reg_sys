package vdlrs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import vdlrs.data.TransactDao;
import vdlrs.model.TransactModel;

import java.sql.Date;

public class TransactController {

    @FXML
    private TableView<TransactModel> tbvTransact;
    @FXML
    private TableColumn<String, TransactModel> tcOldOwnersName;
    @FXML
    private TableColumn<String, TransactModel> tcNewOwnersName;
    @FXML
    private TableColumn<Date, TransactModel> tcDateOfReg;
    @FXML
    private TableColumn<String, TransactModel> tcOldOwnersAddress;
    @FXML
    private TableColumn<String, TransactModel> tcNewOwnersAddress;
    @FXML
    private TableColumn<Date, TransactModel> tcDateOfChange;
    @FXML
    private TableColumn<String, TransactModel> tcRegNo;
    @FXML
    private TableColumn<String, TransactModel> tcReceiptNo;

    @FXML
    private TextField txtOldOwnersName;
    @FXML
    private TextField txtNewOwnersName;
    @FXML
    private DatePicker dpDateOfReg;
    @FXML
    private TextField txtOldOwnersAddress;
    @FXML
    private TextField txtNewwnersAddress;
    @FXML
    private DatePicker dpDateOfChange;
    @FXML
    private TextField txtRegNo;
    @FXML
    private TextField txtReceiptNo;

    private TransactDao transactDao;

    @FXML
    private void initialize () {
        transactDao = new TransactDao();

        tbvTransact.setItems(
                transactDao.fetchAllTransact()
        );

        tcDateOfChange.setCellValueFactory(
                new PropertyValueFactory<>("dateOfChange")
        );

        tcDateOfReg.setCellValueFactory(
                new PropertyValueFactory<>("dateOfReg")
        );

        tcNewOwnersAddress.setCellValueFactory(
                new PropertyValueFactory<>("newOwnersAddress")
        );

        tcNewOwnersName.setCellValueFactory(
                new PropertyValueFactory<>("newOwnersName")
        );

        tcOldOwnersAddress.setCellValueFactory(
                new PropertyValueFactory<>("oldOwnersAddress")
        );

        tcOldOwnersName.setCellValueFactory(
                new PropertyValueFactory<>("oldOwnersName")
        );

        tcRegNo.setCellValueFactory(
                new PropertyValueFactory<>("regNo")
        );

        tcReceiptNo.setCellValueFactory(
                new PropertyValueFactory<>("receiptNo")
        );
    }

    @FXML
    private void transactRegHandler () {
        String oldOwnersName = txtOldOwnersName.getText();
        String newOwnersName = txtNewOwnersName.getText();
        Date dateOfReg = Date.valueOf(dpDateOfReg.getValue());
        String oldOwnersAddress = txtOldOwnersAddress.getText();
        String newOwnersAddress = txtNewwnersAddress.getText();
        Date dateOfChange = Date.valueOf(dpDateOfChange.getValue());
        String regNo = txtRegNo.getText();
        String receiptNo = txtReceiptNo.getText();

        transactDao.insertTransact(oldOwnersName, newOwnersName, dateOfReg, oldOwnersAddress,
                newOwnersAddress, dateOfChange, regNo,  receiptNo);
    }
}
