package vdlrs.data;

public class VehicleRegContract {

    public static class RegisterEntry {
        public static final String TABLE_NAME = "register";

        public static final String _ID = "reg_id";


        public static final String COLUMN_NAME_OF_APPLICANT = "name_of_applicant";
        public static final String COLUMN_STATE_OF_OPERATION = "state_of_operation";
        public static final String COLUMN_YEAR_OF_MANUFACTURER = "year_of_manufacturer";
        public static final String COLUMN_NET_WEIGHT  = "net_weight";
        public static final String COLUMN_HORSE_POWER  = "horse_power";
        public static final String COLUMN_PRICE  = "price";
        public static final String COLUMN_APPLICANT_SEX  = "applicant_sex";
        public static final String COLUMN_REG_NO  = "reg_no";
        public static final String COLUMN_DATE_OF_PURCHASE  = "date_of_purchase";
        public static final String COLUMN_MODEL_NO  = "model_number";
        public static final String COLUMN_NUMBER_OF_CYLINDER  = "number_of_cylinder";
        public static final String COLUMN_APPLICANT_ADDRESS  = "applicant_address";
        public static final String COLUMN_BODY_TYPE  = "body_type";
        public static final String COLUMN_DATE_OF_REG  = "date_of_reg";
        public static final String COLUMN_CHASSIS_NO  = "chassis_number";
        public static final String COLUMN_ENGINE_NO  = "engine_number";
    }

    public static class LicenseEntry {
        public static final String TABLE_NAME = "license";

        public static final String _ID = "_id";


        public static final String COLUMN_REG_NO = "reg_number";
        public static final String COLUMN_EXPIRING_DATE = "exp_date";
        public static final String COLUMN_APPLICANT_NAME = "applicant_name";
        public static final String COLUMN_DATE_ISSUED  = "date_issued";
    }

    public static class TransactEntry {
        public static final String TABLE_NAME = "transact";

        public static final String _ID = "_id";

        public static final String COLUMN_OLD_OWNERS_NAME = "old_owners_name";
        public static final String COLUMN_NEW_OWNERS_NAME = "new_owners_name";
        public static final String COLUMN_DATE_OF_REG  = "date_of_reg";
        public static final String COLUMN_OLD_OWNERS_ADDRESS = "old_owners_address";
        public static final String COLUMN_NEW_OWNERS_ADDRESS = "new_owners_address";
        public static final String COLUMN_DATE_OF_CHANGE = "date_of_change";
        public static final String COLUMN_REG_NO = "registration_no";
        public static final String COLUMN_RECEIPT_NO = "receipt_no";

    }
}
