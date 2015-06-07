/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.looptest;

/**
 *
 * @author kmhasan
 */
public class LoopTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double pi = 0;
        for (int k = 1; k <= 100; k++) {
            double term = Math.pow(-1.0, k + 1)/(2 * k - 1);
            pi = pi + term;
        }
        pi = 4 * pi;
        double approximateValue = pi;
        double trueValue = Math.PI;
        double error = 100 * Math.abs((trueValue - approximateValue) / trueValue);
        
        System.out.printf("Approximate PI = %.10f\n", approximateValue);
        System.out.printf("True PI = %.10f\n", trueValue);
        System.out.printf("%% Error = %.10f\n", error);
    }
    
}
