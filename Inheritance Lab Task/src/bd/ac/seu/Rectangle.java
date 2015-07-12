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
public class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String name) {
        super(name);
    }
    
    public Rectangle(String name, double length, double width) {
        this(name);
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }

    @Override
    public double getArea() {
        return length * width;
    }
    
}
