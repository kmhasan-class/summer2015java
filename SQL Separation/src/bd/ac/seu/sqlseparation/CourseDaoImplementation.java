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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class CourseDaoImplementation implements CourseDao {
    private PreparedStatement insertStatement;
    private PreparedStatement selectStatement;

    public CourseDaoImplementation() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            selectStatement = connection.prepareStatement(ConnectionSingleton.readSQL("course.sql", "LIST_COURSES"));
            insertStatement = connection.prepareStatement(ConnectionSingleton.readSQL("course.sql", "ADD_COURSE"));
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
    }

    @Override
    public List<Course> getAllCourses() {
        List<Course> list = new ArrayList<>();
        try {
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String title = resultSet.getString("title");
                double credits = resultSet.getDouble("credits");
                Course course = new Course(code, title, credits);
                list.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void addCourse(Course course) {
        try {
            insertStatement.setString(1, course.getCode());
            insertStatement.setString(2, course.getTitle());
            insertStatement.setDouble(3, course.getCredits());
            insertStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDaoImplementation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
