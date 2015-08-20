/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel.sorting.demo.section.pkg1;

import java.util.Arrays;

/**
 *
 * @author kmhasan
 */
public class ParallelSortingDemoSection1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 100000000;
        int data[] = new int[n];
        
        for (int i = 0; i < data.length; i++)
            data[i] = (int) (Math.random() * 100);
        
        long startTime = System.currentTimeMillis();
        Arrays.parallelSort(data);
//        Arrays.sort(data);
        long stopTime = System.currentTimeMillis();
        
        long timeTaken = stopTime - startTime;
        
        System.out.printf("Time taken: %.3f seconds\n", timeTaken / 1000.0);
    }
    
}
