/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.ball.demo;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author kmhasan
 */
public class Ball extends Circle {
    private double vX;
    private double vY;
    private int signX;
    private int signY;
    
    public Ball(double radius) {
        super(radius);
        signX = +1;
        signY = +1;
    }

    public Ball(double radius, Paint fill) {
        super(radius, fill);
        signX = +1;
        signY = +1;
    }

    public Ball() {
        signX = +1;
        signY = +1;
    }

    public Ball(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
        signX = +1;
        signY = +1;
    }

    public Ball(double centerX, double centerY, double radius, Paint fill) {
        super(centerX, centerY, radius, fill);
        signX = +1;
        signY = +1;
    }

    public double getvX() {
        return vX;
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public double getvY() {
        return vY;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }
    
    public void updateLocation() {
        double newX = getCenterX() + signX * vX;
        double newY = getCenterY() + signY * vY;
        setCenterX(newX);
        setCenterY(newY);
        if (newX < 0 || newX >= 600)
            signX = -signX;
        if (newY < 0 || newY >= 600)
            signY = -signY;
    }
    
    public boolean isColliding(Ball anotherBall) {
        double r1 = this.getRadius();
        double r2 = anotherBall.getRadius();
        double dx = this.getCenterX() - anotherBall.getCenterX();
        double dy = this.getCenterY() - anotherBall.getCenterY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        if (r1 + r2 >= distance)
            return true;
        else return false;
    }
}
