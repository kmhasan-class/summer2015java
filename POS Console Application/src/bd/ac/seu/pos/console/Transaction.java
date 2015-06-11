/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.pos.console;

import java.time.LocalDate;

/**
 *
 * @author kmhasan
 */
public class Transaction {
    private Customer customer;
    private Product product;
    private double quantity;
    private LocalDate date;

    public Transaction(Customer customer, Product product, double quantity, LocalDate date) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public double getBill() {
        double bill;
        bill = this.quantity * product.getUnitPrice();
        bill = bill * 1.15;
        return bill;
    }
}
