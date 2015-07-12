/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu;

import java.util.Comparator;

/**
 *
 * @author kmhasan
 */
public class ShapeComparator implements Comparator {

    /**
     * Comparator implementation to compare between any two shapes.
     * 
     * Shape o1 will be smaller than Shape o2 if o1's area is less than that of
     * o2's area. If the difference between o1 and o2's areas is less than 0.001
     * then we will compare their perimeter to decide which one is smaller. The
     * one with the larger perimeter will be considered the smaller one.
     * 
     * @param o1 an object of Shape or any of it's subclasses.
     * @param o2 another object of Shape or any of it's subclasses.
     * @return 
     */
    @Override
    public int compare(Object o1, Object o2) {
        // ADD YOUR COMPARISON LOGIC HERE
        // MAKE SURE YOU TYPE CAST o1 AND o2 TO SHAPE FIRST
        return 0;
    }
    
}
