/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.hibernate;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.ZoneId;
/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private DatePicker dobPicker;
    @FXML
    private TextField houseField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField creditsField;
    @FXML
    private ComboBox<Student> studentBox;
    @FXML
    private ComboBox<Course> courseBox;
    
    private ObservableList<Student> students;
    private ObservableList<Course> courses;
    @FXML
    private TextField searchIdField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        students = FXCollections.observableArrayList();
        courses = FXCollections.observableArrayList();
        Session session = SessionFactorySingleton.getSessionFactory().openSession();
        List<Student> s = session.createCriteria(Student.class).list();
        students.addAll(s);
        List<Course> c = session.createCriteria(Course.class).list();
        courses.addAll(c);
        session.close();
        studentBox.setItems(students);
        courseBox.setItems(courses);
    }    

    @FXML
    private void handleStudentSaveAction(ActionEvent event) {
        String id = idField.getText();
        String name = nameField.getText();
        Date dob = Date.from(dobPicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());        String house = houseField.getText();
        String street = streetField.getText();
        String city = cityField.getText();
        Student student = new Student(id, name, dob, new Address(house, street, city));
        
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = SessionFactorySingleton.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            students.add(student);
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }
    }

    @FXML
    private void handleCourseSaveAction(ActionEvent event) {
        String code = codeField.getText();
        String title = titleField.getText();
        double credits = Double.parseDouble(creditsField.getText());
        
        Course course = new Course(code, title, credits);
        
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = SessionFactorySingleton.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            courses.add(course);
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }        
    }

    @FXML
    private void handleRegisterAction(ActionEvent event) {
        Session session = null;
        Transaction transaction = null;
        
        try {
            session = SessionFactorySingleton.getSessionFactory().openSession();
            Student student = studentBox.getSelectionModel().getSelectedItem();
            Course course = courseBox.getSelectionModel().getSelectedItem();
            student.addCourse(course);
            course.addStudent(student);
            transaction = session.beginTransaction();
            session.update(student);
            session.update(course);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        } finally {
            session.close();
        }        

    }

    @FXML
    private void handleSearchStudentAction(ActionEvent event) {
        String id = searchIdField.getText();
        Session session = SessionFactorySingleton.getSessionFactory().openSession();
        Student student = (Student) session.get(Student.class, id);
        System.out.println(student);
        idField.setText(student.getId());
        nameField.setText(student.getName());
    }
    
}
