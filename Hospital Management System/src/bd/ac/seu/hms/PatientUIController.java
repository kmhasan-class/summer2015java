/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.hms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class PatientUIController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextArea historyArea;
    @FXML
    private TextField contactPersonField;
    @FXML
    private DatePicker dobPicker;
    @FXML
    private ComboBox<BloodGroup> bloodGroupBox;
    @FXML
    private TextField contactNumberField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bloodGroupBox.getItems().addAll(BloodGroup.values());
    }    

    @FXML
    private void handleSaveAction(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        LocalDate dob = dobPicker.getValue();
        BloodGroup group = bloodGroupBox.getSelectionModel().getSelectedItem();
        String history = historyArea.getText();
        String contactPerson = contactPersonField.getText();
        String contactNumber = contactNumberField.getText();
        
        Patient patient = new Patient(id, name, dob, group);
        patient.setContactNumber(contactNumber);
        patient.setContactPerson(contactPerson);
        patient.setMedicalHistory(history);
        
        try {
            RandomAccessFile output = new RandomAccessFile("patient.txt", "rw");
            output.seek(output.length());
            output.writeBytes(patient.toString() + "\n");
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
    }
    
}
