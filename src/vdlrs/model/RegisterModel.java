package vdlrs.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
import java.time.LocalDate;

public class RegisterModel {

    SimpleIntegerProperty  id;
    SimpleStringProperty nameOfApplicant;
    SimpleStringProperty regNo;
    SimpleStringProperty modelNo;
    SimpleStringProperty chassisNo;
    SimpleStringProperty engineNo;
    SimpleStringProperty numberOfCylinder;
    SimpleStringProperty bodyType;
    SimpleDoubleProperty netWeight;
    SimpleStringProperty yom;
    SimpleObjectProperty<Date> dateOfReg;

    public RegisterModel(int id, String nameOfApplicant, String regNo,
                         String modelNo, String chassisNo, String engineNo,
                         String numberOfCylinder, String bodyType, double netWeight,
                         Date dateOfReg, String yom) {

        this.id = new SimpleIntegerProperty(id);
        this.nameOfApplicant = new SimpleStringProperty(nameOfApplicant);
        this.regNo = new SimpleStringProperty(regNo);
        this.modelNo = new SimpleStringProperty(modelNo);
        this.chassisNo = new SimpleStringProperty(chassisNo);
        this.engineNo = new SimpleStringProperty(engineNo);
        this.numberOfCylinder = new SimpleStringProperty(numberOfCylinder);
        this.bodyType = new SimpleStringProperty(bodyType);
        this.netWeight = new SimpleDoubleProperty(netWeight);
        this.dateOfReg = new SimpleObjectProperty<>(dateOfReg);
        this.yom = new SimpleStringProperty(yom);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNameOfApplicant() {
        return nameOfApplicant.get();
    }

    public SimpleStringProperty nameOfApplicantProperty() {
        return nameOfApplicant;
    }

    public void setNameOfApplicant(String nameOfApplicant) {
        this.nameOfApplicant.set(nameOfApplicant);
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

    public String getModelNo() {
        return modelNo.get();
    }

    public SimpleStringProperty modelNoProperty() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo.set(modelNo);
    }

    public String getChassisNo() {
        return chassisNo.get();
    }

    public SimpleStringProperty chassisNoProperty() {
        return chassisNo;
    }

    public void setChassisNo(String chassisNo) {
        this.chassisNo.set(chassisNo);
    }

    public String getEngineNo() {
        return engineNo.get();
    }

    public SimpleStringProperty engineNoProperty() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo.set(engineNo);
    }

    public String getNumberOfCylinder() {
        return numberOfCylinder.get();
    }

    public SimpleStringProperty numberOfCylinderProperty() {
        return numberOfCylinder;
    }

    public void setNumberOfCylinder(String numberOfCylinder) {
        this.numberOfCylinder.set(numberOfCylinder);
    }

    public String getBodyType() {
        return bodyType.get();
    }

    public SimpleStringProperty bodyTypeProperty() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType.set(bodyType);
    }

    public double getNetWeight() {
        return netWeight.get();
    }

    public SimpleDoubleProperty netWeightProperty() {
        return netWeight;
    }

    public void setNetWeight(double netWeight) {
        this.netWeight.set(netWeight);
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

    public String getYom() {
        return yom.get();
    }

    public SimpleStringProperty yomProperty() {
        return yom;
    }

    public void setYom(String yom) {
        this.yom.set(yom);
    }
}
