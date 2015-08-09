/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.ball.demo;

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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private AnchorPane anchorPane;
    private ArrayList<Ball> balls;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Circle circle = new Circle(300, 300, 20);
        balls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Ball ball = new Ball(Math.random() * 600, Math.random() * 600, 20);
            ball.setvX(Math.random() * Math.random() < 0.5 ? -1 : 1);
            if (Math.random() < 0.5)
                ball.setvY(Math.random() * 1);
            else ball.setvY(Math.random() * -1);
            ball.setFill(new Color(Math.random(), Math.random(), Math.random(), 1.0));
            ball.setStroke(Color.BLACK);
            ball.setStrokeWidth(2);
            balls.add(ball);
        }
            
        anchorPane.getChildren().add(circle);
        anchorPane.getChildren().addAll(balls);
        
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), event -> {
            for (int i = 0; i < balls.size(); i++)
                for (int j = 0; j < balls.size(); j++)
                    if (i != j && balls.get(i).isColliding(balls.get(j))) {
                        balls.get(i).setvX(0);
                        balls.get(i).setvY(0);
                    }
                    
            for (Ball ball: balls) {
                ball.updateLocation();
            }
        });
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(keyFrame);
        timeline.playFromStart();
    }    
    
}
