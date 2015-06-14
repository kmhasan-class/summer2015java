/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant.browser;

/**
 *
 * @author kmhasan
 */
public class Restaurant {
    private String name;
    private String area;
    private String cuisine;
    private String operationHours;
    private String address;
    private String phoneNumber;

    public Restaurant(String name, String area, String cuisine, String operationHours, String address, String phoneNumber) {
        this.name = name;
        this.area = area;
        this.cuisine = cuisine;
        this.operationHours = operationHours;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getArea() {
        return area;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getOperationHours() {
        return operationHours;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void printToConsole() {
        System.out.println(this.toString());
    }
    
    public String toString() {
        return this.name + "\n" 
                + this.area + "\n"
                + this.cuisine + "\n"
                + this.operationHours + "\n"
                + this.address + "\n"
                + this.phoneNumber;
    }
}
