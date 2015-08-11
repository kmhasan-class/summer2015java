/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package css.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Button addButton;
    @FXML
    private Button resetButton;
    @FXML
    private TextField codeField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField creditsField;
    @FXML
    private ImageView imageView;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Image image = new Image("http://172.17.4.254/~kmhasan/CSE2015/icons/Add.png");
        Image image = new Image(FXMLDocumentController.class.getResourceAsStream("images/KMH.jpg"));
        imageView.setImage(image);
    }    
    
}
