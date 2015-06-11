/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.pos.console;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author kmhasan
 */
public class POSConsoleApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product p1 = new Product(101, "Matador Pen", "Stationery", 5.50);
        Product p2 = new Product(102, "Econo Pen", "Stationery", 7.00);
        Product p3 = new Product(5001, "Aarong Milk", "Dairy", 75.00);
        
        Customer c1 = new Customer(20112, "Md. Ashiqur Rahman", "01711225544");
        Customer c2 = new Customer(20159, "Md. Rakibul Hasan", "0155511221");

        Transaction t1 = new Transaction(c2, p3, 2.5, LocalDate.now());
        
        System.out.printf("List of Products\n");
        System.out.printf("%5d %-20s %-10s %5.2f\n", p1.getProductId(), p1.getProductName(), p1.getProductType(), p1.getUnitPrice());
        System.out.printf("%5d %-20s %-10s %5.2f\n", p2.getProductId(), p2.getProductName(), p2.getProductType(), p2.getUnitPrice());
        System.out.printf("%5d %-20s %-10s %5.2f\n", p3.getProductId(), p3.getProductName(), p3.getProductType(), p3.getUnitPrice());
        
        System.out.printf("\nList of Customers\n");
        System.out.printf("%6d %-25s %11s\n", c1.getCustomerId(), c1.getCustomerName(), c1.getPhoneNumber());
        System.out.printf("%6d %-25s %11s\n", c2.getCustomerId(), c2.getCustomerName(), c2.getPhoneNumber());
        
        System.out.printf("\nTransactions\n");
        System.out.printf("%s %s %s %f %f %f\n", t1.getDate(), t1.getCustomer().getCustomerName(),
                t1.getProduct().getProductName(), t1.getProduct().getUnitPrice(),
                t1.getQuantity(), t1.getBill());
    }
    
}
