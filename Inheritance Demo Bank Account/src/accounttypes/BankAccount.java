/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounttypes;

/**
 *
 * @author kmhasan
 */
public abstract class BankAccount {
    private int id;
    private String name;
    protected double balance;
    private static int counter = 0;
    
    public BankAccount(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        counter++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance = balance - amount;
    }
    
    public abstract void deposit(double amount);
    
    @Override
    public String toString() {
        return id + " " + name + " " + balance;
    }

    public static int getCounter() {
        return counter;
    }
}
