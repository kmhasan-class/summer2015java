/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.demo.gui;

/**
 *
 * @author kmhasan
 */
public class Product {
    private int productId;
    private String productName;
    private String category;
    private double unitPrice;

    public Product(int productId, String productName, String category, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }
    
}
