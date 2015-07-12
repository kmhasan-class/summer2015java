/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu;

/**
 *
 * @author kmhasan
 */
public class Circle extends Shape {
    private double radius;
/*    
    public Circle(String name) {
        super(name);
    }
*/
    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    
    public double getRadius() {
        return radius;
    }
    
    
}
