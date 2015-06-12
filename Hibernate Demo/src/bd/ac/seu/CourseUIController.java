/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author kmhasan
 */
public class CourseUIController implements Initializable {
    @FXML
    private TextField codeField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField creditsField;
    
    private Session session;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        session = SessionFactorySingleton.getSessionFactory().openSession();
    }    

    @FXML
    private void handleAddCourseAction(ActionEvent event) {
        String code = codeField.getText();
        String title = titleField.getText();
        double credits = Double.parseDouble(creditsField.getText());
        Course course = new Course(code, title, credits);
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
        List<Course> courses = session.createCriteria(Course.class).list();
        for (Course course: courses)
            System.out.println(course);
    }
    
}
