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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Main {
    
    public Main() {
        CourseDaoImplementation courseDao = new CourseDaoImplementation();
        List<Course> courses = courseDao.getAllCourses();
        for (Course course: courses)
            System.out.println(course);
        Course newCourse = new Course("MATH2015", "Linear Algebra", 3.00);
        courseDao.addCourse(newCourse);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }
    
}
