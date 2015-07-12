/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author kmhasan
 */
public class InheritanceLabTask {
    public void printShapes(ArrayList<Shape> shapes, String message) {
        System.out.println(message);
        for (Shape shape: shapes)
            System.out.println(shape);
    }
    
    public void runProgram() {
        ArrayList<Shape> shapes = new ArrayList<>();
        // TASK 1: Write the body of ShapeComparator's compare method.
        ShapeComparator shapeComparator = new ShapeComparator();
        
        // TASK 2: Create the appropriate subclasses and override the methods
        // necessary.
        
        shapes.add(new Rectangle("r1", 10.0, 20.0));
//        shapes.add(new Square("s1", 10.0001));
        shapes.add(new Rectangle("r2", 10.0001, 20.0002));
        shapes.add(new Rectangle("r3",  9.9999, 19.1999));
        shapes.add(new Circle("c1", 10.0)); // 10.0 is the radius of the circle
//        shapes.add(new Triangle("t1", 2.0, 3.0, 2.1)); // length of each side
        
        printShapes(shapes, "Before sorting\n------------");
        Collections.sort(shapes, shapeComparator);
        printShapes(shapes, "After sorting\n------------");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InheritanceLabTask application = new InheritanceLabTask();
        // calling the runProgram method from main and doing everything from 
        // there to avoid making all methods and data members of this class
        // static
        application.runProgram();
    }
    
}
