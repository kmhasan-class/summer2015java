/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class DatabaseDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://172.17.0.119/studentmanagement";
        String DB_USER = "cse2015";
        String DB_PASS = "summer2015";
        
        String id = "2016000000116";
        String name = "John Doe";
        int batch = 43;
        String address = "Bailey Road";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
            String query = "insert into student values('" + id + "', '" + name + "', " + batch + ", '" + address + "');";
            System.out.println(query);
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
