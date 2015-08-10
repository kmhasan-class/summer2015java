/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animation.demo.section.pkg2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    private double radius = 300;
    private int sign = +1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Circle circle = new Circle(300, 300, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(5);

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), event -> {
            if (radius < 0 || radius > 300)
                sign = -sign;
            radius = radius - sign * 10;
            Circle c = new Circle(300, 300, radius);
            c.setFill(new Color(1, 1, 1, 0.1));
            c.setStroke(Color.BLACK);
            c.setStrokeWidth(5);
            anchorPane.getChildren().add(c);
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.playFromStart();
    }    
    
}
