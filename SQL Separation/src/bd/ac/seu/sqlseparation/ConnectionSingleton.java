/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.sqlseparation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ConnectionSingleton {
    private static ConnectionSingleton singleton = new ConnectionSingleton();
    private static Connection connection;
    
    private ConnectionSingleton() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://172.17.0.44/studentdb", "cse4047", "summer2015");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }

    public static String readSQL(String filename, String blockname) {
        String query = "";
        try {
            RandomAccessFile input = new RandomAccessFile(filename, "r");
            String line;
            
            while ((line = input.readLine()) != null && !line.startsWith(blockname))
                if (line.startsWith("--"))
                    continue;
            
            if (line == null) return null;
            
            while ((line = input.readLine()) != null && !line.equals("}"))
                if (line.startsWith("--"))
                    continue;
                else query += line;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return query.trim();
    }
    
}
