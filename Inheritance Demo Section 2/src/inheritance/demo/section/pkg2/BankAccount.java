/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo.section.pkg2;

/**
 *
 * @author kmhasan
 */
public class BankAccount {
    private int accountNumber;
    private String accountName;
    protected double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance)
            balance = balance - amount;
    }
    
    public void deposit(double amount) {
        if (amount > 0)
            balance = balance + amount;
    }

    @Override
    public String toString() {
        return accountNumber + " " + accountName + " " + balance;
    }

}
