/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple.database.demo;

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
public class SimpleDatabaseDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String DB_URL = "jdbc:mysql://172.17.0.119/storedb";
        String DB_USER = "cse2015";
        String DB_PASS = "summer2015";

        Product p = new Product(666, "Walton Primo NX", "Phone", 18000.00);
        
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            Statement statement = connection.createStatement();
//insert into Product values(114, 'Test', 'Whatever', 0.0);            
            String query = "insert into Product values(" + p.getId() + ", "
                    + "'" + p.getName() + "', " 
                    + "'" + p.getCategory() + "', "
                    + p.getUnitPrice() + ")";
            System.out.println(query);
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(SimpleDatabaseDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
