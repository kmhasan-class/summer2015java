/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu;

import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class PrimeGenerator {
    private static PrimeGenerator generator = new PrimeGenerator();
    private static boolean composites[];
    private static final int MAXN = 100;
    private static ArrayList<Integer> primes;
    
    private PrimeGenerator() {
        composites = new boolean[MAXN];
        for (int i = 0; i < composites.length; i++)
            composites[i] = false;
        for (int i = 2; i * i <= MAXN; i++)
            for (int j = i + i; j < MAXN; j++)
                if (j % i == 0)
                    composites[j] = true;
        primes = new ArrayList<>();
        for (int i = 2; i < MAXN; i++)
            if (!composites[i])
                primes.add(i);
    }
    
    public static ArrayList<Integer> getPrimes() {
        return primes;
    }
}
