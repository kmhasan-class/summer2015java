/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.gui;

/**
 *
 * @author kmhasan
 */
public class Product {
    private int productId;
    private String productName;
    private String productType;
    private double unitPrice;

    public Product(int productId, String prodcutName, String productType, double unitPrice) {
        this.productId = productId;
        this.productName = prodcutName;
        this.productType = productType;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProdcutName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void print() {
        System.out.printf("Product ID: %d\n", this.productId);
        System.out.printf("Product Name: %s\n", this.productName);
        System.out.printf("Product Type: %s\n", this.productType);
        System.out.printf("Unit Price: %f\n", this.unitPrice);
    }

    public String toString() {
        return "Product ID: " + productId + "\nProduct Name: " + productName + "\nProduct Type: " + productType + "\nUnit Price: " + unitPrice;
    }
    
}
