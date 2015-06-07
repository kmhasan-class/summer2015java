/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd.ac.seu.pos.console;

/**
 * This class stores the information about products in the store.
 * 
 * @author kmhasan
 */
public class Product {
    private int productId;
    private String productName;
    private String productType;
    private double unitPrice;

    /**
     * Constructor to instantiate a product object
     * 
     * @param productId the id of the product, an integer in the range 1000..9999
     * @param productName the name of the product, a String with less than 100 characters
     * @param productType product type can be any one from "Dairy", "Fresh produce", "Stationery"
     * @param unitPrice selling unit price of the product
     */
    public Product(int productId, String productName, String productType, double unitPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.unitPrice = unitPrice;
    }

    /**
     * Getter method for Product ID
     * @return the id of the product
     */
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
}
