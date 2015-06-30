/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.advancedjavalab;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author kmhasan
 */
public class Task1 {
    public <T> ArrayList<T> subset(ArrayList<T> data, Predicate<T> tester) {
        ArrayList<T> sub = new ArrayList<>();
        for (T t: data)
            if (tester.test(t))
                sub.add(t);
        return sub;
    }
    
    public <T> void print(ArrayList<T> data) {
        for (T t: data)
            System.out.println(t);
    }
    
    public Task1() {
        ArrayList<String> cricketers = new ArrayList<>();
        cricketers.add("Mashrafi");
        cricketers.add("Sabbir");
        cricketers.add("Nasir");
        cricketers.add("Mushfiq");
        cricketers.add("Mustafiz");
        cricketers.add("Rubel");
        cricketers.add("Tamim");
        print(subset(cricketers, p -> p.length() == 5));
        //print(cricketers);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Task1();
    }
    
}
