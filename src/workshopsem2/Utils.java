/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshopsem2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Tole
 */
public class Utils {
    private static Connection conn;
    public static final Connection getConnection(){
        try{
            String url = "jdbc:mysql://localhost:3306/laviere_laundry?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String username = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(url, username, pass);
        } catch(Exception e){
            System.err.println("Connection Failed! "+e);
        }
        
        return conn;
    }
    
    public static void execQuery(String query) throws SQLException{
        Connection conn = (Connection) getConnection();
        PreparedStatement stm = conn.prepareStatement(query);
        stm.execute();
    }
}
