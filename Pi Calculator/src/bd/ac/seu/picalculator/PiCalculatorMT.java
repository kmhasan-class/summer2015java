/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.picalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author kmhasan
 */
public class PiCalculatorMT extends Thread {
    private int start;
    private int stop;
    private int terms;
    private int scale;
    private BigDecimal pi = BigDecimal.ONE;
    
    public PiCalculatorMT() {
        super();
    }

    public PiCalculatorMT(int start, int stop, int terms, int scale) {
        super();
        this.start = start;
        this.stop = stop;
        this.terms = terms;
        this.scale = scale;
    }
    
    @Override
    public void run() {
        BigDecimal sum  = BigDecimal.ZERO;
        for (int k = start; k <= stop; k++) {
            BigDecimal t = BigDecimal.valueOf(2.0).multiply(BigDecimal.valueOf(k)).subtract(BigDecimal.ONE);

            t = BigDecimal.ONE.divide(t, scale, RoundingMode.UP);
            if (k % 2 == 0)
                sum = sum.subtract(t);
            else sum = sum.add(t);
        }
        pi = sum.multiply(BigDecimal.valueOf(4.0));
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    public int getTerms() {
        return terms;
    }

    public int getScale() {
        return scale;
    }

    public BigDecimal getPi() {
        return pi;
    }
}
