/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nguye
 */
public class DBConnection {

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // tao doi tuong connect
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://Hieu\\HIEU;databaseName=db_Nghien_Nhua;user=sa;password=123;encrypt=true;trustServerCertificate=true");
        return conn;
    }
}
