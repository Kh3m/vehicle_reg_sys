package vdlrs.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vdlrs.data.VehicleRegContract.RegisterEntry;
import vdlrs.model.RegisterModel;
import vdlrs.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;

public class RegisterDAO {
    private static final String ALL_REG_COLUMN = RegisterEntry.COLUMN_NAME_OF_APPLICANT + ", " +
            RegisterEntry.COLUMN_STATE_OF_OPERATION + ", " +
            RegisterEntry.COLUMN_YEAR_OF_MANUFACTURER + ", " +
            RegisterEntry.COLUMN_NET_WEIGHT + ", " +
            RegisterEntry.COLUMN_HORSE_POWER + ", " +
            RegisterEntry.COLUMN_PRICE + ", " +
            RegisterEntry.COLUMN_APPLICANT_SEX + ", " +
            RegisterEntry.COLUMN_REG_NO + ", " +
            RegisterEntry.COLUMN_DATE_OF_PURCHASE + ", " +
            RegisterEntry.COLUMN_MODEL_NO + ", " +
            RegisterEntry.COLUMN_NUMBER_OF_CYLINDER + ", " +
            RegisterEntry.COLUMN_APPLICANT_ADDRESS + ", " +
            RegisterEntry.COLUMN_BODY_TYPE + ", " +
            RegisterEntry.COLUMN_DATE_OF_REG + ", " +
            RegisterEntry.COLUMN_CHASSIS_NO + ", " +
            RegisterEntry.COLUMN_ENGINE_NO;

    private static final String DISPLAY_COLUMNS = RegisterEntry._ID + ", " +
            RegisterEntry.COLUMN_NAME_OF_APPLICANT + ", " +
            RegisterEntry.COLUMN_YEAR_OF_MANUFACTURER + ", " +
            RegisterEntry.COLUMN_NET_WEIGHT + ", " +
            RegisterEntry.COLUMN_REG_NO + ", " +
            RegisterEntry.COLUMN_DATE_OF_PURCHASE + ", " +
            RegisterEntry.COLUMN_MODEL_NO + ", " +
            RegisterEntry.COLUMN_NUMBER_OF_CYLINDER + ", " +
            RegisterEntry.COLUMN_BODY_TYPE + ", " +
            RegisterEntry.COLUMN_DATE_OF_REG + ", " +
            RegisterEntry.COLUMN_CHASSIS_NO + ", " +
            RegisterEntry.COLUMN_ENGINE_NO;

    public void insertVehicle (
            String nameOfApplicant, String stateOfOperation, String yearOfManufacturer, double netWeight,
            int horsePower, double price, String applicantSex, String regNo, Date dateOfPurchase,
            String modelNo, int numberOfCylinder, String applicantAddress, String bodyType, Date dateOfReg,
            String chassisNumber, String engineNumber
    ) {
        final String SQL_INSERT_REG = "INSERT INTO " + RegisterEntry.TABLE_NAME + " " +
            "( " +
                ALL_REG_COLUMN
                +
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";

        System.out.println(SQL_INSERT_REG);
        try (
                Connection  con = ConnectionUtil.getInstance().getConnection();
                PreparedStatement pstm = con.prepareStatement(SQL_INSERT_REG)
            ){


                pstm.setString(1, nameOfApplicant);
                pstm.setString(2, stateOfOperation);
                pstm.setString(3, yearOfManufacturer);
                pstm.setDouble(4, netWeight);
                pstm.setInt(5, horsePower);
                pstm.setDouble(6, price);
                pstm.setString(7, applicantSex);
                pstm.setString(8, regNo);
                pstm.setDate(9, dateOfPurchase);
                pstm.setString(10, modelNo);
                pstm.setInt(11, numberOfCylinder);
                pstm.setString(12, applicantAddress);
                pstm.setString(13, bodyType);
                pstm.setDate(14, dateOfReg);
                pstm.setString(15, chassisNumber);
                pstm.setString(16, engineNumber);

                pstm.executeUpdate();

        } catch (SQLException exp) {
            System.out.println(exp);
        }

    }

    public ObservableList<RegisterModel> fetchAllVehicle () {
        ObservableList<RegisterModel> allVehicle = FXCollections.observableArrayList();

        final String SQL_FIND_ALL_VEHICLE = "SELECT " + DISPLAY_COLUMNS +
                " FROM " + RegisterEntry.TABLE_NAME;

        try (
                Connection con = ConnectionUtil.getInstance().getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_VEHICLE)
            ){

            while (rs.next()) {
                allVehicle.add(
                        new RegisterModel(
                                rs.getInt(RegisterEntry._ID),
                                rs.getString(RegisterEntry.COLUMN_NAME_OF_APPLICANT),
                                rs.getString(RegisterEntry.COLUMN_REG_NO),
                                rs.getString(RegisterEntry.COLUMN_MODEL_NO),
                                rs.getString(RegisterEntry.COLUMN_CHASSIS_NO),
                                rs.getString(RegisterEntry.COLUMN_ENGINE_NO),
                                rs.getString(RegisterEntry.COLUMN_NUMBER_OF_CYLINDER),
                                rs.getString(RegisterEntry.COLUMN_BODY_TYPE),
                                rs.getDouble(RegisterEntry.COLUMN_NET_WEIGHT),
                                rs.getDate(RegisterEntry.COLUMN_DATE_OF_REG),
                                rs.getString(RegisterEntry.COLUMN_YEAR_OF_MANUFACTURER)
                        )
                );
            }

        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }

        return allVehicle;
    }

}
