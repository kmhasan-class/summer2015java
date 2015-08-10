/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.ball.section.pkg2;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author kmhasan
 */
public class Ball extends Circle {
    private double vX;
    private double vY;
    private int signX = +1;
    private int signY = +1;

    public Ball(double vX, double vY) {
        this.vX = vX;
        this.vY = vY;
    }

    public Ball(double radius) {
        super(radius);
    }

    public Ball(double radius, Paint fill) {
        super(radius, fill);
    }

    public Ball() {
        super();
    }

    public Ball(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }

    public Ball(double centerX, double centerY, double radius, Paint fill) {
        super(centerX, centerY, radius, fill);
    }

    public void setvX(double vX) {
        this.vX = vX;
    }

    public void setvY(double vY) {
        this.vY = vY;
    }
    
    public void updateBall() {
        double newX = this.getCenterX() + signX * vX;
        double newY = this.getCenterY() + signY * vY;
        if (newX < 0 || newX > 600) signX = -signX;
        if (newY < 0 || newY > 600) signY = -signY;
        this.setCenterX(newX);
        this.setCenterY(newY);
    }
    
    public boolean isColliding(Ball anotherBall) {
        double ra = this.getRadius();
        double rb = anotherBall.getRadius();
        double dx = this.getCenterX() - anotherBall.getCenterX();
        double dy = this.getCenterY() - anotherBall.getCenterY();
        double d = Math.sqrt(dx * dx + dy * dy);
//        return ra + rb >= d;
        if (ra + rb >= d)
            return true;
        else return false;
    }
}
