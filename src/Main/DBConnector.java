/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DBConnector {
    private Connection connection = null;

    public Connection setConnection(){ //throws SQLException{
        try{
            String url = "jdbc:sqlserver://localhost:1433;databaseName=payroll";
            String user = "muladi123";
            String pass = "m123456";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("berhasil terkoneksi");
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("error "+e.getMessage());
        }
        return connection;
    }
}
