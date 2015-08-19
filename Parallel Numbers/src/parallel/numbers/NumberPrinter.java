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
public class NumberPrinter extends Thread {
    int n;
    String name;

    public NumberPrinter(int n, String name) {
        this.n = n;
        this.name = name;
        start();
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
