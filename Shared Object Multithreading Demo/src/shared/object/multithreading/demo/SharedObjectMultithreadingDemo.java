/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.object.multithreading.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class SharedObjectMultithreadingDemo {
    int counter = 0;

    public synchronized void increment() {
        counter++;
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedObjectMultithreadingDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSequentially() {
        counter = 0;
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 1000; i++)
            increment();
        for (int i = 1; i <= 1000; i++)
            increment();
        long stop = System.currentTimeMillis();
        System.out.println("Value of counter " + counter);
        System.out.printf("Time taken: %d ms\n", (stop - start));
    }
    
    public void doParallely() {
        counter = 0;
        long start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {for (int i = 1; i <= 1000; i++) increment();});
        Thread t2 = new Thread(() -> {for (int i = 1; i <= 1000; i++) increment();});
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SharedObjectMultithreadingDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        long stop = System.currentTimeMillis();
        System.out.println("Value of counter " + counter);
        System.out.printf("Time taken: %d ms\n", (stop - start));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        SharedObjectMultithreadingDemo obj = new SharedObjectMultithreadingDemo();
//        obj.doSequentially();
//        obj.doParallely();
        ParallelIncrement p = new ParallelIncrement();
//        p.doParallely();
        p.doSort();
    }
    
}
