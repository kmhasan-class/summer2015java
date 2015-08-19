/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel.sorting.demo;

import java.util.Arrays;

/**
 *
 * @author kmhasan
 */
public class ParallelSortingDemo {
    public ParallelSortingDemo() {
        int n = 100000000;
        int data[] = new int[n];
        for (int i = 0; i < data.length; i++)
            data[i] = (int) (Math.random() * 1000);
        long start = System.currentTimeMillis();
        //Arrays.sort(data);
        Arrays.parallelSort(data);
        long stop = System.currentTimeMillis();
        long timeTaken = stop - start;
        System.out.printf("Time taken: %.3f seconds\n", timeTaken / 1000.0);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ParallelSortingDemo();
    }
    
}
