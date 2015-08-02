/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author kmhasan
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Canvas drawingCanvas;
    private double lastX = -1;
    private double lastY = -1;
    private double locX = 50;
    private double locY = 30;
    private int signX = +1;
    private int signY = +1;
    private GraphicsContext gc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = drawingCanvas.getGraphicsContext2D();
        gc.setFill(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        gc.fillRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
    }    

    @FXML
    private void handleCircleAction(ActionEvent event) {
        gc.setFill(Color.BISQUE);
        gc.setStroke(Color.BROWN);
        gc.setLineWidth(5);
        gc.fillOval(100.0, 100.0, 200.0, 200.0);
        gc.strokeOval(100.0, 100.0, 200.0, 200.0);
    }

    @FXML
    private void handleRectangleAction(ActionEvent event) {
        gc.strokeRect(20, 10, 300, 50);
    }

    @FXML
    private void handleMouseClick(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        double radius = 10;
        gc.setFill(Color.BLACK);
        gc.fillOval(x - radius / 2, y - radius / 2, radius, radius);
        if (lastX > 0 && lastY > 0)
            gc.strokeLine(lastX, lastY, x, y);
        gc.setLineWidth(radius);
        lastX = x;
        lastY = y;
    }

    @FXML
    private void handleClearAction(ActionEvent event) {
        gc.setFill(new Color(1.0f, 1.0f, 1.0f, 1.0f));
        gc.fillRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
    }

    @FXML
    private void handleMouseRelease(MouseEvent event) {
        lastX = -1;
        lastY = -1;
        System.out.println("Mouse released");
    }

    @FXML
    private void handleRedColorAction(ActionEvent event) {
        gc.setFill(Color.RED);
        gc.setStroke(Color.RED);
    }

    @FXML
    private void handleGreenColorAction(ActionEvent event) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.GREEN);
    }

    @FXML
    private void handleBlueColorAction(ActionEvent event) {
        gc.setFill(Color.BLUE);
        gc.setStroke(Color.BLUE);
    }

    @FXML
    private void handleStartAnimationAction(ActionEvent event) {
        Timeline timeline = new Timeline();
        KeyFrame keyFrame;
        keyFrame = new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                gc.setFill(Color.WHITE);
                gc.fillRect(0, 0, drawingCanvas.getWidth(), drawingCanvas.getHeight());
                gc.strokeOval(locX, locY, 10, 10);
                locX = locX + signX * 0.5;
                locY = locY + signY * 1;
                if (locX > drawingCanvas.getWidth() - 20 || locX < 0)
                    signX = -signX;
                if (locY > drawingCanvas.getHeight() - 20 || locY < 0)
                    signY = -signY;
            }
        });
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.playFromStart();
    }
    
}
