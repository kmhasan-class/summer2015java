/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.sqlseparation;

import java.util.List;

/**
 *
 * @author kmhasan
 */
public interface CourseDao {
    public List<Course> getAllCourses();
    public void addCourse(Course course);
}
