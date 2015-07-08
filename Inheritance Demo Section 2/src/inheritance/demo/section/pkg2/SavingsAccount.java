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
public class SavingsAccount extends BankAccount {
    public SavingsAccount(int accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount < 10000 && amount > 0 && amount <= balance)
            balance = balance - amount;
    }
    
    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        balance = balance * 1.10;
    }
}
