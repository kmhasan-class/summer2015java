/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.picalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class PiCalculator {

    public double calculatePi(int terms) {
        double sum  = 0;
        for (int k = 1; k <= terms; k++)
            if (k % 2 == 0)
                sum = sum - 1.0 / (2 * k - 1);
            else sum = sum + 1.0 / (2 * k - 1);
        return sum * 4;
    }

    public BigDecimal calculatePiBD(int terms, int scale) {
        BigDecimal sum  = BigDecimal.ZERO;
        for (int k = 1; k <= terms; k++) {
            BigDecimal t = BigDecimal.valueOf(2.0).multiply(BigDecimal.valueOf(k)).subtract(BigDecimal.ONE);

            t = BigDecimal.ONE.divide(t, scale, RoundingMode.UP);
            if (k % 2 == 0)
                sum = sum.subtract(t);
            else sum = sum.add(t);
        }
        return sum.multiply(BigDecimal.valueOf(4.0));
    }

    public BigDecimal calculatePiBDMT(int terms, int scale, int numCores) {
        PiCalculatorMT threads[] = new PiCalculatorMT[numCores];
        for (int i = 0; i < numCores; i++)
            threads[i] = new PiCalculatorMT(terms / numCores * i + 1, terms / numCores * (i + 1), terms, scale);
        for (PiCalculatorMT t: threads)
            t.start();
        BigDecimal sum = BigDecimal.ZERO;
        try {
            for (PiCalculatorMT t: threads)
                t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(PiCalculator.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (PiCalculatorMT t: threads)
            sum = sum.add(t.getPi());
        return sum;
    } 
    
    public PiCalculator() {
        //3.14159265358979323846264338327950288419716939937510
        int terms = 10000000;
        int scale = 1000;
        long start, stop;
        
        start = System.currentTimeMillis();
        System.out.printf("%.30f\n", 2 * Math.acos(0));
        stop = System.currentTimeMillis();
        System.out.printf("Time taken: %.3f seconds\n\n", (stop - start) / 1000.0);
        
        start = System.currentTimeMillis();
        System.out.printf("%.30f\n", calculatePi(terms));
        stop = System.currentTimeMillis();
        System.out.printf("Time taken: %.3f seconds\n\n", (stop - start) / 1000.0);

        start = System.currentTimeMillis();
        System.out.println(calculatePiBDMT(terms, scale, Runtime.getRuntime().availableProcessors()));
        stop = System.currentTimeMillis();
        System.out.printf("Time taken: %.3f seconds\n\n", (stop - start) / 1000.0);
        
        start = System.currentTimeMillis();
        System.out.println(calculatePiBD(terms, scale));
        stop = System.currentTimeMillis();
        System.out.printf("Time taken: %.3f seconds\n\n", (stop - start) / 1000.0);
        //System.out.println(calculatePiBD());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new PiCalculator();
    }
    
}
