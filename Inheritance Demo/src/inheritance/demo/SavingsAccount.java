/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo;

/**
 *
 * @author kmhasan
 */
public class SavingsAccount extends BankAccount {

    public SavingsAccount(int accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }
   
    @Override
    public void withdraw(double amount) {
        if (amount < 100) {
            balance = balance - amount;
            balance = balance - 10;
        }
    }
    
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        addInterest();
    }
    
    public void addInterest() {
        balance = balance * 1.10;
    }
}
