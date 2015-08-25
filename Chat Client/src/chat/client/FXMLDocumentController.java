/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private TextArea messageArea;
    @FXML
    private TextField messageField;
    @FXML
    private ListView<String> userList;
    @FXML
    private Label statusLabel;
    
    private Socket socket;
    private OutputStream out;
    private InputStream in;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            socket = new Socket("172.17.0.119", 6666);
//            socket = new Socket("192.168.43.17", 6666);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            statusLabel.setText("Connected to server " + socket);
            messageField.requestFocus();
            
            ReaderThread readerThread = new ReaderThread(socket, this);
            readerThread.start();
        } catch (IOException ex) {
            statusLabel.setText("Could not connect to server");
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public void sendMessage() {
        try {
            String message = messageField.getText();
            out.write(message.getBytes());
            out.flush();
//            messageArea.appendText(message + "\n");
            messageField.setText("");
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void displayInMessageArea(String message) {
        messageArea.appendText(message);
    }
}
