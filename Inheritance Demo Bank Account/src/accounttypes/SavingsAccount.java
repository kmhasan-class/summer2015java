/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounttypes;

import accounttypes.BankAccount;

/**
 *
 * @author kmhasan
 */
public class SavingsAccount extends BankAccount implements PrioritizedAccount {

    public SavingsAccount(int id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount + 10;
    }

    @Override
    public void greetClient() {
        System.out.println("Hello there");
    }
}
