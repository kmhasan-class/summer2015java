/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiple.fxml.handling.section.pkg2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kmhasan
 */
public class MainUIController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCloseAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void handleProductInformationAction(ActionEvent event) {
        // open ProductUI.fxml
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("ProductUI.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(MainUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root);
        
        Stage stage = MultipleFXMLHandlingSection2.getStage();
        stage.setScene(scene);
        stage.show();
        
    }
    
}
