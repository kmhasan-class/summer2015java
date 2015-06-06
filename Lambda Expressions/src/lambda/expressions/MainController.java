/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambda.expressions;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class MainController implements Initializable {
    final String DB_URL = "jdbc:mysql://172.17.0.44/studentdb";
    final String DB_USER = "cse4047";
    final String DB_PASS = "summer2015";
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private ComboBox<Sex> sexComboBox;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private ListView<Student> studentListView;
    private ObservableList<Student> students;
    private FilteredList<Student> filteredStudents;
    
    private Connection connection;
    private Statement statement;
    @FXML
    private TextField searchNameField;
    @FXML
    private ComboBox<SortCriteria> sortComboBox;

    enum SortCriteria {
        SORT_BY_NAME,
        SORT_BY_ID,
        SORT_BY_DOB
    }
    
    private void clearForm() {
        idField.setText("");
        nameField.setText("");
        sexComboBox.getSelectionModel().clearSelection();
        dobDatePicker.setValue(LocalDate.now());       
    }
    
    private void loadStudents() {
        try {
            String query = "SELECT * FROM student";
            System.out.println("Query [" + query + "]");
            ResultSet result = statement.executeQuery(query);
            students = FXCollections.observableArrayList();
            filteredStudents = new FilteredList(students, p -> true);
            studentListView.setItems(filteredStudents);
            while (result.next()) {
                Student student = new Student(result.getString("id"), 
                        result.getString("name"), 
                        result.getString("sex").charAt(0) == 'M' ? Sex.MALE : Sex.FEMALE,
                        result.getDate("dob").toLocalDate());
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sexComboBox.getItems().setAll(Sex.values());
        sortComboBox.getItems().setAll(SortCriteria.values());
        searchNameField.textProperty().addListener((event, oldValue, newValue) -> {
            filteredStudents.setPredicate(student -> {
                if (newValue == null || newValue.length() == 0)
                    return true;
                else return student.getName().contains(newValue);
            });
        });
        try {
            Class.forName("com.mysql.jdbc.Driver");            
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            statement = connection.createStatement();
            System.out.println("Connection established");
            loadStudents();
        } catch (SQLException ex) {
            System.out.println("Failed");
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void newStudentAction(ActionEvent event) {
        clearForm();
    }

    @FXML
    private void saveStudentAction(ActionEvent event) {
        Student student;
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        Sex sex = sexComboBox.getSelectionModel().getSelectedItem();
        LocalDate dob = dobDatePicker.getValue();
        
        String insertQuery = "INSERT INTO student VALUES('" + id
                + "', '" + name + "', '" + sex.name().charAt(0) + "', '"
                + dob + "');";
        try {
            System.out.println("Query [" + insertQuery + "]");
            statement.executeUpdate(insertQuery);
            student = new Student(id, name, sex, dob);
            students.add(student);
            clearForm();
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sortAction(ActionEvent event) {
        SortCriteria criteria = sortComboBox.getSelectionModel().getSelectedItem();
        
        switch (criteria) {
            case SORT_BY_NAME:
                Collections.sort(students, (s1, s2) -> ((Student) s1).getName().compareTo(((Student) s2).getName()));
                break;
            default:
                break;
        }
    }
}
