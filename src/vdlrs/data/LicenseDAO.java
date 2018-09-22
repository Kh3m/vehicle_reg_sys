package vdlrs.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vdlrs.model.LicenseModel;
import vdlrs.model.RegisterModel;
import vdlrs.util.ConnectionUtil;
import vdlrs.data.VehicleRegContract.LicenseEntry;

import java.sql.*;


public class LicenseDAO {

    private static final String ALL_LICENSE_COLUMN = LicenseEntry.COLUMN_REG_NO + ", " +
            LicenseEntry.COLUMN_EXPIRING_DATE + ", " +
            LicenseEntry.COLUMN_APPLICANT_NAME + ", " +
            LicenseEntry.COLUMN_DATE_ISSUED;

    public void insertLicense ( String regNo, Date expiringDate, String applicantName, Date dateIssued ) {
        final String SQL_INSERT_REG = "INSERT INTO " + LicenseEntry.TABLE_NAME +
                "( " + ALL_LICENSE_COLUMN + " ) VALUES (?, ?, ?, ?); ";

        try (
                Connection con = ConnectionUtil.getInstance().getConnection();
                PreparedStatement pstm = con.prepareStatement(SQL_INSERT_REG)
        ){
            pstm.setString(1, regNo);
            pstm.setDate(2, expiringDate);
            pstm.setString(3, applicantName);
            pstm.setDate(4, dateIssued);

            pstm.executeUpdate();

        } catch (SQLException exp) {
            System.out.println(exp);
        }

    }

    public ObservableList<LicenseModel> fetchAllLicense () {
        ObservableList<LicenseModel> allLicense = FXCollections.observableArrayList();

        final String SQL_FIND_ALL_LICENSE = "SELECT " + ALL_LICENSE_COLUMN +
                " FROM " + LicenseEntry.TABLE_NAME;

        try (
                Connection con = ConnectionUtil.getInstance().getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_LICENSE)
        ){

            while (rs.next()) {
                allLicense.add(
                        new LicenseModel(
                                rs.getString(LicenseEntry.COLUMN_REG_NO),
                                rs.getString(LicenseEntry.COLUMN_APPLICANT_NAME),
                                rs.getDate(LicenseEntry.COLUMN_DATE_ISSUED),
                                rs.getDate(LicenseEntry.COLUMN_EXPIRING_DATE)
                        )
                );
            }

        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }

        return allLicense;
    }
}
