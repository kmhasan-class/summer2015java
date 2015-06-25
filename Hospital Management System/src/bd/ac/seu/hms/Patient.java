/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.hms;

import java.time.LocalDate;

/**
 *
 * @author kmhasan
 */
public class Patient {
    private int patientId;
    private String patientName;
    private LocalDate dob;
    private BloodGroup bloodGroup;
    private String medicalHistory;
    private String contactPerson;
    private String contactNumber;

    public Patient(int patientId, String patientName, LocalDate dob, BloodGroup bloodGroup) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return patientId + "\n" 
                + patientName + "\n" 
                + dob + "\n" 
                + bloodGroup + "\n" 
                + medicalHistory + "\n" 
                + contactPerson + "\n" 
                + contactNumber;
    }

    
}
