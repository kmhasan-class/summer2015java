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
public class POSConsoleApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product a = new Product(1001, "Matador Pen", "Stationery", 5.00);
        Product b = new Product(2010, "Aarong Milk", "Dairy", 70.00);
        Product c = new Product(5055, "Tomato", "Fresh produce", 45.00);
        Customer c1 = new Customer(1020, "Md. Ashiqur Rahman", "0171111111");
        Customer c2 = new Customer(1021, "Md. Rakibul Hasan", "0172211111");
        Customer c3 = new Customer(1023, "Hasan Tareque", "0172233111");
        Transaction t1 = new Transaction(1, LocalDate.now(), c1, b, 10);
        System.out.printf("Product ID   Product name   Product type   Unit price\n");
        System.out.printf("----------   ------------   ------------   ----------\n");
        System.out.printf("%10d   %-12s   %-13s  %10.2f\n", a.getProductId(), a.getProductName(), a.getProductType(), a.getUnitPrice());
        System.out.printf("%10d   %-12s   %-13s  %10.2f\n", b.getProductId(), b.getProductName(), b.getProductType(), b.getUnitPrice());
        System.out.printf("%10d   %-12s   %-13s  %10.2f\n", c.getProductId(), c.getProductName(), c.getProductType(), c.getUnitPrice());

        System.out.println("Transaction details of selling 10 liter aarong milk to Md. Ashiqur Rahman");
        System.out.printf("Date: %s\n", t1.getTransactionDate());
        System.out.printf("Customer name: %s\n", t1.getCustomer().getCustomerName());
        System.out.printf("Product name: %s\n", t1.getProduct().getProductName());
        System.out.printf("Product price: %.2f\n", t1.getProduct().getUnitPrice());
        System.out.printf("Quantity bought: %.2f\n", t1.getQuantity());
        System.out.printf("Total bill: %.2f\n", t1.getBill());
    }
    
}
