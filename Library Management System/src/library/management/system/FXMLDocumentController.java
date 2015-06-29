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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
    //Book books[];
    int currentIndex = 0;
    @FXML
    private Button nextButton;
    @FXML
    private Button backButton;
    @FXML
    private ListView<Book> bookList;
    private ObservableList<Book> books;
    
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
            fout.writeBytes(b.getFullInformation() + "\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //private void displayBook(Book book) {
    private void displayBook(int index) {
        //Book book = books[index];
        Book book = books.get(index);
        accessionField.setText("" + book.getAccessionNumber());
        nameField.setText(book.getBookName());
        authorField.setText(book.getAuthor());
        priceField.setText("" + book.getPrice());
        yearField.setText("" + book.getYear());
    }
    
    @FXML
    private void handleLoadAction(ActionEvent event) {
        //books = new Book[1000];
        books = FXCollections.observableArrayList();
        bookList.setItems(books);
        int index = 0;
        try {
            RandomAccessFile fin = new RandomAccessFile("book.txt", "r");
            while (true) {
                String accessionNumberString = fin.readLine();
                if (accessionNumberString == null)
                    break;
                int accessionNumber = Integer.parseInt(accessionNumberString);
                String authorName = fin.readLine();
                String bookName = fin.readLine();
                double price = Double.parseDouble(fin.readLine());
                int year = Integer.parseInt(fin.readLine());
                Book book = new Book(accessionNumber, bookName, authorName, price, year);
                //books[index] = book;
                //index++;
                books.add(book);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find book.txt file!");
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        displayBook(0);
        nextButton.setDisable(false);
    }

    @FXML
    private void handleNextAction(ActionEvent event) {
        currentIndex++;
        if (currentIndex > 0)
            backButton.setDisable(false);
        displayBook(currentIndex);
    }

    @FXML
    private void handleBackAction(ActionEvent event) {
        if (currentIndex > 0)
            currentIndex--;
        if (currentIndex == 0)
            backButton.setDisable(true);
        displayBook(currentIndex);
    }

    @FXML
    private void handleListAction(MouseEvent event) {
        currentIndex = bookList.getSelectionModel().getSelectedIndex();
        displayBook(currentIndex);
    }
    
}
