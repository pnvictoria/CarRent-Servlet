package database;
import utils.ReadPropertiesFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ReadPropertiesFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final Logger LOG = LoggerFactory.getLogger(DataBaseConnection.class);

    private static Connection connection = null;
    public static String DB_DRIVER;
    public static String DB_URL;
    public static String DB_NAME;
    public static String DB_USERNAME;
    public static String DB_PASSWORD;

    static {
        ReadPropertiesFile propertyPage = new ReadPropertiesFile();
        DB_DRIVER = propertyPage.getDbProperty("DB_DRIVER");
        DB_URL = propertyPage.getDbProperty("DB_URL");
        DB_NAME = propertyPage.getDbProperty("DB_NAME");
        DB_USERNAME = propertyPage.getDbProperty("DB_USERNAME");
        DB_PASSWORD = propertyPage.getDbProperty("dbPassword");
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL + DB_NAME, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection initialize() {
        return connection;
    }
}
