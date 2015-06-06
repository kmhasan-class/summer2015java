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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Main {
    public static String readSQL(String filename, String blockname) {
        String query = "";
        try {
            RandomAccessFile input = new RandomAccessFile(filename, "r");
            String line;
            while ((line = input.readLine()) != null && !line.startsWith(blockname))
                System.out.println(line);
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
    
    public Main() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/studentdb", "cse4047", "summer2015");
            PreparedStatement selectStatement = connection.prepareStatement(readSQL("course.sql", "LIST_COURSES"));
            PreparedStatement insertStatement = connection.prepareStatement(readSQL("course.sql", "ADD_COURSE"));
            ResultSet result = selectStatement.executeQuery();
            while (result.next())
                System.out.println(result.getString("code") + ": " + result.getString("title") + " " + result.getString("credits"));
            insertStatement.setString(1, "CSE2015");
            insertStatement.setString(2, "Programming Language II (Java)");
            insertStatement.setDouble(3, 3.00);
            insertStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}
