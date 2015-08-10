/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.demo.pkg2.section.pkg2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    private double radius = 300;
    private double theta = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Line line = new Line(300, 300, 600, 300);
        line.setStrokeWidth(5);
        anchorPane.getChildren().add(line);
        
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), event -> {
            line.setStartX(300);
            line.setStartY(300);
            theta += Math.PI * 2 / 60;
            double x = 300 + radius * Math.cos(theta);
            double y = 300 + radius * Math.sin(theta);
            line.setEndX(x);
            line.setEndY(y);
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }    
    
}
