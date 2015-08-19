/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallel.numbers;

/**
 *
 * @author kmhasan
 */
public class NumberPrinterRunnable implements Runnable {
    int n;
    String name;

    public NumberPrinterRunnable(int n, String name) {
        this.n = n;
        this.name = name;
        Thread t = new Thread(this);
        t.start();
    }
    
    public void print() {
        for (int i = 1; i <= n; i++)
            System.out.println(name + " " + i);
    }
    
    @Override
    public void run() {
        print();
    }
    
}
