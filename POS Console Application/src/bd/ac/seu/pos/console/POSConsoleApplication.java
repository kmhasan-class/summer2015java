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
        Product p1 = new Product(101, "Matador Pen", "Stationery", 5.50);
        Product p2 = new Product(102, "Econo Pen", "Stationery", 7.00);
        Product p3 = new Product(5001, "Aarong Milk", "Dairy", 75.00);
        System.out.printf("%5d %-20s %-10s %5.2f\n", p1.getProductId(), p1.getProductName(), p1.getProductType(), p1.getUnitPrice());
        System.out.printf("%5d %-20s %-10s %5.2f\n", p2.getProductId(), p2.getProductName(), p2.getProductType(), p2.getUnitPrice());
        System.out.printf("%5d %-20s %-10s %5.2f\n", p3.getProductId(), p3.getProductName(), p3.getProductType(), p3.getUnitPrice());
    }
    
}
