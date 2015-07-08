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
public class InheritanceDemoSection2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount a = new BankAccount(154, "Md. Rakibul Hasan", 500.0);
        a.deposit(1000);
        a.withdraw(10);
        a.withdraw(2000);
        a.balance = 100000;
        System.out.println(a);
        SavingsAccount b = new SavingsAccount(120, "Shahriar Manzoor", 20000.0);
        b.withdraw(100);
        b.deposit(1000);
        b.withdraw(15000);
        CreditCard c = new CreditCard(113, "Amlan Barman", 0.00);
        c.withdraw(1000);
        System.out.println(c);
        System.out.println(b);
    }
    
}
