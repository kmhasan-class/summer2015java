/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo;

import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class InheritanceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // BankAccount a; <-- we are just declaring an object named a of type BankAccount
        // a = new BankAccount(?, ?, ?); <-- we are creating an instance of BankAccount and instantiating it through constructor call
        BankAccount a = new BankAccount(101, "John Doe", 100.00);
        BankAccount b = new BankAccount(105, "Jane Doe", 500.00);
        BankAccount c = new SavingsAccount(111, "Jimmie Doe", 500.00);
        BankAccount d = new CurrentAccount(115, "Jackie Doe", 500.00);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(a);
        accounts.add(b);
        accounts.add(c);
        accounts.add(d);
        a.withdraw(20);
        b.deposit(200);
        c.withdraw(80);
        c.deposit(100);
        d.withdraw(20);
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
    
}
