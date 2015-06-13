/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.hibernate;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
    private TextField addressField;
    @FXML
    private TextField cgpaField;
    private SessionFactory factory;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        factory = new Configuration().configure().buildSessionFactory();
    }    

    @FXML
    private void handleSaveAction(ActionEvent event) {
        String id = idField.getText();
        String name = nameField.getText();
        String address = addressField.getText();
        double cgpa = Double.parseDouble(cgpaField.getText());
        
        Student student = new Student(id, name, address, cgpa);
        System.out.println(student);
        Session session = null;
        try {
            session = factory.openSession();
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

    @FXML
    private void handlePrintAction(ActionEvent event) {
        Session session = factory.openSession();
        List<Student> list = session.createCriteria(Student.class).list();
        for (Student student: list)
            System.out.println(student);
        session.close();
    }
    
}
