/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.fxml.handling.section.pkg2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author kmhasan
 */
public class ProductUIController implements Initializable {
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleResetAction(ActionEvent event) {
        System.out.println("Reset called");
    }

    @FXML
    private void handleAddAction(ActionEvent event) {
        String id = idField.getText();
        String name = nameField.getText();
        System.out.println(id + " " + name);
    }
    
}
