/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouse.tracking.section.pkg2;

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
    private double targetX = 500;
    private double targetY = 100;
    private double vX = 0;
    private double vY = 0;
    private int frames = 10;    
    private Circle circle;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        circle = new Circle(300.01, 300.02, 20);

        anchorPane.getChildren().add(circle);
        
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100),
            event -> {
                double currentX = circle.getCenterX();
                double newX = currentX + vX;
                double currentY = circle.getCenterY();
                double newY = currentY + vY;
                if (Math.abs(currentX - targetX) < 1 
                        && Math.abs(currentY - targetY) < 1) {
                    vX = 0;
                    vY = 0;
                }
                circle.setCenterX(newX);
                circle.setCenterY(newY);
            });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }    

    @FXML
    private void handleMouseMove(MouseEvent event) {
        targetX = event.getX();
        targetY = event.getY();
        
        double dX = targetX - circle.getCenterX();
        double dY = targetY - circle.getCenterY();
        
        vX = dX / frames;
        vY = dY / frames;        
    }
    
}
