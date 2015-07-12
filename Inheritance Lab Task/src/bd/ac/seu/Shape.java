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
public class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return 0.0;
    }
    
    public double getPerimeter() {
        return 0.0;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
