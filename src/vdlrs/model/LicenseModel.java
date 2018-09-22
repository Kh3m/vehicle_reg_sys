package vdlrs.model;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;

public class LicenseModel {
    private SimpleStringProperty regNo;
    private SimpleStringProperty applicantName;
    private SimpleObjectProperty<Date> dateIssued;
    private SimpleObjectProperty<Date> expDate;

    public LicenseModel (String regNo, String applicantName, Date dateIssued, Date expDate) {
        this.regNo = new SimpleStringProperty(regNo);
        this.applicantName = new SimpleStringProperty(applicantName);
        this.dateIssued = new SimpleObjectProperty<>(dateIssued);
        this.expDate = new SimpleObjectProperty<>(expDate);
    }

    public String getRegNo () {
        return this.regNo.get();
    }

    public void setRegNo(String regNo) {
        this.regNo.set(regNo);
    }

    public StringProperty regNoProperty () {
        return regNo;
    }

    public String getApplicantName() {
        return applicantName.get();
    }

    public SimpleStringProperty applicantNameProperty() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName.set(applicantName);
    }

    public Date getDateIssued() {
        return dateIssued.get();
    }

    public SimpleObjectProperty<Date> dateIssuedProperty() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued.set(dateIssued);
    }

    public Date getExpDate() {
        return expDate.get();
    }

    public SimpleObjectProperty<Date> expDateProperty() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate.set(expDate);
    }
}
