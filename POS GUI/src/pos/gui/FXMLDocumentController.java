/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.gui;

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
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField priceField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSaveAction(ActionEvent event) {
        Product p = new Product(Integer.parseInt(idField.getText()), 
                nameField.getText(), 
                typeField.getText(), 
                Double.parseDouble(priceField.getText()));
        
        // Printing to console
        System.out.println(p);

        // Printing to a file
        try {
            RandomAccessFile fout = new RandomAccessFile("product.txt", "rw");
            fout.seek(fout.length());
            fout.writeBytes(p.toString() + "\n");
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't find product.txt file");
        } catch (IOException ex) {
            System.out.println("Some error occured during write operation");
        }
        
        clearForm();
    }
    
    private void clearForm() {
        idField.setText("");
        nameField.setText("");
        typeField.setText("");
        priceField.setText("");
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
        clearForm();
    }
    
}
