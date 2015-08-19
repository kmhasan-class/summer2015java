/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel.numbers;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ParallelNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        // Using a subclass of Thread class
        NumberPrinter a = new NumberPrinter(10000, "A");
        NumberPrinter b = new NumberPrinter(10000, "B");
        NumberPrinter c = new NumberPrinter(10000, "C");
                */

        /*
        // Using an implementation of Runnable interface
        NumberPrinterRunnable a = new NumberPrinterRunnable(10000, "A");
        NumberPrinterRunnable b = new NumberPrinterRunnable(10000, "B");
        NumberPrinterRunnable c = new NumberPrinterRunnable(10000, "C");
                */
        
        /*
        // extending Thread
        NumberSum a = new NumberSum(1, 5000000);
        NumberSum b = new NumberSum(5000001, 10000000);

        try {
            a.join();
            b.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ParallelNumbers.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(a.getResult());
        System.out.println(b.getResult());
        System.out.println(a.getResult() + b.getResult());
        */
        
        // implementing Runnable
        NumberSumRunnable a = new NumberSumRunnable(1, 5000000);
        NumberSumRunnable b = new NumberSumRunnable(5000001, 10000000);

        try {
            a.getThread().join();
            b.getThread().join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ParallelNumbers.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(a.getResult());
        System.out.println(b.getResult());
        System.out.println(a.getResult() + b.getResult());
    }
}
