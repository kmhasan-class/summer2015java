/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu;

import java.math.BigInteger;
import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author kmhasan
 */
public class GenericsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 2 * 2 * 2 * 3 * 3 * 5 * 5 * 5;
        System.out.println(n);
        ArrayList<Pair<Integer, Integer>> result = PrimeFactorizer.primeFactorize(n);
        for (Pair<Integer, Integer> p: result)
            System.out.println(p.getKey() + "^" + p.getValue());

        BigInteger m = new BigInteger("456415113154747550000");
        System.out.println(m);
        ArrayList<Pair<BigInteger, BigInteger>> bigResult = PrimeFactorizer.primeFactorize(m);
        for (Pair<BigInteger, BigInteger> p: bigResult)
            System.out.println(p.getKey() + "^" + p.getValue());
    }
    
}
