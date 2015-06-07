/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.pos.console;

/**
 *
 * @author kmhasan
 */
public class Customer {
    private int customerId;
    private String customerName;
    private String customerPhoneNumber;

    public Customer(int customerId, String customerName, String customerPhoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setPhoneNumber(String newNumber) {
        this.customerPhoneNumber = newNumber;
    }

}
