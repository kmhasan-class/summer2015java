/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package message.posting.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ListView<String> friendsList;
    @FXML
    private TextField friendField;
    ObservableList<String> friends;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        friends = FXCollections.observableArrayList();
        friendsList.setItems(friends);
    }    

    @FXML
    private void handleAddTagAction(ActionEvent event) {
        String friendName = friendField.getText();
        friends.add(friendName);
    }

    @FXML
    private void handleRemoveTagAction(ActionEvent event) {
        friends.remove(friendsList.getSelectionModel().getSelectedItem());
    }
    
}
