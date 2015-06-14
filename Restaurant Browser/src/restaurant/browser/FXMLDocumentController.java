/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.browser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField nameField;
    @FXML
    private TextField areaField;
    @FXML
    private TextField cuisineField;
    @FXML
    private TextField hoursField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField reservationField;
    Restaurant restaurants[];
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleNewAction(ActionEvent event) {
        nameField.setText("");
        areaField.setText("");
        cuisineField.setText("");
        addressField.setText("");
        hoursField.setText("");
        reservationField.setText("");
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        String name = nameField.getText();
        String area = areaField.getText();
        String cuisine = cuisineField.getText();
        String hours = hoursField.getText();
        String address = addressField.getText();
        String phone = reservationField.getText();
        
        Restaurant r = new Restaurant(name, area, cuisine, hours, address, phone);
        
        System.out.println(r);
        try {
            RandomAccessFile output = new RandomAccessFile("restaurant.txt", "rw");
            output.seek(output.length());
            output.writeBytes(r.toString() + "\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
    }

    /*
    void displayRestaurant(Restaurant r) {
        nameField.setText(r.getName());
        areaField.setText(r.getArea());
        cuisineField.setText(r.getCuisine());
    }
    */
    void displayRestaurant(int index) {
        Restaurant r = restaurants[index];
        nameField.setText(r.getName());
        areaField.setText(r.getArea());
        //displayRestaurant(restaurants[index]);
    }
    
    @FXML
    private void handleLoadAction(ActionEvent event) {
        restaurants = new Restaurant[100];
        int index = 0;
        try {
            RandomAccessFile input = new RandomAccessFile("restaurant.txt", "r");
            while (true) {
                String name = input.readLine();
                if (name == null)
                    break;
                String area = input.readLine();
                String cuisine = input.readLine();
                String hours = input.readLine();
                String address = input.readLine();
                String phone = input.readLine();
                Restaurant r = new Restaurant(name, area, cuisine, hours, address, phone);
                restaurants[index] = r;
                System.out.println(r);
                index++;
            }
            displayRestaurant(0);
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find restaurant.txt file!");
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}












