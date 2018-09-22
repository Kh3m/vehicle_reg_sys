package vdlrs.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil instance;

    public Connection getConnection () {
        Connection connection = null;
        try(
            FileReader props = new FileReader("C:\\Users\\Kh3m\\IdeaProjects\\VehicleRegSys\\src\\vdlrs\\res\\properties\\db.properties");
        ) {
            Properties properties = new Properties();
            properties.load(props);
            String databaseUrl = properties.getProperty("dbURL");
            String password = properties.getProperty("password");
            String user = properties.getProperty("user");
            connection = DriverManager.getConnection(databaseUrl, user, password);

            System.out.println("Connection Successful");
        } catch (SQLException | IOException exp) {
            System.out.println(exp.getMessage());
        }

        return connection;
    }

    public static ConnectionUtil getInstance() {
        if (instance == null) {
            instance = new ConnectionUtil();
        }
        return instance;
    }
}
