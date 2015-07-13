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
public class CurrentAccount extends BankAccount {

    public CurrentAccount(int id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
    }
    
}
