/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.ball.section.pkg2;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int numCircles = 10;
        ArrayList<Ball> balls = new ArrayList<>();
        for (int i = 0; i < numCircles; i++) {
            // Math.random() gives you a value in the range [0, 1)
            // we need to map [0, 1) -> [0, 600)
            double centerX = Math.random() * 600;
            double centerY = Math.random() * 600;
            Ball c = new Ball(centerX, centerY, 20);
            c.setvX(Math.random());
            c.setvY(Math.random());
            balls.add(c);
        }
        anchorPane.getChildren().addAll(balls);
//        for (Circle c: balls)
//            anchorPane.getChildren().add(c);
        
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), event -> {
            for (Ball b: balls)
                b.updateBall();
            for (int i = 0; i < balls.size(); i++)
                for (int j = 0; j < balls.size(); j++)
                    if (i != j && balls.get(i).isColliding(balls.get(j))) {
                        balls.get(i).setvX(0);
                        balls.get(i).setvY(0);
                    }
        });
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
        timeline.playFromStart();
    }    
    
}
