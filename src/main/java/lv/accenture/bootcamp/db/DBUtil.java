package lv.accenture.bootcamp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/bootcamp";
    public static final String USER = "root";
    public static final String PASSWORD = "abcd1234";

    public static Connection acquireConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
