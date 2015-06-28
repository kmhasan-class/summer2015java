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
// STUDY "Sieve of Eratosthenes" before Tuesday's class
public class PrimeFactorizer {
    public static <N extends Number> ArrayList<Pair<N, N>> primeFactorize(N n) {
        ArrayList<Pair<N, N>> result = new ArrayList<>();
        if (n instanceof Integer) {
            int m = n.intValue();
            //int m = (Integer) n;
            for (int i = 2; i * i <= m; i++) {
                int prime = i;
                int exponent = 0;
                while (m % prime == 0) {
                    exponent = exponent + 1;
                    m = m / prime;
                }
                if (exponent > 0)
                    result.add(new Pair(prime, exponent));
            }
            if (m > 1)
                result.add(new Pair(n, 1));            
        } else if (n instanceof Long) {
            long m = n.longValue();
            //int m = (Integer) n;
            for (long i = 2l; i * i <= m; i++) {
                long prime = i;
                long exponent = 0;
                while (m % prime == 0) {
                    exponent = exponent + 1;
                    m = m / prime;
                }
                if (exponent > 0)
                    result.add(new Pair(prime, exponent));
            }
            if (m > 1)
                result.add(new Pair(n, 1));            
        } else if (n instanceof BigInteger) {
            BigInteger m = (BigInteger) n;
            for (BigInteger i = new BigInteger("2"); i.multiply(i).compareTo(m) <= 0; i = i.add(BigInteger.ONE)) {
                BigInteger prime = i;
                BigInteger exponent = BigInteger.ZERO;
                while (m.mod(prime).equals(BigInteger.ZERO)) {
                    exponent = exponent.add(BigInteger.ONE);
                    m = m.divide(prime);
                }
                if (exponent.compareTo(BigInteger.ZERO) > 0)
                    result.add(new Pair(prime, exponent));
            }
            if (m.compareTo(BigInteger.ONE) > 0)
                result.add(new Pair(m, BigInteger.ONE));
        }
        return result;
    }
    /*
    public static ArrayList<Pair<Integer, Integer>> primeFactorize(Integer n) {
        ArrayList<Pair<Integer, Integer>> result = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            int prime = i;
            int exponent = 0;
            while (n % prime == 0) {
                exponent = exponent + 1;
                n = n / prime;
            }
            if (exponent > 0)
                result.add(new Pair(prime, exponent));
        }
        if (n > 1)
            result.add(new Pair(n, 1));
        return result;
    }
    
    public static ArrayList<Pair<BigInteger, BigInteger>> primeFactorize(BigInteger n) {
        ArrayList<Pair<BigInteger, BigInteger>> result = new ArrayList<>();
        for (BigInteger i = new BigInteger("2"); i.multiply(i).compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger prime = i;
            BigInteger exponent = BigInteger.ZERO;
            while (n.mod(prime).equals(BigInteger.ZERO)) {
                exponent = exponent.add(BigInteger.ONE);
                n = n.divide(prime);
            }
            if (exponent.compareTo(BigInteger.ZERO) > 0)
                result.add(new Pair(prime, exponent));
        }
        if (n.compareTo(BigInteger.ONE) > 0)
            result.add(new Pair(n, BigInteger.ONE));
        return result;
    }
    */
}
