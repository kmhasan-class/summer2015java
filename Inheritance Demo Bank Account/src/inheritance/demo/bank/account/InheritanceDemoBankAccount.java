/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo.bank.account;

import accounttypes.SavingsAccount;
import accounttypes.CurrentAccount;
import accounttypes.BankAccount;
import accounttypes.PrioritizedAccount;
import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class InheritanceDemoBankAccount {
    public InheritanceDemoBankAccount() {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        BankAccount a = new SavingsAccount(101, "Abul", 100);
        BankAccount b = new SavingsAccount(102, "Babul", 100);
        BankAccount c = new CurrentAccount(103, "Kabul", 100);
        accounts.add(a);
        accounts.add(b);
        accounts.add(c);
        ((PrioritizedAccount) b).greetClient();
        for (BankAccount account: accounts)
            account.deposit(100);
        for (BankAccount account: accounts)
            System.out.println(account);
        System.out.println("Total accounts " + BankAccount.getCounter());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InheritanceDemoBankAccount application;
        application = new InheritanceDemoBankAccount();
    }
    
}
