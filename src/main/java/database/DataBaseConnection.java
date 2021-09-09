package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    public static Connection initialize() {
        String dbDriver = "org.postgresql.Driver";
        String dbURL = "jdbc:postgresql://localhost:5432/";
        String dbName = "postgres";
        String dbUsername = "postgres";
        String dbPassword = "123qwe";

        Connection con = null;
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }
}
