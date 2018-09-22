package vdlrs.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vdlrs.model.LicenseModel;
import vdlrs.model.TransactModel;
import vdlrs.util.ConnectionUtil;
import vdlrs.data.VehicleRegContract.TransactEntry;

import java.sql.*;

public class TransactDao {

    private static final String ALL_TRANSACT_COLUMN = TransactEntry.COLUMN_OLD_OWNERS_NAME + ", " +
            TransactEntry.COLUMN_NEW_OWNERS_NAME + ", " +
            TransactEntry.COLUMN_DATE_OF_REG + ", " +
            TransactEntry.COLUMN_OLD_OWNERS_ADDRESS  + ", " +
            TransactEntry.COLUMN_NEW_OWNERS_ADDRESS + ", " +
            TransactEntry.COLUMN_DATE_OF_CHANGE + ", " +
            TransactEntry.COLUMN_REG_NO + ", " +
            TransactEntry.COLUMN_RECEIPT_NO;

    public void insertTransact (
            String oldOwnersName, String newOwnersName, Date dateOfReg, String oldOwnersAddress,
            String newOwnersAddress, Date dateOfChange, String regNo, String receiptNo
    ) {
        final String SQL_INSERT_REG = "INSERT INTO " + TransactEntry.TABLE_NAME + " " +
                "( " + ALL_TRANSACT_COLUMN + " ) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try (
                Connection con = ConnectionUtil.getInstance().getConnection();
                PreparedStatement pstm = con.prepareStatement(SQL_INSERT_REG)
        ){
            pstm.setString(1, oldOwnersName);
            pstm.setString(2, newOwnersName);
            pstm.setDate(3, dateOfReg);
            pstm.setString(4, newOwnersAddress);
            pstm.setString(5, oldOwnersAddress);
            pstm.setDate(6, dateOfChange);
            pstm.setString(7, regNo);
            pstm.setString(8, receiptNo);

            pstm.executeUpdate();

        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }

    }

    public ObservableList<TransactModel> fetchAllTransact () {
        ObservableList<TransactModel> allTransact = FXCollections.observableArrayList();

        final String SQL_FIND_ALL_TRANSACT = "SELECT " + ALL_TRANSACT_COLUMN +
                " FROM " + TransactEntry.TABLE_NAME;

        try (
                Connection con = ConnectionUtil.getInstance().getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_TRANSACT)
        ){

            while (rs.next()) {
                allTransact.add(
                        new TransactModel(
                                rs.getString(TransactEntry.COLUMN_OLD_OWNERS_NAME),
                                rs.getString(TransactEntry.COLUMN_NEW_OWNERS_NAME),
                                rs.getDate(TransactEntry.COLUMN_DATE_OF_REG),
                                rs.getString(TransactEntry.COLUMN_OLD_OWNERS_ADDRESS),
                                rs.getString(TransactEntry.COLUMN_NEW_OWNERS_ADDRESS),
                                rs.getDate(TransactEntry.COLUMN_DATE_OF_CHANGE),
                                rs.getString(TransactEntry.COLUMN_REG_NO),
                                rs.getString(TransactEntry.COLUMN_RECEIPT_NO)
                        )
                );
            }

        } catch (SQLException exp) {
            System.out.println(exp.getMessage());
        }

        return allTransact;
    }
}
