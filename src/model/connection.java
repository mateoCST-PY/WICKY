package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connection {

    private static final String URL = "jdbc:mysql://localhost:3306/wicky_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    //throws help me to manager a possible error in the connection to MySQL
    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
