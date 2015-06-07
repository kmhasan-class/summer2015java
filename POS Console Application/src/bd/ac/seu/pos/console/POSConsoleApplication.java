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
public class POSConsoleApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product a = new Product(1001, "Matador Pen", "Stationery", 5.00);
        Product b = new Product(2010, "Aarong Milk", "Dairy", 70.00);
        Product c = new Product(5055, "Tomato", "Fresh produce", 45.00);
        
        System.out.printf("Product ID   Product name   Product type   Unit price\n");
        System.out.printf("----------   ------------   ------------   ----------\n");
        System.out.printf("%10d   %-12s   %-13s  %10.2f\n", a.getProductId(), a.getProductName(), a.getProductType(), a.getUnitPrice());
        System.out.printf("%10d   %-12s   %-13s  %10.2f\n", b.getProductId(), b.getProductName(), b.getProductType(), b.getUnitPrice());
        System.out.printf("%10d   %-12s   %-13s  %10.2f\n", c.getProductId(), c.getProductName(), c.getProductType(), c.getUnitPrice());
    }
    
}
