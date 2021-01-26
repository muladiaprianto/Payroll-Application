/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Main.DBConnector;
import java.sql.*;

/**
 *
 * @author User
 */
public class InsertDB {
    static Connection conn;
    static Statement st;
    static String sql;
    public static void main(String[] args) throws SQLException {
        
        conn = new DBConnector().setConnection();
        try
        {
            sql = "INSERT INTO employee VALUES ('E001','Muladi Aprianto', '2000-04-16', '089677279960', 'apriantomuladi@gmail.com',"
                    + "'Male', 'Christian', '2020-01-01', '2020-12-30', 'Contract', 'Kemang Village 2');";
            System.out.println("DATA DISIMPAN");
            
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }
        st = conn.createStatement();
        st.executeUpdate(sql);
    }
    
}
    

