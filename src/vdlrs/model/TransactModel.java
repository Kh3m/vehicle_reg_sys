package vdlrs.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class TransactModel {
    SimpleStringProperty oldOwnersName;
    SimpleStringProperty newOwnersName;
    SimpleObjectProperty<Date> dateOfReg;

    SimpleStringProperty oldOwnersAddress;
    SimpleStringProperty newOwnersAddress;
    SimpleObjectProperty<Date> dateOfChange;

    SimpleStringProperty regNo;
    SimpleStringProperty receiptNo;

   public  TransactModel( String oldOwnersName, String newOwnersName, Date dateOfReg,
                          String oldOwnersAddress, String newOwnersAddress, Date dateOfChange,
                          String regNo, String receiptNo) {

       this.oldOwnersName = new SimpleStringProperty(oldOwnersName);
       this.newOwnersName = new SimpleStringProperty(newOwnersName);
       this.dateOfReg = new SimpleObjectProperty<>(dateOfReg);

       this.oldOwnersAddress = new SimpleStringProperty(oldOwnersAddress);
       this.newOwnersAddress = new SimpleStringProperty(newOwnersAddress);
       this.dateOfChange = new SimpleObjectProperty<>(dateOfChange);

       this.regNo = new SimpleStringProperty(regNo);
       this.receiptNo = new SimpleStringProperty(receiptNo);


   }

    public String getOldOwnersName() {
        return oldOwnersName.get();
    }

    public SimpleStringProperty oldOwnersNameProperty() {
        return oldOwnersName;
    }

    public void setOldOwnersName(String oldOwnersName) {
        this.oldOwnersName.set(oldOwnersName);
    }

    public String getNewOwnersName() {
        return newOwnersName.get();
    }

    public SimpleStringProperty newOwnersNameProperty() {
        return newOwnersName;
    }

    public void setNewOwnersName(String newOwnersName) {
        this.newOwnersName.set(newOwnersName);
    }

    public Date getDateOfReg() {
        return dateOfReg.get();
    }

    public SimpleObjectProperty<Date> dateOfRegProperty() {
        return dateOfReg;
    }

    public void setDateOfReg(Date dateOfReg) {
        this.dateOfReg.set(dateOfReg);
    }

    public String getOldOwnersAddress() {
        return oldOwnersAddress.get();
    }

    public SimpleStringProperty oldOwnersAddressProperty() {
        return oldOwnersAddress;
    }

    public void setOldOwnersAddress(String oldOwnersAddress) {
        this.oldOwnersAddress.set(oldOwnersAddress);
    }

    public String getNewOwnersAddress() {
        return newOwnersAddress.get();
    }

    public SimpleStringProperty newOwnersAddressProperty() {
        return newOwnersAddress;
    }

    public void setNewOwnersAddress(String newOwnersAddress) {
        this.newOwnersAddress.set(newOwnersAddress);
    }

    public Date getDateOfChange() {
        return dateOfChange.get();
    }

    public SimpleObjectProperty<Date> dateOfChangeProperty() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange.set(dateOfChange);
    }

    public String getRegNo() {
        return regNo.get();
    }

    public SimpleStringProperty regNoProperty() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo.set(regNo);
    }

    public String getReceiptNo() {
        return receiptNo.get();
    }

    public SimpleStringProperty receiptNoProperty() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo.set(receiptNo);
    }
}
