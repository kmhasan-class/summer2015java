/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.object.multithreading.demo;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ParallelIncrement {
    Object lock1 = new Object();
    Object lock2 = new Object();
    
    int counter1 = 0;
    int counter2 = 0;
    
    public void increment1() {
        synchronized(lock1) {
            counter1++;
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParallelIncrement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void increment2() {
        synchronized(lock2) {
            counter2++;
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(ParallelIncrement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doParallely() {
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {for (int i = 1; i <= 1000; i++) increment1();});
        Thread t2 = new Thread(() -> {for (int i = 1; i <= 1000; i++) increment2();});
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ParallelIncrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        long stop = System.currentTimeMillis();
        System.out.printf("Value of total counter: %d\n", counter1 + counter2);
        System.out.printf("Time taken: %d ms\n", (stop - start));
        
    }
    
    public void doSort() {
        int array[] = new int[100000000];
        for (int i = 0; i < array.length; i++)
            array[i] = (int) (Math.random() * 100);
        long start = System.currentTimeMillis();
//        Arrays.sort(array);
        Arrays.parallelSort(array);
        long stop = System.currentTimeMillis();
        System.out.printf("Time taken: %d ms\n", (stop - start));
    }
}
