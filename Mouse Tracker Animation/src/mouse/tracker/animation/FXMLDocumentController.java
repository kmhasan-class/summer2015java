/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse.tracker.animation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    private double vx = 0;
    private double vy = 0;
    private double targetX = 0;
    private double targetY = 0;
    private Circle circle;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        circle = new Circle(300, 200, 20);
        anchorPane.getChildren().add(circle);
        
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100),
            event -> {
                double oldX = circle.getCenterX();
                double oldY = circle.getCenterY();
                
                if (Math.abs(targetX - oldX) < 0.1 &&
                        Math.abs(targetY - oldY) < 0.1) {
                    vx = 0;
                    vy = 0;
                }
                    
                double newX = oldX + vx;
                double newY = oldY + vy;
                
                circle.setCenterX(newX);
                circle.setCenterY(newY);
            });
        timeline.getKeyFrames().add(keyFrame);
        timeline.playFromStart();
                
    }    

    @FXML
    private void handleMouseMove(MouseEvent event) {
        double newX = event.getX();
        double newY = event.getY();
        targetX = newX;
        targetY = newY;
        
        double oldX = circle.getCenterX();
        double oldY = circle.getCenterY();
        
        double dx = newX - oldX;
        double dy = newY - oldY;
        
        vx = dx / 10;
        vy = dy / 10;
    }
    
}
