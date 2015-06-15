/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.management.system;

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
    private TextField accessionField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField authorField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField yearField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleNewAction(ActionEvent event) {
        accessionField.setText("");
        nameField.setText("");
        authorField.setText("");
        priceField.setText("");
        yearField.setText("");
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
        int accession = Integer.parseInt(accessionField.getText());
        String name = nameField.getText();
        String author = authorField.getText();
        double price = Double.parseDouble(priceField.getText());
        int year = Integer.parseInt(yearField.getText());
        
        Book b = new Book(accession, name, author, price, year);
        System.out.println(b);
        try {
            RandomAccessFile fout = new RandomAccessFile("book.txt", "rw");
            fout.seek(fout.length());
            fout.writeBytes(b.toString() + "\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleLoadAction(ActionEvent event) {
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
    }
    
}
