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
    @FXML
    private TextField codeField;
    @FXML
    private TextField titleField;
    @FXML
    private TextField creditsField;
    @FXML
    private Button addButton;
    @FXML
    private Button resetButton;
    @FXML
    private ImageView imageView;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        Image image = new Image("http://4.bp.blogspot.com/-AwZ_oq5Ihks/U8uytmiJHaI/AAAAAAAAAs0/GBP880E6Id8/s1600/naila-nayem-hot-05.jpg");
        Image image = new Image(FXMLDocumentController.class.getResourceAsStream("images/naila.jpg"));
        imageView.setImage(image);
    }    
    
}
