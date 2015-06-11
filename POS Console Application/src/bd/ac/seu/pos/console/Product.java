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
public class Product {
    private int productId;
    private String productName;
    private String productType;
    private double unitPrice;

    public Product(int productId, String productName, String productType, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.unitPrice = unitPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
