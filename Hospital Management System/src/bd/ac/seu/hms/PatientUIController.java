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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    @FXML
    private ComboBox<Sex> sexBox;
    private ObservableList<Patient> patients;
    private int currentIndex;
    @FXML
    private ListView<Patient> patientList;
    
    private void displayPatient(int index) {
        Patient p = patients.get(index);
        idField.setText("" + p.getPatientId());
        nameField.setText(p.getPatientName());
        dobPicker.setValue(p.getDob());
        bloodGroupBox.getSelectionModel().select(p.getBloodGroup());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentIndex = 0;
        bloodGroupBox.getItems().addAll(BloodGroup.values());
        sexBox.getItems().addAll(Sex.values());
        //patients = new ArrayList<>();
        patients = FXCollections.observableArrayList();
        patientList.setItems(patients);
        try {
            RandomAccessFile input = new RandomAccessFile("patient.txt", "r");
            while (true) {
                String line = input.readLine();
                if (line == null)
                    break;
                int id = Integer.parseInt(line);
                String name = input.readLine();
                String dateofbirth = input.readLine();
                String tokens[] = dateofbirth.split("-");
                LocalDate dob = LocalDate.of(Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
                BloodGroup bloodGroup = BloodGroup.valueOf(input.readLine());
                Sex sex = Sex.valueOf(input.readLine());
                String history = input.readLine();
                String contactPerson = input.readLine();
                String contactNumber = input.readLine();
                Patient patient = new Patient(id, name, dob, bloodGroup);
                patient.setContactNumber(contactNumber);
                patient.setContactPerson(contactPerson);
                patient.setSex(sex);
                patient.setMedicalHistory(history);
                patients.add(patient);
            }
            displayPatient(currentIndex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void handleSaveAction(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        LocalDate dob = dobPicker.getValue();
        BloodGroup group = bloodGroupBox.getSelectionModel().getSelectedItem();
        Sex sex = sexBox.getSelectionModel().getSelectedItem();
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
            output.writeBytes(patient.getFullText() + "\n");
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PatientUIController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PatientUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
        currentIndex++;
        displayPatient(currentIndex);
    }
    
}
