package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connection {

    private static final String URL = "jdbc:mysql://localhost:3306/wicky_db";
    private static final String user = "root";
    private static final String password = "";

    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL, user, password);
    }
}
