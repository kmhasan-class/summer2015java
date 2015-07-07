/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package executor.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ExecutorDemo {
    public void someDelay(String name, int value) {
        System.out.println(name + " " + value);
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSomething() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(() -> {for (int i = 1; i <= 10; i++) someDelay("A", i);});
        executor.submit(() -> {for (int i = 1; i <= 10; i++) someDelay("B", i);});
        executor.submit(() -> {for (int i = 1; i <= 10; i++) someDelay("C", i);});
        executor.submit(() -> {for (int i = 1; i <= 10; i++) someDelay("D", i);});
        executor.shutdown();
        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(ExecutorDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ALL DONE! Let's go home!");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExecutorDemo application = new ExecutorDemo();
        application.doSomething();
    }
    
}
