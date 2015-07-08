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
public class CreditCard extends BankAccount {

    public CreditCard(int accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0)
            balance = balance - amount;
    }
}
